import jakarta.servlet.annotation.WebServlet;
import logic.Model;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import logic.User;


@WebServlet(urlPatterns = "/get")
public class ServletList extends jakarta.servlet.http.HttpServlet {

	Model model = Model.getInstance();
	
	protected void doGet(jakarta.servlet.http.HttpServletRequest request,jakarta.servlet.http.HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter(); 
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		if(id==0) {
			pw.print("<html>" + 
					"<h3>Доступные Пользователи" + 
					"Id пользователя: " + 
					"<ul>");
			
			for (Map.Entry<Integer, User> entry : model.getFromList().entrySet()) {
				pw.print("<li>"+ entry.getKey() + "</li>" + 
						"<ul>" + 
						"<li>Имя: " + entry.getValue().getName() + "</li>" + 
						"<li>Фамилия: " + entry.getValue().getSurname() +"</li>" + 
						"<li>Зарплата: " + entry.getValue().getSalary() + "</li>" +
						"</ul>" );
			}
			
			pw.print("</ui>" + "<a href=\"index.jsp\">Домой</a>" + "</html>");
		} else if (id > 0) {
			if (id > model.getFromList().size()) {
				pw.print("<html>" + 
						"<h3>Такого пользователя нет</h3>" + 
						"<a href=\"index.jsp\">Домой</a>" + 
						"</html>");
			} else {
				pw.print("<html>" + model.getFromList().get(id).getName() + " " + model.getFromList().get(id).getSurname() + " " + model.getFromList().get(id).getSalary() + "<br/>" + "<a href=\"index.jsp\">Домой</a>" + "</html>");
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
