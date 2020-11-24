package ib.websocket.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ib.websocket.demo.param.MessageParam;

@RestController
public class WebSocketController {
	@Autowired
	private SimpMessagingTemplate msgTmpl;

	@MessageMapping("/send")
	@SendTo("/message/send")
	public MessageParam hello(MessageParam message) {
		System.out.println("******* /message/send ********");
		System.out.println("from : " + message.getFrom());
		System.out.println("message : " + message.getText());
		return message;
	}
	
	@MessageMapping("/send3")
	public MessageParam hello3(MessageParam message) {
		System.out.println("******* /message/send ********");
		System.out.println("chatSeq : " + message.getChatSeq());
		System.out.println("from : " + message.getFrom());
		System.out.println("message : " + message.getText());
		
		msgTmpl.convertAndSend("/message/send/" + message.getChatSeq(), message);
		
		return message;
	}
	
	
	@MessageMapping("/send2")
	@SendToUser("/test/send")
	public MessageParam hello2(MessageParam message) {
		System.out.println("******* /test/send ********");
		System.out.println("from : " + message.getFrom());
		System.out.println("message : " + message.getText());
		return message;
	}
}