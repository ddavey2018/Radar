package com.esure.radar.conditions;

import java.util.List;

import com.esure.radar.calculation.steps.CalculationStep;
import com.esure.radar.calculation.steps.Step;

public abstract class ConditionalStep implements Step
{

    protected List<CalculationStep> calculations;

    protected ConditionalStep(List<CalculationStep> calculations)
    {
        this.calculations = calculations;
    }

    @Override
    public void execute()
    {
        for (CalculationStep calculation : calculations)
        {
            calculation.execute();
        }
    }
}
