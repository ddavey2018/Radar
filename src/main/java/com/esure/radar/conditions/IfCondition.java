package com.esure.radar.conditions;

import java.util.List;

import com.esure.radar.calculation.steps.CalculationStep;
import com.esure.radar.conditions.logic.AbstractLogicExpression;

public class IfCondition extends ConditionalCalculations implements ConditionInterface
{

    protected IfCondition(AbstractLogicExpression expression, List<CalculationStep> calculations)
    {
        super(expression, calculations);
    }

    @Override
    public void execute()
    {
        if (matches())
        {
            executeCalculations();
        }

    }

    public boolean matches()
    {
        return true;
    }

}
