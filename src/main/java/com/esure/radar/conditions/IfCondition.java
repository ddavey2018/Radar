package com.esure.radar.conditions;

import java.util.List;

import com.esure.radar.calculation.steps.CalculationStep;

public class IfCondition extends ConditionalCalculations implements ConditionInterface
{

    protected IfCondition(List<CalculationStep> calculations)
    {
        super(calculations);
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
