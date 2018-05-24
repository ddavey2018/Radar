package com.esure.radar.conditions.logic;

public class ConditionGroup implements LogicExpression
{

    private LogicExpression logic;

    protected ConditionGroup(LogicExpression logic)
    {
        this.logic = logic;
    }

    @Override
    public boolean isTrue()
    {
        return logic.isTrue();
    }
}
