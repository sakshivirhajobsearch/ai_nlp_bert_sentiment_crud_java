package com.ai.nlp.bert.sentiment.crud.util;

import java.io.IOException;

import ai.djl.ModelException;
import ai.djl.inference.Predictor;
import ai.djl.modality.Classifications;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ModelZoo;
import ai.djl.training.util.ProgressBar;
import ai.djl.translate.TranslateException;
import ai.djl.Application;

public class BertSentimentAnalyzer {

	private Predictor<String, Classifications> predictor;

	public BertSentimentAnalyzer() throws ModelException, IOException {
		Criteria<String, Classifications> criteria = Criteria.builder().setTypes(String.class, Classifications.class)
				.optApplication(Application.NLP.SENTIMENT_ANALYSIS).optFilter("backbone", "distilbert") // Works better
																										// than "bert"
				.optEngine("PyTorch") // Ensure engine compatibility
				.optProgress(new ProgressBar()).build();

		predictor = ModelZoo.loadModel(criteria).newPredictor();
	}

	public String predictSentiment(String text) throws TranslateException {
		Classifications classifications = predictor.predict(text);
		return classifications.best().getClassName();
	}
}
