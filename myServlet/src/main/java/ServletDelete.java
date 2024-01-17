import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import logic.Model;
import logic.User;

@WebServlet(urlPatterns = "/del")
public class ServletDelete extends jakarta.servlet.http.HttpServlet {
	
	Model model = Model.getInstance();
	
	protected void doDelete(jakarta.servlet.http.HttpServletRequest request,jakarta.servlet.http.HttpServletResponse response) throws IOException {
		
		PrintWriter pw = response.getWriter(); 
			
		int id = Integer.parseInt(request.getParameter("id"));
		model.del(id);
			
		pw.println("<html>" + 
				"<h3>Пользователь c Id: " + id +
				" успешно удален</h3>" +
				"<a href=\"index.jsp\">Домой</a>" + 
				"</html>");
	}
}
