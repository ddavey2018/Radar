package com.esure.radar.conditions;

import java.util.List;

import com.esure.radar.calculation.steps.CalculationStep;

public abstract class ConditionalCalculations
{
    protected List<CalculationStep> calculations;

    protected ConditionalCalculations(List<CalculationStep> calculations)
    {
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
