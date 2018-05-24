package com.esure.radar.conditions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esure.radar.conditions.Comparitor;
import com.esure.radar.conditions.IsEqualTo;
import com.esure.radar.fields.Field;
import com.esure.radar.fields.Value;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComparitorTests
{

    @Test
    public void isEqualTo()
    {
        Value<String> a = new Field<String>("a");
        Comparitor stringComparitor = new IsEqualTo<String>(new Field<String>("a"), new Field<String>("a"));
        assertTrue(stringComparitor.isTrue());
        stringComparitor = new IsEqualTo<String>(new Field<String>("a"), new Field<String>("b"));
        assertFalse(stringComparitor.isTrue());
    }

}
