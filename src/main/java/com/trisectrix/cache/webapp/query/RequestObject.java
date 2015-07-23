package com.trisectrix.cache.webapp.query;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Sriharsha Gangam
 */
public class RequestObject {

    private String key;

    public RequestObject(HttpServletRequest request) {

        this.key = request.getParameter("key");

        if (key == null) {
            key = "";
        }
    }

    public String getKey() {
        return key;
    }
}
