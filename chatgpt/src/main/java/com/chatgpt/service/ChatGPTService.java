package com.chatgpt.service;

import java.io.UnsupportedEncodingException;
import java.net.http.HttpClient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.chatgpt.model.ChatGPTRequest;
import com.chatgpt.model.ChatGPTResponse;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ChatGPTService {

	@Value("${OPEN_API_URL}")
	private String OPEN_API_URL;

	@Value("${OPEN_API_KEY}")
	private String OPEN_API_KEY;

	public String processSearch(String query) throws UnsupportedEncodingException {

		ChatGPTRequest chatGPTRequest = new ChatGPTRequest();
		chatGPTRequest.setPrompt(query);

		Gson gson = new Gson();
		String jsonRequest = gson.toJson(chatGPTRequest);

		log.info("Request body :"+jsonRequest);

		HttpPost post = new HttpPost(OPEN_API_URL);
		post.setHeader("Content-Type", "application/json");
		post.setHeader("Authorization", "BEARER " + OPEN_API_KEY);

		String requestBody = jsonRequest;

		StringEntity entity = new StringEntity(requestBody);
		post.setEntity(entity);

		try {
			CloseableHttpClient client = HttpClients.custom().build();
			CloseableHttpResponse response = client.execute(post);
			String responsebody = EntityUtils.toString(response.getEntity());
			log.info("responsebody "+ responsebody);
			ChatGPTResponse chatResponse = gson.fromJson(responsebody, ChatGPTResponse.class);

			return chatResponse.getChoices().get(0).getText();
		} catch (Exception e) {
			return "failed  " + e.getMessage();
		}

	}

}
