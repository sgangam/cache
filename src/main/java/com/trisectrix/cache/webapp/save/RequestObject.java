package com.trisectrix.cache.webapp.save;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Sriharsha Gangam
 */
public class RequestObject {

    private String key;
    private String value;

    public RequestObject(HttpServletRequest request) {

        this.key = request.getParameter("key");
        this.value = request.getParameter("value");

        if (key == null) {
            key = "";
        }

        if (value == null) {
            value = "";
        }
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
