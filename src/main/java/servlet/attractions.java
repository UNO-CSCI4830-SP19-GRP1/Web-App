package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;
@WebServlet(name = "calculate", urlPatterns = {"/calculate"})
public class attractions extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        final PrintWriter out = response.getWriter();
		String toPrint = "";
        toPrint +="<!DOCTYPE html>\n" +
            "<html lang='en'>\n" +
            "  <head>\n" +
            "    <meta charset='UTF-8'>\n" +
            "    <title>Suggested Attractions</title>\n" +
            "    <style>\n" +
            "      table, th, td { border:1px solid black;\n" +
            "                      padding:10px 30px 10px 30px; }\n" +
			"      table { display:inline-block; }\n" +
            "      .inline_wide { display: inline-block; width:100%; }\n" +
            "      body { text-align: center; }\n" +
            "      body > * { text-align: left; }\n" +
            "      form { display: inline-block; text-align:center; width:15% }\n" +
            "    </style>\n" +
            "  </head>\n" +
            "  <body>\n" +
            "  </body>\n" +
            "</html>\n";
		out.print(toPrint);
        out.close();
        return;
    } // end doPost method
    @Override
    public void doGet(HttpServletRequest request,
        HttpServletResponse response)
    throws ServletException, IOException {
        // HTTP GET requests are forwarded on to the doPost method
        // (i.e., toPost handles both HTTP GET and HTTP POST requests)
        doPost(request, response);
    } // end doGet method
} // end ToUpper class
