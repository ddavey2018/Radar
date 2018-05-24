package com.esure.radar.calculation.operations;

import com.esure.radar.fields.Value;

public abstract class AbstractionCalculationOperation implements Operation
{
    protected Value<? extends Number> n1;
    protected Value<? extends Number> n2;

    protected AbstractionCalculationOperation(Value<? extends Number> n1, Value<? extends Number> n2)
    {
        this.n1 = n1;
        this.n2 = n2;
    }

}
