
package wpd2.lab2;

import wpd2.lab2.servlet.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
    @SuppressWarnings("unused")
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    private static final int PORT = 9000;
    private final String shopName;

    private Runner(String shopName) {
        this.shopName = shopName;
    }

    //the start method, starts the server and sets up the servlets that the server knows
    private void start() throws Exception {

        //creating an instance of the server listening on the specified port
        Server server = new Server(PORT);

        //creating a servlet context handler defining the environment for the servlets to run, e.g. which folder
        //the root is mapped to
        ServletContextHandler handler = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        handler.setInitParameter("org.eclipse.jetty.servlet.Default." + "resourceBase", "src/main/resources/webapp");

        //instantiating DemoServlet, see class DemoServlet, and defining the requests that this responds to
        //and adding it to the server
        DemoServlet demoServlet = new DemoServlet(shopName);
        handler.addServlet(new ServletHolder(demoServlet), "/shop/*");


        MessageBoardServlet messageBoardServlet = new MessageBoardServlet();
        handler.addServlet(new ServletHolder(messageBoardServlet), "/bulletin/board");

        TopicServlet topicServlet = new TopicServlet();
        handler.addServlet(new ServletHolder(topicServlet), "/ViewTopic/*");

        //instantiating DefaultServlet and setting the requests that it responds to
        //and adding it to the server
        DefaultServlet ds = new DefaultServlet();
        handler.addServlet(new ServletHolder(ds), "/");

        //start the server
        server.start();
        LOG.info("Server started, will run until terminated");
        server.join();

    }

    public static void main(String[] args) {
        try {
            LOG.info("starting");
            new Runner("Demo Shop").start();
        } catch (Exception e) {
            LOG.error("Unexpected error running shop: " + e.getMessage());
        }
    }
}
