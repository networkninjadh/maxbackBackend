package com.maxback.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxback.models.Session;
import com.maxback.repositories.SessionRepository;
import com.opentok.MediaMode;
import com.opentok.OpenTok;
import com.opentok.SessionProperties;
import com.opentok.exception.OpenTokException;

@Service
public class VideoStreamingService {

	final int API_KEY = 0;
	final String API_SECRET = " ";
	
	@Autowired
	private SessionRepository sessions;
	
	OpenTok sdk = new OpenTok(API_KEY, API_SECRET);
	
	//new session
	public Session createSession(Long customerId, Long employeeId) throws OpenTokException {
		SessionProperties sessionProperties = new SessionProperties.Builder()
				.mediaMode(MediaMode.ROUTED)
				.build();
		com.opentok.Session session = sdk.createSession(sessionProperties);
		Session mySession = new Session();
		mySession.setCustomerId(customerId);
		mySession.setEmployeeId(employeeId);
		mySession.setOpenTokSessionId(session.getSessionId());
		return sessions.save(mySession);
	}
	
	//generate connection tokens for users
	public String createToken(String SessionId) throws OpenTokException {
		return sdk.generateToken(SessionId);
	}
	
	//connect to session
	//close session
	//close all sessions
	
}
