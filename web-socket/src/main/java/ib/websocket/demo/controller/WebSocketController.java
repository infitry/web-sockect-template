package ib.websocket.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import ib.websocket.demo.param.MessageParam;

@RestController
public class WebSocketController {

	@MessageMapping("/send")
	@SendTo("/message/send")
	public MessageParam hello(MessageParam message) {
		System.out.println("from : " + message.getFrom());
		System.out.println("message : " + message.getText());
		return message;
	}
	
	@MessageMapping("/send2")
	@SendTo("/message/send2")
	public MessageParam hello2(MessageParam message) {
		System.out.println("from : " + message.getFrom());
		System.out.println("message : " + message.getText());
		return message;
	}
}
