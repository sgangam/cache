package com.trisectrix.cache.webapp;


import com.trisectrix.cache.webapp.query.QueryRequestServlet;
import com.trisectrix.cache.webapp.save.CacheRequestServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


/**
 *
 * @author Sriharsha Gangam
 */
public class WebServer {
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});
        resourceHandler.setResourceBase("./appfiles");

        ServletContextHandler serveletHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        serveletHandler.setContextPath("/");
        serveletHandler.addServlet(new ServletHolder(new CacheRequestServlet()), "/cache/*");

        ServletContextHandler queryHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        serveletHandler.setContextPath("/");
        serveletHandler.addServlet(new ServletHolder(new QueryRequestServlet()), "/query/*");

        HandlerCollection handlers = new HandlerCollection() ;
        handlers.setHandlers(new Handler[] {resourceHandler, serveletHandler,
                queryHandler, new DefaultHandler() } );
        server.setHandler(handlers);

        server.start();
        server.join();
    }
}
