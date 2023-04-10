package com.example.howstrongpasword.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/userdata")
public class PasswordDataController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("pass");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Formularz</title>\n" +
                "</head>");
        writer.println("<body>\n" +
                "<h1>Podaj swoje dane:</h1>\n" +
                "<form action=\"userdata\" method=\"post\">\n" +
                "    <fieldset>\n" +
                "        <legend>Wpisz hasło które ma zostac sprawdzone</legend>\n" +
                "        <label for=\"password\">Hasło</label>\n" +
                "        <input type=\"password\" name=\"pass\" id=\"password\" value=\"" + password + "\"><br>\n" +
                "    </fieldset>\n" +
                "    <input type=\"submit\" value=\"Sprawdź\">\n" +
                "</form>");
        boolean check = true;
        if (!checkLong(password)){
            writer.println("<h1>* Nie podano wystarczającej ilości znaków, wystarczająca ilość znaków to 9</h1>");
            check = false;
        }
        if (!checkSmallLetter(password)){
            writer.println("<h1>* Nie podano małej litery, konieczne jest podanie małej litery</h1>");
            check = false;
        }
        if (!checkBigLetter(password)){
            writer.println("<h1>* Nie podano wielkiej litery, konieczne jest podanie wielkiej litery</h1>");
            check = false;
        }
        if (!checkSpecialChar(password)){
            writer.println("<h1>* Nie podano znaku specjalnego, konieczne jest podanie jednego z następujących znaków: !,\",#,$,%,&,',(,),*,+.</h1>");
            check = false;
        }


        if (check){
            writer.println("<h1>Hasło wystarczająco silne, gratuluje!!!</h1>");
        }
    }

    private boolean checkLong(String pass){
        int minLength = 9;
        boolean check = false;
        if (pass.length() >= minLength){
            check = true;
        }
        return check;
    }
    private boolean checkSmallLetter(String pass){
        int minValue = 97, maxValue = 122;
        boolean check = false;
        for (char c: pass.toCharArray()){
            if (c >= minValue && c <= maxValue){
                check = true;
                break;
            }
        }
        return check;
    }

    private boolean checkBigLetter(String pass){
        int minValue = 65, maxValue = 90;
        boolean check = false;
        for (char c: pass.toCharArray()){
            if (c >= minValue && c <= maxValue){
                check = true;
                break;
            }
        }
        return check;
    }

    private boolean checkSpecialChar(String pass){
        int minValue = 33, maxValue = 43;
        boolean check = false;
        for (char c: pass.toCharArray()){
            if (c >= minValue && c <= maxValue){
                check = true;
                break;
            }
        }
        return check;
    }


}
