package com.esure.radar.calculation.operations;

import com.esure.radar.fields.Value;

public class Divide extends AbstractionCalculationOperation
{

    public Divide(Value<? extends Number> n1, Value<? extends Number> n2)
    {
        super(n1, n2);
    }

    @Override
    public Number getValue()
    {
        return n1.getValue().doubleValue() / n2.getValue().doubleValue();
        // Number result = getNumberValue(n1.getValue(), n2.getValue());

        // return result;
    }

    private Number getNumberValue(Number n1, Number n2)
    {
        if (n1 instanceof Float)
        {
            return getFloatValue(n1, n2);
        }
        else if (n1 instanceof Long)
        {
            return getLongValue(n1, n2);
        }
        else if (n1 instanceof Double)
        {
            return getDoubleValue(n1, n2);
        }
        else
        {
            return getIntValue(n1, n2);
        }
    }

    private Number getIntValue(Number n1, Number n2)
    {
        if (n2 instanceof Long)
        {
            return divideWholeNumbers(n1, n2);
        }
        else if (n2 instanceof Float)
        {
            return n1.intValue() / n2.floatValue();
        }
        else if (n2 instanceof Double)
        {
            return n1.intValue() / n2.doubleValue();
        }
        else
        {
            return divideWholeNumbers(n1, n2);
        }
    }

    private Number divideWholeNumbers(Number n1, Number n2)
    {
        Number result = null;
        if (n1 instanceof Long || n2 instanceof Long)
        {
            result = n1.longValue() / n2.longValue();
        }
        else
        {
            result = n1.intValue() / n2.intValue();
        }

        if ((n1.floatValue() / n2.floatValue()) != result.floatValue())
        {
            return n1.floatValue() / n2.floatValue();
        }
        else
        {
            return result;
        }
    }

    private Number getFloatValue(Number n1, Number n2)
    {
        if (n2 instanceof Long)
        {
            return n1.floatValue() / n2.longValue();
        }
        else if (n2 instanceof Float)
        {
            return n1.floatValue() / n2.floatValue();
        }
        else if (n2 instanceof Double)
        {
            return n1.floatValue() / n2.doubleValue();
        }
        else
        {
            return n1.floatValue() / n2.intValue();
        }
    }

    private Number getLongValue(Number n1, Number n2)
    {
        if (n2 instanceof Integer)
        {
            return divideWholeNumbers(n1, n2);
        }
        else if (n2 instanceof Float)
        {
            return n1.longValue() / n2.floatValue();
        }
        else if (n2 instanceof Double)
        {
            return n1.longValue() / n2.doubleValue();
        }
        else
        {
            return divideWholeNumbers(n1, n2);
        }
    }

    private Number getDoubleValue(Number n1, Number n2)
    {
        if (n2 instanceof Long)
        {
            return n1.doubleValue() / n2.longValue();
        }
        else if (n2 instanceof Float)
        {
            return n1.doubleValue() / n2.floatValue();
        }
        else if (n2 instanceof Integer)
        {
            return n1.doubleValue() / n2.intValue();
        }
        else
        {
            return n1.doubleValue() / n2.doubleValue();
        }
    }
}
