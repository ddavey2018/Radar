package com.esure.radar.conditions;

import java.util.List;

public final class IfElseCondition implements ConditionInterface
{

    private List<IfCondition> ifConditions;
    private ElseCondition elseCondition;

    public IfElseCondition(List<IfCondition> ifConditions, ElseCondition elseCondition)
    {
        this.ifConditions = ifConditions;
        this.elseCondition = elseCondition;
    }

    @Override
    public void execute()
    {
        for (IfCondition condition : ifConditions)
        {
            if (condition.matches())
            {
                condition.executeCalculations();
                return;
            }

        }

        elseCondition.execute();

    }

}
