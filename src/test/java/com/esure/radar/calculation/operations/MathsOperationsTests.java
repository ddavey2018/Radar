package com.esure.radar.calculation.operations;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esure.radar.fields.StaticValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MathsOperationsTests
{
    private static final Logger logger = LoggerFactory.getLogger(MathsOperationsTests.class);
    private Class<?>[] numberTypes =
    { Integer.class, Long.class, Float.class, Double.class };
    private List<Class<?>> numberTypesList = new ArrayList<Class<?>>(Arrays.asList(numberTypes));

    private void testOperation(Class<? extends Operation> operationClass, int factor, int power, Number expectedResult)
    {
        for (Class<?> type : numberTypes)
        {
            testType(operationClass, factor, power, expectedResult, type);
        }
    }

    @Test
    public void testOperations()
    {
        int factor = 2, power = 3;

        Class<? extends Operation> operationClass = Multiply.class;
        testOperation(operationClass, factor, power, (int) Math.pow(factor, power));

        operationClass = Divide.class;
        testOperation(operationClass, factor, power, getExpectedDivisionResult(factor, power));

        operationClass = Minus.class;
        testOperation(operationClass, factor, power, getExpectedAubtrationResult(factor,power));

        operationClass = Plus.class;
        testOperation(operationClass, factor, power, factor * power);
    }

    private Number getExpectedDivisionResult(int factor, int power)
    {
        double result = (double) factor / (double) factor;
        for (int index = 2; index < power; index++)
        {
            result = result / factor;
        }
        return result;
    }
    
    private Number getExpectedAubtrationResult(int factor, int power)
    {
        double result = (double) factor - (double) factor;
        for (int index = 2; index < power; index++)
        {
            result = result - factor;
        }
        return result;
    }

    private void testType(Class<? extends Operation> operationClass, int factor, int power, Number expectedResult,
            Class<?> cls)
    {
        Class<?>[] clses = classToPower(power, cls);
        Number[] inputValues = numberToPower(power, factor);
        Operation test = getOperation(operationClass, clses, inputValues);
        Number result = test.getValue();
        assertTrue(result.floatValue() == expectedResult.floatValue());

        Class<?>[][] testScenarios = testScenarios(cls, power);
        for (Class<?>[] scenario : testScenarios)
        {
            test = getOperation(operationClass, scenario, inputValues);
            result = test.getValue();
            logger.info("{}={} = {}", result, expectedResult, result.floatValue() == expectedResult.floatValue());
            assertTrue(result.floatValue() == expectedResult.floatValue());
        }
    }

    private Class<?>[][] testScenarios(Class<?> cls, int power)
    {
        Class<?>[] notClass = notClass(cls);
        Class<?>[][] tests = new Class<?>[(numberTypes.length - 1) * power][power];
        Class<?> notClassMember = null;

        int testIndex = 0;
        for (int notClassMemberIndex = 0; notClassMemberIndex < notClass.length; notClassMemberIndex++)
        {
            notClassMember = notClass[notClassMemberIndex];

            for (int powerIndexPos = 0; powerIndexPos < power; powerIndexPos++)
            {
                for (int powerIndex = 0; powerIndex < power; powerIndex++)
                {
                    if (powerIndexPos == powerIndex)
                    {
                        tests[testIndex][powerIndex] = notClassMember;
                    }
                    else
                    {
                        tests[testIndex][powerIndex] = cls;
                    }
                }
                testIndex++;
            }

        }

        return tests;
    }

    private Class<?>[] notClass(Class<?> cls)
    {
        Class<?>[] clses = new Class<?>[numberTypes.length - 1];
        int count = 0;
        for (Class<?> clsMember : numberTypes)
        {
            if (clsMember != cls)
            {
                clses[count] = clsMember;
                count++;
            }
        }
        return clses;
    }

    private Number[] numberToPower(int power, Number n)
    {
        Number[] numbers = new Number[power];

        for (int index = 0; index < power; index++)
        {
            numbers[index] = n;
        }

        return numbers;
    }

    private Class<?>[] classToPower(int power, Class<?> cls)
    {
        Class<?>[] clses = new Class<?>[power];

        for (int index = 0; index < power; index++)
        {
            clses[index] = cls;
        }

        return clses;
    }

    private Class<?> getExpectedReturnType(Class<?>[] valueClasses)
    {
        Class<?> expected = Integer.class;
        for (Class<?> cls : valueClasses)
        {
            if (numberTypesList.indexOf(cls) > numberTypesList.indexOf(expected))
            {
                expected = cls;
            }
        }
        return expected;
    }

    private Operation getOperation(Class<? extends Operation> operationClass, Class<?>[] cls, Number[] values)
    {
        Operation previous = null;
        for (int index = 1; index < cls.length; index++)
        {
            if (index == 1)
            {
                previous = getOperation(operationClass, cls[0], values[0], cls[index], values[index]);
            }
            else
            {
                previous = getOperation(operationClass, previous, cls[index], values[index]);
            }
        }
        return previous;
    }

    private Operation getOperation(Class<?> operationClass, Class<?> c1, Number n1, Class<?> c2, Number n2)
    {
        if (operationClass == Multiply.class)
        {
            return new Multiply(getStaticValue(c1, n1), getStaticValue(c2, n2));
        }
        else if (operationClass == Divide.class)
        {
            return new Divide(getStaticValue(c1, n1), getStaticValue(c2, n2));
        }
        else if (operationClass == Minus.class)
        {
            return new Minus(getStaticValue(c1, n1), getStaticValue(c2, n2));
        }
        else
        {
            return new Plus(getStaticValue(c1, n1), getStaticValue(c2, n2));
        }
    }

    private Operation getOperation(Class<? extends Operation> operationClass, Operation prevAnswer, Class<?> cls,
            Number n)
    {
        if (operationClass == Multiply.class)
        {
            return new Multiply(prevAnswer, getStaticValue(cls, n));
        }
        else if (operationClass == Divide.class)
        {
            return new Divide(prevAnswer, getStaticValue(cls, n));
        }
        else if (operationClass == Minus.class)
        {
            return new Minus(prevAnswer, getStaticValue(cls, n));
        }
        else
        {
            return new Plus(prevAnswer, getStaticValue(cls, n));
        }

    }

    private StaticValue<? extends Number> getStaticValue(Class<?> cls, Number n)
    {
        if (cls == Integer.class)
        {
            return new StaticValue<Integer>(n.intValue());
        }
        else if (cls == Long.class)
        {
            return new StaticValue<Long>(n.longValue());
        }
        if (cls == Float.class)
        {
            return new StaticValue<Float>(n.floatValue());
        }
        else
        {
            return new StaticValue<Double>(n.doubleValue());
        }
    }

}
