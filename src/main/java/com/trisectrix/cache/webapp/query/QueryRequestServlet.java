package com.trisectrix.cache.webapp.query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trisectrix.cache.store.MapCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sriharsha Gangam
 *
 */
public class QueryRequestServlet extends HttpServlet {

    public QueryRequestServlet(){}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        RequestObject requestObject = new RequestObject(request);
        String jsonResp = processRequest(requestObject);
        response.getWriter().println(jsonResp);
    }

    private String processRequest(RequestObject requestObject) {

        String key = requestObject.getKey();
        ResponseObject responseObject = new ResponseObject(new MapCache().get(key));

        ObjectMapper om = new ObjectMapper();
        String jsonVal;
        try {
            jsonVal = om.writeValueAsString(responseObject);
        } catch (IOException e) {
            e.printStackTrace();
            jsonVal = "Could not convert to json";
        }
        return jsonVal;
    }
}
