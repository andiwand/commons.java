package at.andiwand.commons.math;

import java.math.BigDecimal;

public interface UnitPrefix {

    public String symbol();

    public double value();

    public BigDecimal bigValue();

}