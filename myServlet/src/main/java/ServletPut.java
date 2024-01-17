import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import java.util.HashMap;
import java.util.Map;
import logic.Model;
import logic.User;

@WebServlet(urlPatterns = "/put")
public class ServletPut extends jakarta.servlet.http.HttpServlet {
Model model = Model.getInstance();
	
	protected void doPut(jakarta.servlet.http.HttpServletRequest request,jakarta.servlet.http.HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		Map<Integer, User> users = model.getFromList();
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter(); 
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		double salary = Double.parseDouble(request.getParameter("salary"));
		
		pw.println("<html>"+"<h3>Пользователь " + 
				name + " " + 
				surname + 
				" с зарплатой " + 
				salary + 
				" успешно изменен на: </h3>" + 
				"<a href=\"addUser.html\">Создать новыого пользвателя</a><br/>" +
				"<a href=\"index.jsp\">Домой</a>"+"</html>");
		
		User user = new User(name,surname,salary);
		users.put(id, user);
		
		pw.println("<html>"+
					name + " " + 
					surname + 
					" с зарплатой " + 
					salary + 
					"<a href=\"addUser.html\">Создать новыого пользвателя</a><br/>" +
					"<a href=\"index.jsp\">Домой</a>" + 
					"</html>");
	}
}
