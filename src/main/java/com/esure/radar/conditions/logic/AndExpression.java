package com.esure.radar.conditions.logic;

import com.esure.radar.calculation.LogicComponent;

public class AndExpression extends AbstractLogicExpression
{
    public AndExpression(LogicComponent comparitorOne, LogicComponent comparitorTwo, LogicComponent... otherComparitors)
    {
        super(comparitorOne, comparitorTwo, otherComparitors);
    }

    @Override
    public boolean isTrue()
    {
        boolean isTrue = comparitorOne.isTrue() && comparitorTwo.isTrue();

        if (!isTrue)
        {
            return isTrue;
        }

        if (otherComparitors != null && otherComparitors.length > 0)
        {
            for (LogicComponent expression : otherComparitors)
            {
                isTrue = expression.isTrue();
                if (!isTrue)
                {
                    return isTrue;
                }
            }
        }

        return isTrue;
    }
}
