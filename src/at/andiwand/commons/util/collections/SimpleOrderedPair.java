package at.andiwand.commons.util.collections;

public class SimpleOrderedPair<E> extends OrderedPair<E, E> {
	
	public SimpleOrderedPair(E element1, E element2) {
		super(element1, element2);
	}
	
	public SimpleOrderedPair<E> setElement1(E element1) {
		return new SimpleOrderedPair<E>(element1, element2);
	}
	
	public SimpleOrderedPair<E> setElement2(E element2) {
		return new SimpleOrderedPair<E>(element1, element2);
	}
	
}