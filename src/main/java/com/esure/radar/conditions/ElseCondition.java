package com.esure.radar.conditions;

import java.util.List;

import com.esure.radar.calculation.steps.CalculationStep;

public class ElseCondition extends ConditionalStep
{

    protected ElseCondition(List<CalculationStep> calculations)
    {
        super(calculations);
    }

}
