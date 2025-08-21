package com.ai.nlp.bert.sentiment.crud.model;

public class SentimentData {
	private int id;
	private String text;
	private String sentiment;

	public SentimentData() {
	}

	public SentimentData(int id, String text, String sentiment) {
		this.id = id;
		this.text = text;
		this.sentiment = sentiment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSentiment() {
		return sentiment;
	}

	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}
}
