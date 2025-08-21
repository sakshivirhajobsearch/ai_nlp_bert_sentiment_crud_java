package com.ai.nlp.bert.sentiment.crud.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.ai.nlp.bert.sentiment.crud.model.SentimentData;

public class SentimentRepository {
	private Map<Integer, SentimentData> db = new HashMap<>();
	private int currentId = 1;

	public SentimentData create(String text, String sentiment) {
		SentimentData data = new SentimentData(currentId++, text, sentiment);
		db.put(data.getId(), data);
		return data;
	}

	public Collection<SentimentData> getAll() {
		return db.values();
	}

	public SentimentData get(int id) {
		return db.get(id);
	}

	public SentimentData update(int id, String newText, String newSentiment) {
		SentimentData data = db.get(id);
		if (data != null) {
			data.setText(newText);
			data.setSentiment(newSentiment);
		}
		return data;
	}

	public boolean delete(int id) {
		return db.remove(id) != null;
	}
}
