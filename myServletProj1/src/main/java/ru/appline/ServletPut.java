package ru.appline;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.Model;
import ru.appline.logic.User;

@WebServlet(urlPatterns = {"/put"})
public class ServletPut extends HttpServlet {
    Model model = Model.getInstance();

    protected void doPut(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        Gson gson = new Gson();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        double salary = Double.parseDouble(request.getParameter("salary"));

        pw.println("<html>" + "<h3>Пользователь " +
                name + " " +
                surname +
                " с зарплатой " +
                salary +
                " успешно изменен на: </h3>" +
                "<a href=\"addUser.html\">Создать нового пользователя</a><br/>" +
                "<a href=\"index.jsp\">Домой</a>" + "</html>");

        User user = new User(name, surname, salary);
        model.getFromList().put(id, user);

        String userJson = gson.toJson(user);

        pw.println("<html>" +
                userJson +
                "<a href=\"addUser.html\">Создать нового пользователя</a><br/>" +
                "<a href=\"index.jsp\">Домой</a>" +
                "</html>");
    }
}
