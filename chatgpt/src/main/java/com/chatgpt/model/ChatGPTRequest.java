package com.chatgpt.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ChatGPTRequest {
	private String model = "babbage-002";
	private String prompt;
	private int temperature = 1;
	@SerializedName(value = "max_tokens")
	private int maxTokens = 100;
}
