package com.esure.radar.conditions;

public final class ConditionalExpression
{

    private Comparitor comparitor;

    protected ConditionalExpression(Comparitor comparitor)
    {
        this.comparitor = comparitor;
    }

    public boolean isTrue()
    {
        return comparitor.isTrue();
    }
}
