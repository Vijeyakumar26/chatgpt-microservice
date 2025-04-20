package com.chatgpt.service;

import org.springframework.stereotype.Service;

import com.chatgpt.model.ChatGPTRequest;

@Service
public class ChatGPTService {
	
	public String processSearch(String query) {
		
		ChatGPTRequest chatGPTRequest = new ChatGPTRequest();
		chatGPTRequest.setPrompt(query);
		return "";
	}
	
}
