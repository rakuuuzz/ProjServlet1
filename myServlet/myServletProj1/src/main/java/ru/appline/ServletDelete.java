package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.appline.logic.Model;
import ru.appline.logic.User;

@WebServlet(urlPatterns = {"/del"})
public class ServletDelete extends HttpServlet {
    Model model = Model.getInstance();

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        Gson gson = new Gson();

        int id = Integer.parseInt(request.getParameter("id"));
        User deletedUser = model.getInstance().del(id);

        if (deletedUser != null) {
            String deletedUserJson = gson.toJson(deletedUser);
            pw.println("<html>" +
                    "<h3>Пользователь с Id: " + id +
                    " успешно удален:</h3>" +
                    deletedUserJson +
                    "<br/><a href=\"index.jsp\">Домой</a>" +
                    "</html>");
        } else {
            pw.println("<html>" +
                    "<h3>Пользователя с Id: " + id +
                    " не существует</h3>" +
                    "<a href=\"index.jsp\">Домой</a>" +
                    "</html>");
        }
    }
}
