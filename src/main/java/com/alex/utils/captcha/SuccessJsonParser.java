package com.alex.utils.captcha;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

import static com.alex.utils.validator.ObjectValidator.isNotEmpty;

/**
 * The class implements a set of methods for working with JSON parser.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 */
final class SuccessJsonParser {

    /**
     * The 'success' associate.
     */
    private final static String ASSOCIATE = "success";

    /**
     * The JSON parser response.
     */
    private final String response;

    /**
     * Constructor.
     *
     * @param response a response to parse.
     */
    SuccessJsonParser(final String response) {
        this.response = response;
    }

    /**
     * Parses the response and return 'success' value.
     *
     * @return The 'Success' value.
     */
    boolean parse() {
        final boolean result;
        if (isNotEmpty(this.response)) {
            final JsonObject json = readJson();
            result = json.getBoolean(ASSOCIATE);
        } else {
            result = false;
        }
        return result;
    }

    /**
     * Creates and return a JSON reader using this response.
     *
     * @return the JSON object.
     */
    private JsonObject readJson() {
        try (StringReader stringReader = new StringReader(this.response);
                JsonReader jsonReader = Json.createReader(stringReader)) {
            return jsonReader.readObject();
        }
    }
}
