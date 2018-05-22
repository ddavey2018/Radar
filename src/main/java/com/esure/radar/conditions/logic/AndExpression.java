package com.esure.radar.conditions.logic;

import com.esure.radar.conditions.ConditionalExpression;

public class AndExpression extends LogicExpression
{
    public AndExpression(ConditionalExpression conditionOne, ConditionalExpression... otherExpressions)
    {
        super(conditionOne, otherExpressions);
    }

    @Override
    public boolean isTrue()
    {
        boolean isTrue = conditionOne.isTrue();

        if (!isTrue)
        {
            return isTrue;
        }

        if (otherExpressions != null && otherExpressions.length > 0)
        {
            for (ConditionalExpression expression : otherExpressions)
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
