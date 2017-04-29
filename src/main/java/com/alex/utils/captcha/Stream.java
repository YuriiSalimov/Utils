package com.alex.utils.captcha;

import java.io.*;

import static com.alex.utils.validator.ObjectValidator.isNotNull;

/**
 * The class implements a set of methods
 * for working with streams.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
final class Stream {

    /**
     * Writes value in the stream.
     *
     * @param value        a value to write.
     * @param outputStream a output stream.
     * @throws IOException If an I/O error occurs.
     */
    static void write(
            final String value,
            final OutputStream outputStream
    ) throws IOException {
        try (final DataOutputStream stream = new DataOutputStream(outputStream)) {
            stream.writeBytes(value);
            stream.flush();
        }
    }

    /**
     * Reads response with the stream and returns response to string.
     *
     * @param inputStream a input stream.
     * @return The response to string.
     * @throws IOException If an I/O error occurs.
     */
    static String read(final InputStream inputStream) throws IOException {
        final StringBuilder response = new StringBuilder();
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String inputLine;
            while (isNotNull(inputLine = reader.readLine())) {
                response.append(inputLine);
            }
        }
        return response.toString();
    }
}
