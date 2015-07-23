package com.trisectrix.cache.webapp.save;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Sriharsha Gangam
 */
public class ResponseObject {

    private final String value;


    public ResponseObject(@JsonProperty("value") String value) {

        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
