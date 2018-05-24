package com.esure.radar.conditions.logic;

import com.esure.radar.calculation.LogicComponent;

public abstract class AbstractLogicExpression implements LogicExpression
{
    protected LogicComponent comparitorOne;
    protected LogicComponent comparitorTwo;
    protected LogicComponent[] otherComparitors;

    protected AbstractLogicExpression(LogicComponent comparitorOne, LogicComponent comparitorTwo,
            LogicComponent... otherComparitors)
    {
        this.comparitorOne = comparitorOne;
        this.comparitorTwo = comparitorTwo;
        this.otherComparitors = otherComparitors;
    }
}
