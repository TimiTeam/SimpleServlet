package com.gmail.timurworkspace;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     resp.setContentType("text/html");
        resp.setBufferSize(8192);

        try(PrintWriter writer = resp.getWriter()) {
            writer.println("<html lang=\"en\">"
                    + "<head><title>Servlet Hello</title></head>");

            writer.println("<body  bgcolor=\"#ffffff\">"
                    + "<img src=\"resources/images/duke.waving.gif\" "
                    + "alt=\"Duke waving his hand\">"
                    + "<form method=\"get\">"
                    + "<h2>Hello, my name is Timur. What's yours?</h2>"
                    + "<input title=\"My name is: \" type=\"text\" "
                    + "name=\"username\" size=\"25\"/>"
                    + "<p></p>"
                    + "<input type=\"submit\" value=\"Submit\"/>"
                    + "<input type=\"reset\" value=\"Reset\"/>"
                    + "</form>");
            String username = req.getParameter("username");
            if(username != null && username.length() >0){
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/response");
                System.out.println(username);
                if(dispatcher != null){
                    dispatcher.include(req,resp);
                }
            }
            writer.println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public String getServletInfo() {
        return "The hello servlet say: 'My name is Sin'";
    }
}
