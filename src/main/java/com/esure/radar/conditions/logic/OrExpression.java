package com.esure.radar.conditions.logic;

import com.esure.radar.conditions.ConditionalExpression;

public class OrExpression extends LogicExpression
{
    public OrExpression(ConditionalExpression conditionOne, ConditionalExpression... otherExpressions)
    {
        super(conditionOne, otherExpressions);
    }

    @Override
    public boolean isTrue()
    {
        boolean isTrue = conditionOne.isTrue();

        if (isTrue)
        {
            return isTrue;
        }

        if (otherExpressions != null && otherExpressions.length > 0)
        {
            for (ConditionalExpression expression : otherExpressions)
            {
                if (expression.isTrue())
                {
                    return isTrue;
                }
            }
        }

        return isTrue;
    }
}
