package com.esure.radar.calculation.steps;

import com.esure.radar.fields.Field;
import com.esure.radar.fields.Value;

public class CalculationStep<T> implements Step
{
    private Field<? extends Number> lhs;
    private Value<Number> rhs;

    public CalculationStep(Field<? extends Number> lhs, Value<Number> rhs)
    {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public void execute()
    {
        Number retVal = rhs.getValue();

        if (lhs.getValue() instanceof Integer)
        {
            ((Field<Integer>) lhs).setValue(retVal.intValue());
        }
        else if (lhs.getValue() instanceof Long)
        {
            ((Field<Long>) lhs).setValue(retVal.longValue());
        }

    }

}
