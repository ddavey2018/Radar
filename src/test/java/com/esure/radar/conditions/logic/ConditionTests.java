package com.esure.radar.conditions.logic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esure.radar.conditions.IsEqualTo;
import com.esure.radar.fields.Field;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConditionTests
{
    @Test
    public void and()
    {
        // a = a AND b = b
        AndExpression and = new AndExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")));
        assertTrue(and.isTrue());

        // a = a AND a = b
        and = new AndExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                new IsEqualTo<String>(new Field<String>("a"), new Field<String>("b")));
        assertFalse(and.isTrue());

        // a = a AND b = b AND c = c
        and = new AndExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")),
                new IsEqualTo<String>(new Field<String>("c"), new Field<String>("c")));
        assertTrue(and.isTrue());

        // a = a AND b = b AND c = a
        and = new AndExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")),
                new IsEqualTo<String>(new Field<String>("c"), new Field<String>("a")));
        assertFalse(and.isTrue());

        // a = a AND b = a AND c = c
        and = new AndExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                new IsEqualTo<String>(new Field<String>("b"), new Field<String>("a")),
                new IsEqualTo<String>(new Field<String>("c"), new Field<String>("a")));
        assertFalse(and.isTrue());

    }

    @Test
    public void or()
    {
        // a = a OR b = b
        OrExpression or = new OrExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")));
        assertTrue(or.isTrue());

        // a = a OR a = b
        or = new OrExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                new IsEqualTo<String>(new Field<String>("a"), new Field<String>("b")));
        assertTrue(or.isTrue());

        // a = B OR B = b
        or = new OrExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("b")),
                new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")));
        assertTrue(or.isTrue());

        // a = a OR b = b OR c = c
        or = new OrExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")),
                new IsEqualTo<String>(new Field<String>("c"), new Field<String>("c")));
        assertTrue(or.isTrue());

        // a = b OR b = b OR c = a
        or = new OrExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("b")),
                new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")),
                new IsEqualTo<String>(new Field<String>("c"), new Field<String>("a")));
        assertTrue(or.isTrue());

        // a = b OR b = c OR c = c
        or = new OrExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("b")),
                new IsEqualTo<String>(new Field<String>("b"), new Field<String>("c")),
                new IsEqualTo<String>(new Field<String>("c"), new Field<String>("c")));
        assertTrue(or.isTrue());
    }

    @Test
    public void andGroups()
    {
        // (a = a AND b = b) AND c = c
        AndExpression and = new AndExpression(
                new ConditionGroup(
                        new AndExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                                new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")))),
                new IsEqualTo<String>(new Field<String>("c"), new Field<String>("c"))

        );
        assertTrue(and.isTrue());

        // a = a AND (b = b AND c = c)
        and = new AndExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                new ConditionGroup(
                        new AndExpression(new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")),
                                new IsEqualTo<String>(new Field<String>("c"), new Field<String>("c")))));
        assertTrue(and.isTrue());

        // (a = a AND b = b) AND c = c AND d = d
        and = new AndExpression(
                new ConditionGroup(
                        new AndExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                                new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")))),
                new IsEqualTo<String>(new Field<String>("c"), new Field<String>("c")),
                new IsEqualTo<String>(new Field<String>("d"), new Field<String>("d"))

        );
        assertTrue(and.isTrue());

        // a = a (AND b = b AND c = c) AND d = d
        and = new AndExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                new ConditionGroup(
                        new AndExpression(new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")),
                                new IsEqualTo<String>(new Field<String>("c"), new Field<String>("c")))),
                new IsEqualTo<String>(new Field<String>("d"), new Field<String>("d"))

        );
        assertTrue(and.isTrue());

        // a = a AND b = b (AND c = c AND d = d)
        and = new AndExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")),
                new ConditionGroup(
                        new AndExpression(new IsEqualTo<String>(new Field<String>("c"), new Field<String>("c")),
                                new IsEqualTo<String>(new Field<String>("d"), new Field<String>("d")))));
        assertTrue(and.isTrue());

        // (a = b AND b = b) AND c = c
        and = new AndExpression(
                new ConditionGroup(
                        new AndExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("b")),
                                new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")))),
                new IsEqualTo<String>(new Field<String>("c"), new Field<String>("c"))

        );
        assertFalse(and.isTrue());

        // (a = a AND b = a) AND c = c
        and = new AndExpression(
                new ConditionGroup(
                        new AndExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                                new IsEqualTo<String>(new Field<String>("b"), new Field<String>("a")))),
                new IsEqualTo<String>(new Field<String>("c"), new Field<String>("c"))

        );
        assertFalse(and.isTrue());

        // (a = a AND b = b) AND c = d
        and = new AndExpression(
                new ConditionGroup(
                        new AndExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                                new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")))),
                new IsEqualTo<String>(new Field<String>("c"), new Field<String>("d"))

        );
        assertFalse(and.isTrue());
    }

    @Test
    public void orGroups()
    {
        // (a = a OR b = b) OR c = c
        OrExpression or = new OrExpression(
                new ConditionGroup(
                        new OrExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                                new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")))),
                new IsEqualTo<String>(new Field<String>("c"), new Field<String>("c"))

        );
        assertTrue(or.isTrue());

        // a = a OR (b = b OR c = c)
        or = new OrExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                new ConditionGroup(
                        new OrExpression(new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")),
                                new IsEqualTo<String>(new Field<String>("c"), new Field<String>("c")))));
        assertTrue(or.isTrue());

        // (a = a OR b = b) OR c = c OR d = d
        or = new OrExpression(
                new ConditionGroup(
                        new OrExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                                new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")))),
                new IsEqualTo<String>(new Field<String>("c"), new Field<String>("c")),
                new IsEqualTo<String>(new Field<String>("d"), new Field<String>("d"))

        );
        assertTrue(or.isTrue());

        // a = a (OR b = b OR c = c) OR d = d
        or = new OrExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                new ConditionGroup(
                        new OrExpression(new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")),
                                new IsEqualTo<String>(new Field<String>("c"), new Field<String>("c")))),
                new IsEqualTo<String>(new Field<String>("d"), new Field<String>("d"))

        );
        assertTrue(or.isTrue());

        // a = a OR b = b (OR c = c OR d = d)
        or = new OrExpression(new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a")),
                new IsEqualTo<String>(new Field<String>("b"), new Field<String>("b")),
                new ConditionGroup(
                        new OrExpression(new IsEqualTo<String>(new Field<String>("c"), new Field<String>("c")),
                                new IsEqualTo<String>(new Field<String>("d"), new Field<String>("d")))));
        assertTrue(or.isTrue());
    }
}
