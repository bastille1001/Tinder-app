import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;

public class StaticServlet extends HttpServlet {
    private final String subPath;
    public StaticServlet(String subPath) { this.subPath = subPath; }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = new BufferedReader(new FileReader(new File("content/index.html")))
                .lines()
                .collect(Collectors.joining("\n"));
        try (PrintWriter writer = resp.getWriter()){
            writer.write(result);
        }
    }
}
