package com.esure.radar.conditions;

import com.esure.radar.fields.Value;

public class IsEqualTo<T> extends AbstractComparitor<T>
{

    public IsEqualTo(Value<T> lhs, Value<T> rhs)
    {
        super(lhs, rhs);
    }

    @Override
    public boolean isTrue()
    {
        return lhs.getValue().equals(rhs.getValue());
    }
}
