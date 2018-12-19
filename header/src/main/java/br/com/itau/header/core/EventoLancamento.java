package br.com.itau.header.core;

import java.util.Date;
import java.util.UUID;

public class EventoLancamento {
	private String eventType;
	private String eventTypeVersion;
	private String cloudEventsVersion;
	private String source;
	private UUID eventID;
	private Date eventTime;
	private String contentType;
	private String extensions;
	private Data data;

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventTypeVersion() {
		return eventTypeVersion;
	}

	public void setEventTypeVersion(String eventTypeVersion) {
		this.eventTypeVersion = eventTypeVersion;
	}

	public String getCloudEventsVersion() {
		return cloudEventsVersion;
	}

	public void setCloudEventsVersion(String cloudEventsVersion) {
		this.cloudEventsVersion = cloudEventsVersion;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public UUID getEventID() {
		return eventID;
	}

	public void setEventID(UUID eventID) {
		this.eventID = eventID;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getExtensions() {
		return extensions;
	}

	public void setExtensions(String extensions) {
		this.extensions = extensions;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
}
