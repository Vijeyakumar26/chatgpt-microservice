package com.chatgpt.model;

import java.util.List;

import lombok.Data;

@Data
public class ChatGPTResponse {
	private List<ChatGPTChoice> choices;
 }
