/* 
  Based on Source Tomcat Examples Source Code
*/
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorldExample extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");
        out.println("<p>Hostname = " + System.getenv("HOSTNAME") + "</p>");
        out.println("<p><a href=\"./sessionexample/\">SessionExample</a></p>");
        out.println("</body>");
        out.println("</html>");
    }
}
