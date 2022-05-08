package tn.dari.spring.entity;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class SMS {
	
	public static final String ACCOUNT_SID = "AC623eab300e4fb83165a966ce6ad5e9f0";
	public static final String AUTH_TOKEN = "d1b214e53f656ef5b76db373f0f929da";
	String messageContent;
	Long sendTo;
	
	
	public SMS(String messageContent, Long sendTo) {
		this.messageContent = messageContent;
		this.sendTo = sendTo;
	}

	
	

	public boolean send() {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(
				new com.twilio.type.PhoneNumber("+216"+sendTo.toString()),
				new com.twilio.type.PhoneNumber("+18507714598"), 
				messageContent).create();

		if (message.getSid() != null) {
			return true;
		}
		return false;
	}


}
