package com.esure.radar.fields;

public class StaticValue<T> implements Value<T>
{

    private T value;

    public StaticValue(T value)
    {
        this.value = value;
    }

    @Override
    public T getValue()
    {
        return value;
    }

}
