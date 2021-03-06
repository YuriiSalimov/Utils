package com.alex.utils.captcha;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;

import static com.alex.utils.validator.ObjectValidator.isNull;

/**
 * The class implements a set of methods for working
 * with https URL connection.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 */
final class Connection {

    /**
     * The request URL.
     */
    private final URL url;

    /**
     * The user agent.
     */
    private final String userAgent;

    /**
     * The accept language.
     */
    private final String acceptLanguage;

    /**
     * The do output.
     */
    private final boolean doOutput;

    /**
     * The https URL connection.
     */
    private HttpsURLConnection connection;

    /**
     * Constructor.
     *
     * @param url            the request URL.
     * @param userAgent      the user agent.
     * @param acceptLanguage the accept language.
     * @param doOutput       the do output.
     */
    Connection(
            final URL url,
            final String userAgent,
            final String acceptLanguage,
            final boolean doOutput
    ) {
        this.url = url;
        this.userAgent = userAgent;
        this.acceptLanguage = acceptLanguage;
        this.doOutput = doOutput;
    }

    /**
     * Creates and returns https URL connection.
     *
     * @return The https URL connection.
     * @throws IOException If an I/O error occurs.
     */
    HttpsURLConnection getHttpsURLConnection() throws IOException {
        if (isNull(this.connection)) {
            createHttpsURLConnection();
        }
        return this.connection;
    }

    /**
     * Creates https URL connection.
     *
     * @throws IOException If an I/O error occurs.
     */
    private void createHttpsURLConnection() throws IOException {
        this.connection = openHttpsURLConnection();
        this.connection.setRequestMethod("POST");
        this.connection.setRequestProperty("User-Agent", this.userAgent);
        this.connection.setRequestProperty("Accept-Language", this.acceptLanguage);
        this.connection.setDoOutput(this.doOutput);
    }

    /**
     * Returns a HttpsURLConnection instance that represents
     * a connection to the remote object referred to by the URL.
     *
     * @return a HttpsURLConnection linking to the URL.
     * @throws IOException if an I/O exception occurs.
     */
    private HttpsURLConnection openHttpsURLConnection() throws IOException {
        return (HttpsURLConnection) this.url.openConnection();
    }
}
