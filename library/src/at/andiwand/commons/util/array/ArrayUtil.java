package at.andiwand.commons.util.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.NoSuchElementException;

import at.andiwand.commons.math.MathUtil;
import at.andiwand.commons.util.collection.CollectionUtil;

// TODO: improve attribute names
// TODO: implement array methods with offset and length
// TODO: avoid redundant code?
public class ArrayUtil {

    public static final boolean[] EMPTY_BOOLEAN_ARRAY = {};
    public static final byte[] EMPTY_BYTE_ARRAY = {};
    public static final char[] EMPTY_CHAR_ARRAY = {};
    public static final short[] EMPTY_SHORT_ARRAY = {};
    public static final int[] EMPTY_INT_ARRAY = {};
    public static final long[] EMPTY_LONG_ARRAY = {};
    public static final float[] EMPTY_FLOAT_ARRAY = {};
    public static final double[] EMPTY_DOUBLE_ARRAY = {};
    public static final Object[] EMPTY_OBJECT_ARRAY = {};

    public static <E> E getFirstNotNull(E... array) {
	E element;

	for (int i = 0; i < array.length; i++) {
	    element = array[i];
	    if (element != null)
		return element;
	}

	return null;
    }

    public static <E> E getFirstNotNull(E[] array, int off, int len) {
	int end = off + len;
	E element;

	for (int i = off; i < end; i++) {
	    element = array[i];
	    if (element != null)
		return element;
	}

	return null;
    }

    public static int getEqualCount(Object object, Object... array) {
	int result = 0;

	for (int i = 0; i < array.length; i++) {
	    if (object.equals(array[i]))
		result++;
	}

	return result;
    }

    public static int getEqualCount(Object object, Object[] array, int off,
	    int len) {
	int end = off + len;
	int result = 0;

	for (int i = off; i < end; i++) {
	    if (object.equals(array[i]))
		result++;
	}

	return result;
    }

    public static int getReferenceCount(Object object, Object... array) {
	int result = 0;

	for (int i = 0; i < array.length; i++) {
	    if (object == array[i])
		result++;
	}

	return result;
    }

    public static int getReferenceCount(Object object, Object[] array, int off,
	    int len) {
	int end = off + len;
	int result = 0;

	for (int i = off; i < end; i++) {
	    if (object == array[i])
		result++;
	}

	return result;
    }

    public static int getNullCount(Object... array) {
	int result = 0;

	for (int i = 0; i < array.length; i++) {
	    if (array[i] == null)
		result++;
	}

	return result;
    }

    public static int getNullCount(Object[] array, int off, int len) {
	int end = off + len;
	int result = 0;

	for (int i = off; i < end; i++) {
	    if (array[i] == null)
		result++;
	}

	return result;
    }

    public static int getNotNullCount(Object... array) {
	int result = 0;

	for (int i = 0; i < array.length; i++) {
	    if (array[i] != null)
		result++;
	}

	return result;
    }

    public static int getNotNullCount(Object[] array, int off, int len) {
	int end = off + len;
	int result = 0;

	for (int i = off; i < end; i++) {
	    if (array[i] != null)
		result++;
	}

	return result;
    }

    @SuppressWarnings("unchecked")
    public static <E> E[] getNotNullArray(E... array) {
	int resultLength = getNotNullCount(array);
	E[] result = (E[]) Array.newInstance(array.getClass()
		.getComponentType(), resultLength);
	E element;

	for (int i = 0, j = 0; i < array.length; i++) {
	    element = array[i];
	    if (element != null)
		result[j++] = element;
	}

	return result;
    }

    @SuppressWarnings("unchecked")
    public static <E> E[] getNotNullArray(E[] array, int off, int len) {
	int end = off + len;
	int resultLength = getNotNullCount(array, off, len);
	E[] result = (E[]) Array.newInstance(array.getClass()
		.getComponentType(), resultLength);
	E element;

	for (int i = off, j = 0; i < end; i++) {
	    element = array[i];
	    if (element != null)
		result[j++] = element;
	}

	return result;
    }

    public static <T extends Collection<? super E>, E> T toCollection(T c,
	    E... array) {
	CollectionUtil.addAll(c, array);
	return c;
    }

    public static <T extends Collection<? super Boolean>, E> T toCollection(
	    T c, boolean... array) {
	CollectionUtil.addAll(c, array);
	return c;
    }

    public static <T extends Collection<? super Byte>, E> T toCollection(T c,
	    byte... array) {
	CollectionUtil.addAll(c, array);
	return c;
    }

    public static <T extends Collection<? super Character>, E> T toCollection(
	    T c, char... array) {
	CollectionUtil.addAll(c, array);
	return c;
    }

    public static <T extends Collection<? super Short>, E> T toCollection(T c,
	    short... array) {
	CollectionUtil.addAll(c, array);
	return c;
    }

    public static <T extends Collection<? super Integer>, E> T toCollection(
	    T c, int... array) {
	CollectionUtil.addAll(c, array);
	return c;
    }

    public static <T extends Collection<? super Long>, E> T toCollection(T c,
	    long... array) {
	CollectionUtil.addAll(c, array);
	return c;
    }

    public static <T extends Collection<? super Float>, E> T toCollection(T c,
	    float... array) {
	CollectionUtil.addAll(c, array);
	return c;
    }

    public static <T extends Collection<? super Double>, E> T toCollection(T c,
	    double... array) {
	CollectionUtil.addAll(c, array);
	return c;
    }

    public static <T extends Collection<? super E>, E> T toCollection(T c,
	    E[] array, int off, int len) {
	CollectionUtil.addAll(c, array, off, len);
	return c;
    }

    public static <T extends Collection<? super Boolean>, E> T toCollection(
	    T c, boolean[] array, int off, int len) {
	CollectionUtil.addAll(c, array, off, len);
	return c;
    }

    public static <T extends Collection<? super Byte>, E> T toCollection(T c,
	    byte[] array, int off, int len) {
	CollectionUtil.addAll(c, array, off, len);
	return c;
    }

    public static <T extends Collection<? super Character>, E> T toCollection(
	    T c, char[] array, int off, int len) {
	CollectionUtil.addAll(c, array, off, len);
	return c;
    }

    public static <T extends Collection<? super Short>, E> T toCollection(T c,
	    short[] array, int off, int len) {
	CollectionUtil.addAll(c, array, off, len);
	return c;
    }

    public static <T extends Collection<? super Integer>, E> T toCollection(
	    T c, int[] array, int off, int len) {
	CollectionUtil.addAll(c, array, off, len);
	return c;
    }

    public static <T extends Collection<? super Long>, E> T toCollection(T c,
	    long[] array, int off, int len) {
	CollectionUtil.addAll(c, array, off, len);
	return c;
    }

    public static <T extends Collection<? super Float>, E> T toCollection(T c,
	    float[] array, int off, int len) {
	CollectionUtil.addAll(c, array, off, len);
	return c;
    }

    public static <T extends Collection<? super Double>, E> T toCollection(T c,
	    double[] array, int off, int len) {
	CollectionUtil.addAll(c, array, off, len);
	return c;
    }

    public static <E> HashSet<E> toHashSet(E... array) {
	return toCollection(new HashSet<E>(array.length), array);
    }

    public static HashSet<Boolean> toHashSet(boolean... array) {
	return toCollection(new HashSet<Boolean>(array.length), array);
    }

    public static HashSet<Byte> toHashSet(byte... array) {
	return toCollection(new HashSet<Byte>(array.length), array);
    }

    public static HashSet<Character> toHashSet(char... array) {
	return toCollection(new HashSet<Character>(array.length), array);
    }

    public static HashSet<Short> toHashSet(short... array) {
	return toCollection(new HashSet<Short>(array.length), array);
    }

    public static HashSet<Integer> toHashSet(int... array) {
	return toCollection(new HashSet<Integer>(array.length), array);
    }

    public static HashSet<Long> toHashSet(long... array) {
	return toCollection(new HashSet<Long>(array.length), array);
    }

    public static HashSet<Float> toHashSet(float... array) {
	return toCollection(new HashSet<Float>(array.length), array);
    }

    public static HashSet<Double> toHashSet(double... array) {
	return toCollection(new HashSet<Double>(array.length), array);
    }

    public static <E> HashSet<E> toHashSet(E[] array, int off, int len) {
	return toCollection(new HashSet<E>(array.length), array, off, len);
    }

    public static HashSet<Boolean> toHashSet(boolean[] array, int off, int len) {
	return toCollection(new HashSet<Boolean>(array.length), array, off, len);
    }

    public static HashSet<Byte> toHashSet(byte[] array, int off, int len) {
	return toCollection(new HashSet<Byte>(array.length), array, off, len);
    }

    public static HashSet<Character> toHashSet(char[] array, int off, int len) {
	return toCollection(new HashSet<Character>(array.length), array, off,
		len);
    }

    public static HashSet<Short> toHashSet(short[] array, int off, int len) {
	return toCollection(new HashSet<Short>(array.length), array, off, len);
    }

    public static HashSet<Integer> toHashSet(int[] array, int off, int len) {
	return toCollection(new HashSet<Integer>(array.length), array, off, len);
    }

    public static HashSet<Long> toHashSet(long[] array, int off, int len) {
	return toCollection(new HashSet<Long>(array.length), array, off, len);
    }

    public static HashSet<Float> toHashSet(float[] array, int off, int len) {
	return toCollection(new HashSet<Float>(array.length), array, off, len);
    }

    public static HashSet<Double> toHashSet(double[] array, int off, int len) {
	return toCollection(new HashSet<Double>(array.length), array, off, len);
    }

    public static <E> ArrayList<E> toArrayList(E... array) {
	return toCollection(new ArrayList<E>(array.length), array);
    }

    public static ArrayList<Boolean> toArrayList(boolean... array) {
	return toCollection(new ArrayList<Boolean>(array.length), array);
    }

    public static ArrayList<Byte> toArrayList(byte... array) {
	return toCollection(new ArrayList<Byte>(array.length), array);
    }

    public static ArrayList<Character> toArrayList(char... array) {
	return toCollection(new ArrayList<Character>(array.length), array);
    }

    public static ArrayList<Short> toArrayList(short... array) {
	return toCollection(new ArrayList<Short>(array.length), array);
    }

    public static ArrayList<Integer> toArrayList(int... array) {
	return toCollection(new ArrayList<Integer>(array.length), array);
    }

    public static ArrayList<Long> toArrayList(long... array) {
	return toCollection(new ArrayList<Long>(array.length), array);
    }

    public static ArrayList<Float> toArrayList(float... array) {
	return toCollection(new ArrayList<Float>(array.length), array);
    }

    public static ArrayList<Double> toArrayList(double... array) {
	return toCollection(new ArrayList<Double>(array.length), array);
    }

    public static <E> ArrayList<E> toArrayList(E[] array, int off, int len) {
	return toCollection(new ArrayList<E>(array.length), array, off, len);
    }

    public static ArrayList<Boolean> toArrayList(boolean[] array, int off,
	    int len) {
	return toCollection(new ArrayList<Boolean>(array.length), array, off,
		len);
    }

    public static ArrayList<Byte> toArrayList(byte[] array, int off, int len) {
	return toCollection(new ArrayList<Byte>(array.length), array, off, len);
    }

    public static ArrayList<Character> toArrayList(char[] array, int off,
	    int len) {
	return toCollection(new ArrayList<Character>(array.length), array, off,
		len);
    }

    public static ArrayList<Short> toArrayList(short[] array, int off, int len) {
	return toCollection(new ArrayList<Short>(array.length), array, off, len);
    }

    public static ArrayList<Integer> toArrayList(int[] array, int off, int len) {
	return toCollection(new ArrayList<Integer>(array.length), array, off,
		len);
    }

    public static ArrayList<Long> toArrayList(long[] array, int off, int len) {
	return toCollection(new ArrayList<Long>(array.length), array, off, len);
    }

    public static ArrayList<Float> toArrayList(float[] array, int off, int len) {
	return toCollection(new ArrayList<Float>(array.length), array, off, len);
    }

    public static ArrayList<Double> toArrayList(double[] array, int off, int len) {
	return toCollection(new ArrayList<Double>(array.length), array, off,
		len);
    }

    public static <E extends Comparable<E>> E getGreatest(E... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	E result = array[0];
	E element;

	for (int i = 1; i < array.length; i++) {
	    element = array[i];
	    if (element.compareTo(result) > 0)
		result = element;
	}

	return result;
    }

    public static <E> E getGreatest(Comparator<? super E> comparator,
	    E... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	E result = array[0];
	E element;

	for (int i = 1; i < array.length; i++) {
	    element = array[i];
	    if (comparator.compare(element, result) > 0)
		result = element;
	}

	return result;
    }

    public static <E extends Comparable<E>> E getGreatestNotNull(E... array) {
	E result = null;
	E element;

	for (int i = 0; i < array.length; i++) {
	    element = array[i];
	    if (element == null)
		continue;
	    if ((result == null) || (element.compareTo(result) > 0))
		result = element;
	}

	if (result == null)
	    throw new NoSuchElementException();

	return result;
    }

    public static <E> E getGreatestNotNull(Comparator<? super E> comparator,
	    E... array) {
	E result = null;
	E element;

	for (int i = 0; i < array.length; i++) {
	    element = array[i];
	    if (element == null)
		continue;
	    if ((result == null) || (comparator.compare(element, result) > 0))
		result = element;
	}

	if (result == null)
	    throw new NoSuchElementException();

	return result;
    }

    public static boolean getGreatest(boolean... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	for (int i = 0; i < array.length; i++) {
	    if (array[i])
		return true;
	}

	return false;
    }

    public static byte getGreatest(byte... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	byte result = array[0];
	byte element;

	for (int i = 1; i < array.length; i++) {
	    element = array[i];
	    if (element > result)
		result = element;
	}

	return result;
    }

    public static char getGreatest(char... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	char result = array[0];
	char element;

	for (int i = 1; i < array.length; i++) {
	    element = array[i];
	    if (element > result)
		result = element;
	}

	return result;
    }

    public static short getGreatest(short... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	short result = array[0];
	short element;

	for (int i = 1; i < array.length; i++) {
	    element = array[i];
	    if (element > result)
		result = element;
	}

	return result;
    }

    public static int getGreatest(int... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	int result = array[0];
	int element;

	for (int i = 1; i < array.length; i++) {
	    element = array[i];
	    if (element > result)
		result = element;
	}

	return result;
    }

    public static long getGreatest(long... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	long result = array[0];
	long element;

	for (int i = 1; i < array.length; i++) {
	    element = array[i];
	    if (element > result)
		result = element;
	}

	return result;
    }

    public static float getGreatest(float... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	float result = array[0];
	float element;

	for (int i = 1; i < array.length; i++) {
	    element = array[i];
	    if (element > result)
		result = element;
	}

	return result;
    }

    public static double getGreatest(double... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	double result = array[0];
	double element;

	for (int i = 1; i < array.length; i++) {
	    element = array[i];
	    if (element > result)
		result = element;
	}

	return result;
    }

    public static <E extends Comparable<? super E>> E getSmallest(E... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	E result = array[0];
	E element;

	for (int i = 1; i < array.length; i++) {
	    element = array[i];
	    if (element.compareTo(result) < 0)
		result = element;
	}

	return result;
    }

    public static <E> E getSmallest(Comparator<? super E> comparator,
	    E... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	E result = array[0];
	E element;

	for (int i = 1; i < array.length; i++) {
	    element = array[i];
	    if (comparator.compare(element, result) < 0)
		result = element;
	}

	return result;
    }

    public static <E extends Comparable<? super E>> E getSmallestNotNull(
	    E... array) {
	E result = null;
	E element;

	for (int i = 0; i < array.length; i++) {
	    element = array[i];
	    if (element == null)
		continue;
	    if ((result == null) || (element.compareTo(result) < 0))
		result = element;
	}

	if (result == null)
	    throw new NoSuchElementException();

	return result;
    }

    public static <E> E getSmallestNotNull(Comparator<? super E> comparator,
	    E... array) {
	E result = null;
	E element;

	for (int i = 0; i < array.length; i++) {
	    element = array[i];
	    if (element == null)
		continue;
	    if ((result == null) || (comparator.compare(element, result) < 0))
		result = element;
	}

	if (result == null)
	    throw new NoSuchElementException();

	return result;
    }

    public static boolean getSmallest(boolean... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	for (int i = 0; i < array.length; i++) {
	    if (!array[i])
		return false;
	}

	return true;
    }

    public static byte getSmallest(byte... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	byte result = array[0];
	byte element;

	for (int i = 1; i < array.length; i++) {
	    element = array[i];
	    if (element == Byte.MIN_VALUE)
		return Byte.MIN_VALUE;
	    if (element < result)
		result = element;
	}

	return result;
    }

    public static char getSmallest(char... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	char result = array[0];
	char element;

	for (int i = 1; i < array.length; i++) {
	    element = array[i];
	    if (element == Character.MIN_VALUE)
		return Character.MIN_VALUE;
	    if (element < result)
		result = element;
	}

	return result;
    }

    public static short getSmallest(short... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	short result = array[0];
	short element;

	for (int i = 1; i < array.length; i++) {
	    element = array[i];
	    if (element == Short.MIN_VALUE)
		return Short.MIN_VALUE;
	    if (element < result)
		result = element;
	}

	return result;
    }

    public static int getSmallest(int... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	int result = array[0];
	int element;

	for (int i = 1; i < array.length; i++) {
	    element = array[i];
	    if (element == Integer.MIN_VALUE)
		return Integer.MIN_VALUE;
	    if (element < result)
		result = element;
	}

	return result;
    }

    public static long getSmallest(long... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	long result = array[0];
	long element;

	for (int i = 1; i < array.length; i++) {
	    element = array[i];
	    if (element == Long.MIN_VALUE)
		return Long.MIN_VALUE;
	    if (element < result)
		result = element;
	}

	return result;
    }

    public static float getSmallest(float... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	float result = array[0];
	float element;

	for (int i = 1; i < array.length; i++) {
	    element = array[i];
	    if (element == Float.MIN_VALUE)
		return Float.MIN_VALUE;
	    if (element < result)
		result = element;
	}

	return result;
    }

    public static double getSmallest(double... array) {
	if (array.length == 0)
	    throw new NoSuchElementException();

	double result = array[0];
	double element;

	for (int i = 1; i < array.length; i++) {
	    element = array[i];
	    if (element == Double.MIN_VALUE)
		return Double.MIN_VALUE;
	    if (element < result)
		result = element;
	}

	return result;
    }

    // TODO: handle exceptions?
    public static boolean equals(Object[] array1, int off1, Object[] array2,
	    int off2, int len) {
	if (array1 == array2)
	    return true;
	if ((array1 == null) || (array2 == null))
	    return false;

	int end1 = off1 + len;
	Object element1;
	Object element2;

	for (int i1 = off1, i2 = off2; i2 < end1; i1++, i2++) {
	    element1 = array1[i1];
	    element2 = array2[i2];
	    if (!((element1 == null) ? (element2 == null) : element1
		    .equals(element2)))
		return false;
	}

	return true;
    }

    public static boolean equals(boolean[] array1, int off1, boolean[] array2,
	    int off2, int len) {
	if (array1 == array2)
	    return true;
	if ((array1 == null) || (array2 == null))
	    return false;

	int end1 = off1 + len;

	for (int i1 = off1, i2 = off2; i2 < end1; i1++, i2++) {
	    if (array1[i1] != array2[i2])
		return false;
	}

	return true;
    }

    public static boolean equals(byte[] array1, int off1, byte[] array2,
	    int off2, int len) {
	if (array1 == array2)
	    return true;
	if ((array1 == null) || (array2 == null))
	    return false;

	int end1 = off1 + len;

	for (int i1 = off1, i2 = off2; i2 < end1; i1++, i2++) {
	    if (array1[i1] != array2[i2])
		return false;
	}

	return true;
    }

    public static boolean equals(char[] array1, int off1, char[] array2,
	    int off2, int len) {
	if (array1 == array2)
	    return true;
	if ((array1 == null) || (array2 == null))
	    return false;

	int end1 = off1 + len;

	for (int i1 = off1, i2 = off2; i2 < end1; i1++, i2++) {
	    if (array1[i1] != array2[i2])
		return false;
	}

	return true;
    }

    public static boolean equals(short[] array1, int off1, short[] array2,
	    int off2, int len) {
	if (array1 == array2)
	    return true;
	if ((array1 == null) || (array2 == null))
	    return false;

	int end1 = off1 + len;

	for (int i1 = off1, i2 = off2; i2 < end1; i1++, i2++) {
	    if (array1[i1] != array2[i2])
		return false;
	}

	return true;
    }

    public static boolean equals(int[] array1, int off1, int[] array2,
	    int off2, int len) {
	if (array1 == array2)
	    return true;
	if ((array1 == null) || (array2 == null))
	    return false;

	int end1 = off1 + len;

	for (int i1 = off1, i2 = off2; i2 < end1; i1++, i2++) {
	    if (array1[i1] != array2[i2])
		return false;
	}

	return true;
    }

    public static boolean equals(long[] array1, int off1, long[] array2,
	    int off2, int len) {
	if (array1 == array2)
	    return true;
	if ((array1 == null) || (array2 == null))
	    return false;

	int end1 = off1 + len;

	for (int i1 = off1, i2 = off2; i2 < end1; i1++, i2++) {
	    if (array1[i1] != array2[i2])
		return false;
	}

	return true;
    }

    public static boolean equals(float[] array1, int off1, float[] array2,
	    int off2, int len) {
	if (array1 == array2)
	    return true;
	if ((array1 == null) || (array2 == null))
	    return false;

	int end1 = off1 + len;

	for (int i1 = off1, i2 = off2; i2 < end1; i1++, i2++) {
	    if (array1[i1] != array2[i2])
		return false;
	}

	return true;
    }

    public static boolean equals(double[] array1, int off1, double[] array2,
	    int off2, int len) {
	if (array1 == array2)
	    return true;
	if ((array1 == null) || (array2 == null))
	    return false;

	int end1 = off1 + len;

	for (int i1 = off1, i2 = off2; i2 < end1; i1++, i2++) {
	    if (array1[i1] != array2[i2])
		return false;
	}

	return true;
    }

    public static int hashCode(Object... array) {
	if (array == null)
	    return 0;

	int result = 1;
	Object element;

	for (int i = 0; i < array.length; i++) {
	    element = array[i];
	    result = 31 * result + ((element == null) ? 0 : element.hashCode());
	}

	return result;
    }

    public static int hashCode(boolean... array) {
	if (array == null)
	    return 0;

	int result = 1;

	for (int i = 0; i < array.length; i++) {
	    result = 31 * result + (array[i] ? 1231 : 1237);
	}

	return result;
    }

    public static int hashCode(byte... array) {
	if (array == null)
	    return 0;

	int result = 1;

	for (int i = 0; i < array.length; i++) {
	    result = 31 * result + array[i];
	}

	return result;
    }

    public static int hashCode(char... array) {
	if (array == null)
	    return 0;

	int result = 1;

	for (int i = 0; i < array.length; i++) {
	    result = 31 * result + array[i];
	}

	return result;
    }

    public static int hashCode(short... array) {
	if (array == null)
	    return 0;

	int result = 1;

	for (int i = 0; i < array.length; i++) {
	    result = 31 * result + array[i];
	}

	return result;
    }

    public static int hashCode(int... array) {
	if (array == null)
	    return 0;

	int result = 1;

	for (int i = 0; i < array.length; i++) {
	    result = 31 * result + array[i];
	}

	return result;
    }

    public static int hashCode(long... array) {
	if (array == null)
	    return 0;

	int result = 1;
	long element;

	for (int i = 0; i < array.length; i++) {
	    element = array[i];
	    result = 31 * result + (int) (element ^ (element >>> 32));
	}

	return result;
    }

    public static int hashCode(float... array) {
	if (array == null)
	    return 0;

	int result = 1;

	for (int i = 0; i < array.length; i++) {
	    result = 31 * result + Float.floatToIntBits(array[i]);
	}

	return result;
    }

    public static int hashCode(double... array) {
	if (array == null)
	    return 0;

	int result = 1;
	long bits;

	for (int i = 0; i < array.length; i++) {
	    bits = Double.doubleToLongBits(array[i]);
	    result = 31 * result + (int) (bits ^ (bits >>> 32));
	}

	return result;
    }

    // TODO: handle exception
    public static int hashCode(Object[] array, int off, int len) {
	if (array == null)
	    return 0;

	int result = 1;
	int end = off + len;
	Object element;

	for (int i = off; i < end; i++) {
	    element = array[i];
	    result = 31 * result + ((element == null) ? 0 : element.hashCode());
	}

	return result;
    }

    public static int hashCode(boolean[] array, int off, int len) {
	if (array == null)
	    return 0;

	int result = 1;
	int end = off + len;

	for (int i = off; i < end; i++) {
	    result = 31 * result + (array[i] ? 1231 : 1237);
	}

	return result;
    }

    public static int hashCode(byte[] array, int off, int len) {
	if (array == null)
	    return 0;

	int result = 1;
	int end = off + len;

	for (int i = off; i < end; i++) {
	    result = 31 * result + array[i];
	}

	return result;
    }

    public static int hashCode(char[] array, int off, int len) {
	if (array == null)
	    return 0;

	int result = 1;
	int end = off + len;

	for (int i = off; i < end; i++) {
	    result = 31 * result + array[i];
	}

	return result;
    }

    public static int hashCode(short[] array, int off, int len) {
	if (array == null)
	    return 0;

	int result = 1;
	int end = off + len;

	for (int i = off; i < end; i++) {
	    result = 31 * result + array[i];
	}

	return result;
    }

    public static int hashCode(int[] array, int off, int len) {
	if (array == null)
	    return 0;

	int result = 1;
	int end = off + len;

	for (int i = off; i < end; i++) {
	    result = 31 * result + array[i];
	}

	return result;
    }

    public static int hashCode(long[] array, int off, int len) {
	if (array == null)
	    return 0;

	int result = 1;
	int end = off + len;
	long element;

	for (int i = off; i < end; i++) {
	    element = array[i];
	    result = 31 * result + (int) (element ^ (element >>> 32));
	}

	return result;
    }

    public static int hashCode(float[] array, int off, int len) {
	if (array == null)
	    return 0;

	int result = 1;
	int end = off + len;

	for (int i = off; i < end; i++) {
	    result = 31 * result + Float.floatToIntBits(array[i]);
	}

	return result;
    }

    public static int hashCode(double[] array, int off, int len) {
	if (array == null)
	    return 0;

	int result = 1;
	int end = off + len;
	long bits;

	for (int i = off; i < end; i++) {
	    bits = Double.doubleToLongBits(array[i]);
	    result = 31 * result + (int) (bits ^ (bits >>> 32));
	}

	return result;
    }

    public static void swap(Object[] array, int i, int j) {
	Object tmp = array[i];
	array[i] = array[j];
	array[j] = tmp;
    }

    public static void swap(boolean[] array, int i, int j) {
	boolean tmp = array[i];
	array[i] = array[j];
	array[j] = tmp;
    }

    public static void swap(byte[] array, int i, int j) {
	byte tmp = array[i];
	array[i] = array[j];
	array[j] = tmp;
    }

    public static void swap(char[] array, int i, int j) {
	char tmp = array[i];
	array[i] = array[j];
	array[j] = tmp;
    }

    public static void swap(short[] array, int i, int j) {
	short tmp = array[i];
	array[i] = array[j];
	array[j] = tmp;
    }

    public static void swap(int[] array, int i, int j) {
	int tmp = array[i];
	array[i] = array[j];
	array[j] = tmp;
    }

    public static void swap(long[] array, int i, int j) {
	long tmp = array[i];
	array[i] = array[j];
	array[j] = tmp;
    }

    public static void swap(float[] array, int i, int j) {
	float tmp = array[i];
	array[i] = array[j];
	array[j] = tmp;
    }

    public static void swap(double[] array, int i, int j) {
	double tmp = array[i];
	array[i] = array[j];
	array[j] = tmp;
    }

    public static void swapAll(Object[] array) {
	Object tmp;

	for (int i = 0, j = array.length - 1; i < j; i++, j--) {
	    tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
    }

    public static void swapAll(boolean[] array) {
	boolean tmp;

	for (int i = 0, j = array.length - 1; i < j; i++, j--) {
	    tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
    }

    public static void swapAll(byte[] array) {
	byte tmp;

	for (int i = 0, j = array.length - 1; i < j; i++, j--) {
	    tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
    }

    public static void swapAll(char[] array) {
	char tmp;

	for (int i = 0, j = array.length - 1; i < j; i++, j--) {
	    tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
    }

    public static void swapAll(short[] array) {
	short tmp;

	for (int i = 0, j = array.length - 1; i < j; i++, j--) {
	    tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
    }

    public static void swapAll(int[] array) {
	int tmp;

	for (int i = 0, j = array.length - 1; i < j; i++, j--) {
	    tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
    }

    public static void swapAll(long[] array) {
	long tmp;

	for (int i = 0, j = array.length - 1; i < j; i++, j--) {
	    tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
    }

    public static void swapAll(float[] array) {
	float tmp;

	for (int i = 0, j = array.length - 1; i < j; i++, j--) {
	    tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
    }

    public static void swapAll(double[] array) {
	double tmp;

	for (int i = 0, j = array.length - 1; i < j; i++, j--) {
	    tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
    }

    public static void swapAll(Object[] array, int off, int len) {
	int last = off + len - 1;
	Object tmp;

	for (int i = off, j = last; i < j; i++, j--) {
	    tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
    }

    public static void swapAll(boolean[] array, int off, int len) {
	int last = off + len - 1;
	boolean tmp;

	for (int i = off, j = last; i < j; i++, j--) {
	    tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
    }

    public static void swapAll(byte[] array, int off, int len) {
	int last = off + len - 1;
	byte tmp;

	for (int i = off, j = last; i < j; i++, j--) {
	    tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
    }

    public static void swapAll(char[] array, int off, int len) {
	int last = off + len - 1;
	char tmp;

	for (int i = off, j = last; i < j; i++, j--) {
	    tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
    }

    public static void swapAll(short[] array, int off, int len) {
	int last = off + len - 1;
	short tmp;

	for (int i = off, j = last; i < j; i++, j--) {
	    tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
    }

    public static void swapAll(int[] array, int off, int len) {
	int last = off + len - 1;
	int tmp;

	for (int i = off, j = last; i < j; i++, j--) {
	    tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
    }

    public static void swapAll(long[] array, int off, int len) {
	int last = off + len - 1;
	long tmp;

	for (int i = off, j = last; i < j; i++, j--) {
	    tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
    }

    public static void swapAll(float[] array, int off, int len) {
	int last = off + len - 1;
	float tmp;

	for (int i = off, j = last; i < j; i++, j--) {
	    tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
    }

    public static void swapAll(double[] array, int off, int len) {
	int last = off + len - 1;
	double tmp;

	for (int i = off, j = last; i < j; i++, j--) {
	    tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
    }

    public static Object newInstance(Class<?> arrayClass, int length) {
	return Array.newInstance(arrayClass.getComponentType(), length);
    }

    public static Object copyOf(Object array, int newLength) {
	if (newLength < 0)
	    throw new NegativeArraySizeException();

	int length = Array.getLength(array);
	Object newArray = newInstance(array.getClass(), newLength);
	System.arraycopy(array, 0, newArray, 0, Math.min(length, newLength));

	return newArray;
    }

    public static Object copyOfRange(Object array, int from, int to) {
	if (from < 0)
	    throw new ArrayIndexOutOfBoundsException(from);

	int length = Array.getLength(array);
	if (from > length)
	    throw new ArrayIndexOutOfBoundsException(from);

	int newLength = from - to;
	if (newLength < 0)
	    throw new IllegalArgumentException();

	Object newArray = newInstance(array.getClass(), newLength);
	System.arraycopy(array, from, newArray, 0, Math.min(length, newLength));

	return newArray;
    }

    public static Object growDirect(Object array, int newLength) {
	int length = Array.getLength(array);
	if (length >= newLength)
	    return array;

	return copyOf(array, newLength);
    }

    public static Object growArithmetic(Object array, int newLength,
	    int stepSize) {
	int length = Array.getLength(array);
	if (length >= newLength)
	    return array;

	newLength = length + stepSize
		+ MathUtil.floor(newLength - length, stepSize);
	return copyOf(array, newLength);
    }

    public static Object growGeometric(Object array, int newLength, int base) {
	int length = Array.getLength(array);
	if (length >= newLength)
	    return array;

	int addExponent = (int) Math.ceil(((double) newLength / length)
		* (1d / base));
	newLength = (int) (length * Math.pow(base, addExponent));
	return copyOf(array, newLength);
    }

    private ArrayUtil() {
    }

}