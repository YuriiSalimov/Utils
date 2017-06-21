package com.alex.utils.captcha;

import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URL;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public class ConnectionTest {

    private final static String ANY_STRING = "Some string...";

    private static Connection connection;

    @BeforeClass
    public static void sutUp() {
        try {
            connection = new Connection(
                    new URL("http://site.com?value=1"),
                    ANY_STRING,
                    ANY_STRING,
                    true
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getHttpsURLConnection() {
        try {
            connection.getHttpsURLConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}