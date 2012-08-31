package at.andiwand.common.lwxml;

import java.util.Set;

import at.andiwand.common.util.ArrayUtil;


public enum LWXMLEvent {
	
	PROCESSING_INSTRUCTION_TARGET(true),
	PROCESSING_INSTRUCTION_DATA(true),
	COMMENT(true),
	START_ELEMENT(true),
	END_EMPTY_ELEMENT(false),
	END_ELEMENT(true),
	ATTRIBUTE_NAME(true),
	ATTRIBUTE_VALUE(true),
	END_ATTRIBUTE_LIST(false),
	CHARACTERS(true),
	CDATA(true),
	START_DOCUMENT(false),
	END_DOCUMENT(false);
	
	static {
		Set<LWXMLEvent> tmp = ArrayUtil.toHashSet(
				PROCESSING_INSTRUCTION_TARGET, COMMENT, START_ELEMENT,
				END_ELEMENT, CHARACTERS, CDATA, END_DOCUMENT);
		
		PROCESSING_INSTRUCTION_TARGET
				.setFollowingEvents(PROCESSING_INSTRUCTION_DATA);
		PROCESSING_INSTRUCTION_DATA.setFollowingEvents(tmp);
		COMMENT.setFollowingEvents(tmp);
		START_ELEMENT.setFollowingEvents(ATTRIBUTE_NAME, END_ATTRIBUTE_LIST);
		END_EMPTY_ELEMENT.setFollowingEvents(tmp);
		END_ELEMENT.setFollowingEvents(tmp);
		ATTRIBUTE_NAME.setFollowingEvents(ATTRIBUTE_VALUE);
		ATTRIBUTE_VALUE.setFollowingEvents(ATTRIBUTE_NAME, END_ATTRIBUTE_LIST);
		END_ATTRIBUTE_LIST.setFollowingEvents(PROCESSING_INSTRUCTION_TARGET,
				COMMENT, START_ELEMENT, END_EMPTY_ELEMENT, END_ELEMENT,
				CHARACTERS, CDATA, END_DOCUMENT);
		CHARACTERS.setFollowingEvents(tmp);
		CDATA.setFollowingEvents(tmp);
		START_DOCUMENT.setFollowingEvents(PROCESSING_INSTRUCTION_TARGET,
				COMMENT, START_ELEMENT, CHARACTERS, CDATA, END_DOCUMENT);
		END_DOCUMENT.setFollowingEvents();
		
		for (LWXMLEvent event : values()) {
			if (event.followingEvents.size() != 1) continue;
			
			LWXMLEvent followingEvent = event.followingEvents.iterator().next();
			event.hasFollowingValue = followingEvent.hasValue;
		}
	}
	
	public static boolean isStarting(LWXMLEvent event) {
		return isFollowingEvent(START_DOCUMENT, event);
	}
	
	public static boolean isEnding(LWXMLEvent event) {
		return isFollowingEvent(event, END_DOCUMENT);
	}
	
	public static boolean isFollowingEvent(LWXMLEvent event,
			LWXMLEvent followingEvent) {
		if (event == null) return false;
		return event.followingEvents.contains(followingEvent);
	}
	
	public static boolean hasValue(LWXMLEvent event) {
		if (event == null) return false;
		return event.hasValue;
	}
	
	public static boolean hasFollowingValue(LWXMLEvent event) {
		if (event == null) return false;
		return event.hasFollowingValue;
	}
	
	private final boolean hasValue;
	
	private Set<LWXMLEvent> followingEvents;
	private boolean hasFollowingValue;
	
	private LWXMLEvent(boolean hasValue) {
		this.hasValue = hasValue;
	}
	
	private void setFollowingEvents(Set<LWXMLEvent> followingEvents) {
		this.followingEvents = followingEvents;
	}
	
	private void setFollowingEvents(LWXMLEvent... followingEvents) {
		setFollowingEvents(ArrayUtil.toHashSet(followingEvents));
	}
	
	public boolean isEndElement() {
		return (this == END_EMPTY_ELEMENT) || (this == END_ELEMENT);
	}
	
	public boolean isStartingEvent() {
		return isStarting(this);
	}
	
	public boolean isEndingEvent() {
		return isEnding(this);
	}
	
	public boolean isFollowingEvent(LWXMLEvent followingEvent) {
		return isFollowingEvent(this, followingEvent);
	}
	
	public boolean hasValue() {
		return hasValue;
	}
	
	public boolean hasFollowingValue() {
		return hasFollowingValue;
	}
	
}