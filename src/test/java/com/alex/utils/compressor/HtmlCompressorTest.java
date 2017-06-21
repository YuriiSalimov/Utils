package com.alex.utils.compressor;

import org.junit.BeforeClass;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 */
public class HtmlCompressorTest extends AbstractCompressorTest {

    private static HtmlCompressor compressor;

    @BeforeClass
    public static void beforeClass() {
        compressor = new HtmlCompressor();
    }

    @Override
    HtmlCompressor getCompressor() {
        return compressor;
    }
}
