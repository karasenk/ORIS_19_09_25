package ru.itis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>Привет, это мой первый сервлет!</h1>");
        out.println("<p>Текущее время: " + new java.util.Date() + "</p>");
        out.println("<form method=\"post\" action=\"/hello\">");
        out.println("<input id=\"email\" name=\"email\">");
        out.println("<input id=\"name\" name=\"name\">");
        out.println("<input type=\"submit\">");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("info_from_form.txt")))
            {
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            if (email.contains("@") && !name.isEmpty()) {
                writer.write(email);
                writer.newLine();
                writer.write(name);
                writer.flush();
                writer.close();
                response.sendRedirect("success");
            }
            else {
                throw new ServletException("The email address must contain an @, and the name cannot be empty.");
            }
        } catch (Exception e){
            PrintWriter out = response.getWriter();
            out.println(e.getMessage());
        }
    }
}
