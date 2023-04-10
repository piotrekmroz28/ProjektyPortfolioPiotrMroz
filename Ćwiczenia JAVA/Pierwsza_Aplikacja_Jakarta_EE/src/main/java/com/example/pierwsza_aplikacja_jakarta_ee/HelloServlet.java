package com.example.pierwsza_aplikacja_jakarta_ee;

import java.io.*;
import java.util.Enumeration;
import java.util.Map;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/Films")
public class HelloServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println("------");
        System.out.println(parameterMap.size());
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        if (parameterMap.size() > 0){
            for (String key : parameterMap.keySet()) {
                for (String value : parameterMap.get(key)) {
                    writer.println("<iframe id='ytplayer' type='text/html' width='640' height='360' src='http://www.youtube.com/embed/" + value + "' frameborder='0'></iframe>");
                    System.out.println("  -" + value);
                }
            }
        } else {
            writer.println("<h2>Nie przekazano żadnych adresów filmów</h2>");
            writer.println("<h2>Aby przekazac filmy po kliknięciu w link uzupełnij url o dowolne zmienne get z nazwą identyfikatora filmu</h2>");
        }
    }

    public void destroy() {
    }
}