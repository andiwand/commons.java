package at.andiwand.common.io;

import java.io.IOException;
import java.io.InputStream;


public class UncloseableInputStream extends DelegationInputStream {
	
	public UncloseableInputStream(InputStream in) {
		super(in);
	}
	
	@Override
	public void close() throws IOException {
		in = ClosedInputStream.CLOSED_INPUT_STREAM;
	}
	
}