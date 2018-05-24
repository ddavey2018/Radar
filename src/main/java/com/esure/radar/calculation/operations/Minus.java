package com.esure.radar.calculation.operations;

import com.esure.radar.fields.Value;

public class Minus extends AbstractionCalculationOperation
{

    protected Minus(Value<? extends Number> n1, Value<? extends Number> n2)
    {
        super(n1, n2);
    }

    @Override
    public Number getValue()
    {
        return n1.getValue().doubleValue() - n2.getValue().doubleValue();
    }

}
