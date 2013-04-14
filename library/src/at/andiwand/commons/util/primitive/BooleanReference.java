package at.andiwand.commons.util.primitive;

public class BooleanReference implements PrimitiveReference<Boolean> {
	
	public static final Class<Boolean> WRAPPER_CLASS = Boolean.class;
	
	public static final Class<?> PRIMITIVE_CLASS = boolean.class;
	
	public boolean value;
	
	@Override
	public Boolean getWrapper() {
		return Boolean.valueOf(value);
	}
	
	@Override
	public Class<Boolean> getWrapperClass() {
		return WRAPPER_CLASS;
	}
	
	@Override
	public Class<?> getPrimitiveClass() {
		return PRIMITIVE_CLASS;
	}
	
}