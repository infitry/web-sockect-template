package ib.websocket.demo.param;

public class MessageParam {
	private int chatSeq;
	private String userId;
	private String from;
	private String text;
	
	public int getChatSeq() {
		return chatSeq;
	}
	public void setChatSeq(int chatSeq) {
		this.chatSeq = chatSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
