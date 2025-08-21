package com.ai.nlp.bert.sentiment.crud.controller;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import com.ai.nlp.bert.sentiment.crud.model.SentimentData;
import com.ai.nlp.bert.sentiment.crud.service.SentimentService;
import com.google.gson.Gson;

public class SentimentController {
	
	private static Gson gson = new Gson();

	public static void init(SentimentService service) {
		post("/sentiment", (req, res) -> {
			String text = gson.fromJson(req.body(), SentimentData.class).getText();
			SentimentData data = service.create(text);
			return gson.toJson(data);
		});

		get("/sentiment", (req, res) -> gson.toJson(service.getRepository().getAll()));

		get("/sentiment/:id", (req, res) -> {
			int id = Integer.parseInt(req.params(":id"));
			return gson.toJson(service.getRepository().get(id));
		});

		put("/sentiment/:id", (req, res) -> {
			int id = Integer.parseInt(req.params(":id"));
			String text = gson.fromJson(req.body(), SentimentData.class).getText();
			String sentiment = service.getRepository().get(id).getSentiment();
			return gson.toJson(service.getRepository().update(id, text, sentiment));
		});

		delete("/sentiment/:id", (req, res) -> {
			int id = Integer.parseInt(req.params(":id"));
			return gson.toJson(service.getRepository().delete(id));
		});
	}
}
