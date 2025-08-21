package com.ai.nlp.bert.sentiment.crud.service;

import com.ai.nlp.bert.sentiment.crud.model.SentimentData;
import com.ai.nlp.bert.sentiment.crud.repository.SentimentRepository;
import com.ai.nlp.bert.sentiment.crud.util.BertSentimentAnalyzer;

public class SentimentService {

	public SentimentRepository repository = new SentimentRepository();
	public BertSentimentAnalyzer analyzer;

	public SentimentService() throws Exception {
		analyzer = new BertSentimentAnalyzer();
	}

	public SentimentService(BertSentimentAnalyzer analyzer) {
		this.analyzer = analyzer;
	}

	public SentimentData create(String text) throws Exception {
		String sentiment = analyzer.predictSentiment(text);
		return repository.create(text, sentiment);
	}

	public SentimentRepository getRepository() {
		return repository;
	}
}
