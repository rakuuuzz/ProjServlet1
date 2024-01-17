package ru.appline;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.Model;
import ru.appline.logic.User;

@WebServlet(urlPatterns = {"/get"})
public class ServletList extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        Model model = Model.getInstance();
        PrintWriter pw = response.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        int id = Integer.parseInt(request.getParameter("id"));

        if (id == 0) {
            pw.print("<html>" +
                    "<h3>Доступные Пользователи" +
                    "Id пользователя: " +
                    "<ul>");

            for (Map.Entry<Integer, User> entry : model.getFromList().entrySet()) {
                String userJson = gson.toJson(entry.getValue());
                pw.print("<li>" + entry.getKey() + "</li>" +
                        "<ul>" +
                        userJson +
                        "</ul>");
            }

            pw.print("</ui>" + "<a href=\"index.jsp\">Домой</a>" + "</html>");
        } else if (id > 0) {
            if (id > model.getFromList().size()) {
                pw.print("<html>" +
                        "<h3>Такого пользователя нет</h3>" +
                        "<a href=\"index.jsp\">Домой</a>" +
                        "</html>");
            } else {
                User user = model.getFromList().get(id);
                String userJson = gson.toJson(user);
                pw.print("<html>" + userJson + "<br/>" + "<a href=\"index.jsp\">Домой</a>" + "</html>");
            }
        } else {
            if (id > model.getFromList().size()) {
                pw.print("<html>" +
                        "<h3>Id должен быть больше 0</h3>" +
                        "<a href=\"index.jsp\">Домой</a>" +
                        "</html>");
            }
        }
    }

}
