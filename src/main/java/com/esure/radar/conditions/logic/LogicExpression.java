package com.esure.radar.conditions.logic;

import com.esure.radar.conditions.ConditionalExpression;

public abstract class LogicExpression implements LogicExpressionInterface
{
    protected ConditionalExpression conditionOne;
    protected ConditionalExpression[] otherExpressions;

    protected LogicExpression(ConditionalExpression conditionOne, ConditionalExpression... otherExpressions)
    {
        this.conditionOne = conditionOne;
        this.otherExpressions = otherExpressions;
    }
}
