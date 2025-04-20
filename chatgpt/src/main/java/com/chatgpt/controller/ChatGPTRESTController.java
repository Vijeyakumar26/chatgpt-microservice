package com.chatgpt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatgpt.model.SearchRequest;
import com.chatgpt.service.ChatGPTService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class ChatGPTRESTController {
	
	
	private ChatGPTService chatGPTService;
	
	public ChatGPTRESTController(ChatGPTService chatGPTService) {
		this.chatGPTService = chatGPTService;
	}

	@PostMapping("/searchChatGPT")	
	public String search(@RequestBody SearchRequest searchRequest) {
		log.info("Starting with search request with ChatGPT"+ searchRequest.getQuery());
		//return searchRequest.getQuery();
		return chatGPTService.processSearch(searchRequest.getQuery());
	}
	
}
