import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import webhandlers.LikeServlet;
import webhandlers.LoginServlet;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(9000);

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(LikeServlet.class), "/users/*");
        handler.addServlet(new ServletHolder(LoginServlet.class), "/login/*");


        server.setHandler(handler);
        server.start();
        server.join();
    }
}
