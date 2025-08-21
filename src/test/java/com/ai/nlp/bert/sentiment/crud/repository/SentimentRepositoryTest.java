package com.ai.nlp.bert.sentiment.crud.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ai.nlp.bert.sentiment.crud.model.SentimentData;

public class SentimentRepositoryTest {

	@Test
	void testCreateAndGet() {
		SentimentRepository repo = new SentimentRepository();
		SentimentData data = repo.create("Test text", "Positive");
		assertNotNull(data);
		assertEquals("Test text", data.getText());
		assertEquals("Positive", data.getSentiment());
		assertEquals(data, repo.get(data.getId()));
	}

	@Test
	void testUpdate() {
		SentimentRepository repo = new SentimentRepository();
		SentimentData data = repo.create("Old text", "Neutral");
		repo.update(data.getId(), "New text", "Negative");

		SentimentData updated = repo.get(data.getId());
		assertEquals("New text", updated.getText());
		assertEquals("Negative", updated.getSentiment());
	}

	@Test
	void testDelete() {
		SentimentRepository repo = new SentimentRepository();
		SentimentData data = repo.create("To be deleted", "Negative");
		assertTrue(repo.delete(data.getId()));
		assertNull(repo.get(data.getId()));
	}
}
