package org.intake;

public class Message {
	public int msgID;
	public int senderID;
	public int recipientID;
	public String subject;
	public String body;
	public String timestamp;
	public int threadID;
	
	public Message(int msgID, int senderID, int recipientID,String subject, String body, String timestamp, int threadID) {
		this.msgID = msgID;
		this.senderID = senderID;
		this.recipientID = recipientID;
		this.subject = subject;
		this.body = body;
		this.timestamp = timestamp;
		this.threadID = threadID;
	}
	
	//Getters
	public int getmsgID() {
        return msgID;
    }

    public int getSenderID() {
        return senderID;
    }

    public int getRecipientID() {
        return recipientID;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getThreadID() {
        return threadID;
    }
    
    public String getSenderName() {
    	return DatabaseSetup.getSenderNameByID(this.senderID);
    }
}
