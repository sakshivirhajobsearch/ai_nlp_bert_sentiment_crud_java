package com.ai.nlp.bert.sentiment.crud.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Disabled to prevent external model loading during unit test")
public class BertSentimentAnalyzerTest {

	@Test
	void testSentimentPrediction() throws Exception {
		BertSentimentAnalyzer analyzer = new BertSentimentAnalyzer();
		String result = analyzer.predictSentiment("I love this product!");
		assertTrue(result.equalsIgnoreCase("Positive") || result.equalsIgnoreCase("Negative")
				|| result.equalsIgnoreCase("Neutral"));
	}
}
