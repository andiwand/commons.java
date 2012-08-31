package at.andiwand.common.io;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;


public class CountingReader extends FilterReader {
	
	private int count;
	
	public CountingReader(Reader in) {
		super(in);
	}
	
	public int count() {
		return count;
	}
	
	@Override
	public int read() throws IOException {
		int read = in.read();
		if (read != -1) count++;
		return read;
	}
	
	@Override
	public int read(char[] cbuf) throws IOException {
		int read = in.read(cbuf);
		if (read != -1) count += read;
		return read;
	}
	
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int read = in.read(cbuf, off, len);
		if (read != -1) count += read;
		return read;
	}
	
	@Override
	public long skip(long n) throws IOException {
		long skipped = in.skip(n);
		count += skipped;
		return skipped;
	}
	
}