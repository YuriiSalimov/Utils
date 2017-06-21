package com.alex.utils.compressor;

import com.googlecode.htmlcompressor.compressor.Compressor;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 */
public abstract class AbstractCompressorTest {

    private final static String ANY_STRING = "Some string...";

    @Test
    public void whenCompressThenReturnNotEmptyString() {
        final Compressor compressor = getCompressor();
        final String result = compressor.compress(ANY_STRING);
        assertFalse(result.isEmpty());
    }

    @Test
    public void whenCompressNullThenReturnEmptyString() {
        final Compressor compressor = getCompressor();
        final String result = compressor.compress(null);
        assertTrue(result.isEmpty());
    }

    @Test
    public void whenCompressEmptyThenReturnEmptyString() {
        final Compressor compressor = getCompressor();
        final String result = compressor.compress("");
        assertTrue(result.isEmpty());
    }

    abstract Compressor getCompressor();
}