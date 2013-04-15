package at.andiwand.commons.util.object;

public interface ObjectMatcher<T> {
	
	public boolean matches(T o);
	
	public Class<T> getMatchedClass();
	
	public boolean equals(Object obj);
	
}