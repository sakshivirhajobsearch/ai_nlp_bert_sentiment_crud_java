package com.ai.nlp.bert.sentiment.crud;

import com.ai.nlp.bert.sentiment.crud.controller.SentimentController;
import com.ai.nlp.bert.sentiment.crud.service.SentimentService;

public class SentimentApplication {
	
	public static void main(String[] args) throws Exception {
		SentimentService service = new SentimentService();
		SentimentController.init(service);
	}
}
