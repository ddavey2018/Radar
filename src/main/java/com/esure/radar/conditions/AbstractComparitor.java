package com.esure.radar.conditions;

import com.esure.radar.fields.Value;

abstract class AbstractComparitor<T> implements Comparitor{
	protected Value lhs;
	protected Value rhs;

	protected AbstractComparitor(Value<T> lhs,Value<T> rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
}
