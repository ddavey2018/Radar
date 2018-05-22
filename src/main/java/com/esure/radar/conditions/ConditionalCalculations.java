package com.esure.radar.conditions;

import java.util.List;

import com.esure.radar.calculation.steps.CalculationStep;
import com.esure.radar.conditions.logic.LogicExpression;

public abstract class ConditionalCalculations
{
    protected List<CalculationStep> calculations;
    protected LogicExpression expression;

    protected ConditionalCalculations(LogicExpression expression, List<CalculationStep> calculations)
    {
        this.expression = expression;
        this.calculations = calculations;
    }

    protected void executeCalculations()
    {
        for (CalculationStep calculation : calculations)
        {
            calculation.execute();
        }
    }
}
