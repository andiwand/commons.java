package at.andiwand.common.util.collections.primitive;

public abstract class AbstractLongIterator implements PrimitiveIterator<Long> {
	
	public abstract long nextValue();
	
	@Override
	public Long next() {
		return nextValue();
	}
	
	@Override
	public byte nextByte() {
		return (byte) nextValue();
	}
	
	@Override
	public char nextChar() {
		return (char) nextValue();
	}
	
	@Override
	public short nextShort() {
		return (short) nextValue();
	}
	
	@Override
	public int nextInt() {
		return (int) nextValue();
	}
	
	@Override
	public long nextLong() {
		return (long) nextValue();
	}
	
	@Override
	public float nextFloat() {
		return (float) nextValue();
	}
	
	@Override
	public double nextDouble() {
		return (double) nextValue();
	}
	
}