package com.alex.utils.util.validator;

import com.alex.utils.validator.ObjectValidator;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public class ObjectValidatorTest {

    @Test
    public void isNull() throws Exception {
        assertTrue(ObjectValidator.isNull(null));
        assertFalse(ObjectValidator.isNull(new Object()));
    }

    @Test
    public void isNotNull() throws Exception {
        assertTrue(ObjectValidator.isNotNull(new Object()));
        assertFalse(ObjectValidator.isNotNull(null));
    }

    @Test
    public void isEmptyCollection() throws Exception {
        assertTrue(ObjectValidator.isEmpty((Collection) null));
        assertTrue(ObjectValidator.isEmpty(new ArrayList()));
        assertTrue(ObjectValidator.isEmpty(new LinkedList()));
        assertTrue(ObjectValidator.isEmpty(new HashSet()));
        assertTrue(ObjectValidator.isEmpty(new TreeSet()));

        Collection<String> collection = new ArrayList<>();
        String object = "string;";
        collection.add(object);
        assertFalse(ObjectValidator.isEmpty(collection));

        collection = new LinkedList<>();
        collection.add(object);
        assertFalse(ObjectValidator.isEmpty(collection));

        collection = new HashSet<>();
        collection.add(object);
        assertFalse(ObjectValidator.isEmpty(collection));

        collection = new TreeSet<>();
        collection.add(object);
        assertFalse(ObjectValidator.isEmpty(collection));
    }

    @Test
    public void isNotEmptyCollection() throws Exception {
        assertFalse(ObjectValidator.isNotEmpty((Collection) null));
        assertFalse(ObjectValidator.isNotEmpty(new ArrayList()));
        assertFalse(ObjectValidator.isNotEmpty(new LinkedList()));
        assertFalse(ObjectValidator.isNotEmpty(new HashSet()));
        assertFalse(ObjectValidator.isNotEmpty(new TreeSet()));

        Collection<String> collection = new ArrayList<>();
        String object = "string;";
        collection.add(object);
        assertTrue(ObjectValidator.isNotEmpty(collection));

        collection = new LinkedList<>();
        collection.add(object);
        assertTrue(ObjectValidator.isNotEmpty(collection));

        collection = new HashSet<>();
        collection.add(object);
        assertTrue(ObjectValidator.isNotEmpty(collection));

        collection = new TreeSet<>();
        collection.add(object);
        assertTrue(ObjectValidator.isNotEmpty(collection));
    }

    @Test
    public void isEmptyMap() throws Exception {
        assertTrue(ObjectValidator.isEmpty((Map) null));
        assertTrue(ObjectValidator.isEmpty(new HashMap()));
        assertTrue(ObjectValidator.isEmpty(new TreeMap()));

        Map<String, String> map = new HashMap<>();
        String object = "string;";
        map.put(object, object);
        assertFalse(ObjectValidator.isEmpty(map));

        map = new TreeMap<>();
        map.put(object, object);
        assertFalse(ObjectValidator.isEmpty(map));
    }

    @Test
    public void isNotEmptyMap() throws Exception {
        assertFalse(ObjectValidator.isNotEmpty((Map) null));
        assertFalse(ObjectValidator.isNotEmpty(new HashMap()));
        assertFalse(ObjectValidator.isNotEmpty(new TreeMap()));

        Map<String, String> map = new HashMap<>();
        String object = "string;";
        map.put(object, object);
        assertTrue(ObjectValidator.isNotEmpty(map));

        map = new TreeMap<>();
        map.put(object, object);
        assertTrue(ObjectValidator.isNotEmpty(map));
    }

    @Test
    public void isEmptyString() throws Exception {
        assertTrue(ObjectValidator.isEmpty((String) null));
        assertTrue(ObjectValidator.isEmpty(""));
        assertTrue(ObjectValidator.isEmpty("   "));
        assertTrue(ObjectValidator.isEmpty("          "));
        assertFalse(ObjectValidator.isEmpty("string"));
    }

    @Test
    public void isNotEmptyString() throws Exception {
        assertFalse(ObjectValidator.isNotEmpty((String) null));
        assertFalse(ObjectValidator.isNotEmpty(""));
        assertFalse(ObjectValidator.isNotEmpty("   "));
        assertFalse(ObjectValidator.isNotEmpty("          "));
        assertTrue(ObjectValidator.isNotEmpty("string"));
    }
}
