package com.ai.nlp.bert.sentiment.crud.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ai.nlp.bert.sentiment.crud.model.SentimentData;
import com.ai.nlp.bert.sentiment.crud.util.BertSentimentAnalyzer;

public class SentimentServiceTest {

	private SentimentService service;
	private BertSentimentAnalyzer mockAnalyzer;

	@BeforeEach
	public void setup() {
		mockAnalyzer = mock(BertSentimentAnalyzer.class);
		service = new SentimentService(mockAnalyzer);
	}

	@Test
	public void testCreate() throws Exception {
		when(mockAnalyzer.predictSentiment("I love this")).thenReturn("Positive");

		SentimentData sentiment = service.create("I love this");
		assertEquals("Positive", sentiment.getSentiment());
	}
}
