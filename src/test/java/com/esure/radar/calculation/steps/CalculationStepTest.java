package com.esure.radar.calculation.steps;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esure.radar.calculation.operations.Multiply;
import com.esure.radar.fields.Field;
import com.esure.radar.fields.StaticValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculationStepTest
{

    @Test
    public void singleAssignment()
    {
        Field<Integer> lhs = new Field<Integer>(0);
        CalculationStep calculation = new CalculationStep(lhs, new Field<Integer>(2));
        calculation.execute();
        assertTrue(lhs.getValue() == 2);

        calculation = new CalculationStep(lhs, new Multiply(
                new Multiply(new StaticValue<Integer>(2), new StaticValue<Integer>(2)), new StaticValue<Integer>(2)));
        calculation.execute();
        assertTrue(lhs.getValue() == 8);
    }
}
