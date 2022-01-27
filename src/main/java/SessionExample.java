import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionExample extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Session example</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Tomcat Session Example</h1>");
        out.println("<p>Hostname = " + System.getenv("HOSTNAME") + "</p>");

        HttpSession session = request.getSession(true);

        // print session info

        Date created = new Date(session.getCreationTime());
        Date accessed = new Date(session.getLastAccessedTime());
        out.println("<p>ID " + session.getId() + "</p>");
        out.println("<p>Created: " + created + "</p>");
        out.println("<p>Last Accessed: " + accessed + "</p>");

        // set session info if needed

        String dataName = request.getParameter("dataName");
        if (dataName != null && dataName.length() > 0) {
            String dataValue = request.getParameter("dataValue");
            session.setAttribute(dataName, dataValue);
        }

        // print session contents

        Enumeration e = session.getAttributeNames();
        while (e.hasMoreElements()) {
            String name = (String)e.nextElement();
            String value = session.getAttribute(name).toString();
            out.println(name + " = " + value);
        }
        // close tags
        out.println("</body>");
        out.println("</html>");
    }
}