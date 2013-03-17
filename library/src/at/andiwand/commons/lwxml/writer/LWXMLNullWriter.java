package at.andiwand.commons.lwxml.writer;

import at.andiwand.commons.lwxml.LWXMLEvent;


public class LWXMLNullWriter extends LWXMLWriter {
	
	public static final LWXMLNullWriter NULL = new LWXMLNullWriter();
	
	private LWXMLEvent currentEvent;
	
	protected LWXMLNullWriter() {}
	
	@Override
	public LWXMLEvent getCurrentEvent() {
		return currentEvent;
	}
	
	@Override
	public boolean isCurrentEventWritten() {
		return true;
	}
	
	@Override
	public void writeEvent(LWXMLEvent event) {
		currentEvent = event;
	}
	
	@Override
	public void writeEvent(LWXMLEvent event, String value) {
		currentEvent = event;
	}
	
	@Override
	public void write(int c) {}
	
	@Override
	public void write(char[] cbuf, int off, int len) {}
	
}