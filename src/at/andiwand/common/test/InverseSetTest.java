package at.andiwand.common.test;

import at.andiwand.common.util.collections.InverseSet;


public class InverseSetTest {
	
	public static void main(String[] args) {
		InverseSet<String> infiniteSet = new InverseSet<String>();
		
		System.out.println(infiniteSet.inverseSet().size());
		System.out.println(infiniteSet);
		System.out.println();
		
		String a = "asdf";
		System.out.println(a);
		System.out.println(infiniteSet.contains(a));
		System.out.println();
		
		infiniteSet.removeElement("asdf");
		System.out.println(infiniteSet.inverseSet().size());
		System.out.println(infiniteSet);
		System.out.println();
		
		System.out.println(a);
		System.out.println(infiniteSet.contains(a));
		System.out.println();
		
		infiniteSet.add("asdf");
		System.out.println(infiniteSet.inverseSet().size());
		System.out.println(infiniteSet);
		System.out.println();
		
		System.out.println(a);
		System.out.println(infiniteSet.contains(a));
		System.out.println();
	}
	
}