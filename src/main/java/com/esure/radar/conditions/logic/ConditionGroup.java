package com.esure.radar.conditions.logic;

import com.esure.radar.conditions.ConditionalExpression;

public class ConditionGroup extends LogicExpression{


	protected ConditionGroup(ConditionalExpression conditionOne, ConditionalExpression[] otherExpressions) {
		super(conditionOne, otherExpressions);
	}

	@Override
	public boolean isTrue() {
		// TODO Auto-generated method stub
		return false;
	}}
