package at.andiwand.common.io;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;


public class EmptyReader extends Reader {
	
	@Override
	public int read() throws IOException {
		return -1;
	}
	
	@Override
	public int read(char[] cbuf) throws IOException {
		return -1;
	}
	
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		return -1;
	}
	
	@Override
	public int read(CharBuffer target) throws IOException {
		return -1;
	}
	
	@Override
	public long skip(long n) throws IOException {
		return 0;
	}
	
	@Override
	public boolean ready() throws IOException {
		return true;
	}
	
	@Override
	public void close() throws IOException {}
	
}