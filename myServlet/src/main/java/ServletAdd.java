import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import logic.Model;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;
import logic.User;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonObject;
//import java.io.BufferedReader;
//import java.io.FileReader;

@WebServlet(urlPatterns = "/add")
public class ServletAdd extends jakarta.servlet.http.HttpServlet {

	private AtomicInteger counter = new AtomicInteger(4);
	Model model = Model.getInstance();
	//Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	///*
	protected void doPost(jakarta.servlet.http.HttpServletRequest request,jakarta.servlet.http.HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter(); 
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		double salary = Double.parseDouble(request.getParameter("salary"));
		
		User user = new User(name,surname,salary);
		model.add(user, counter.getAndIncrement());
		
		pw.println("<html>"+"<h3>Пользователь " + name + " " + surname + " с зарплатой " + salary + " успешно создано</h3>" + "<a href=\"addUser.html\">Создать новыого пользвателя</a><br/>" +
		"<a href=\"index.jsp\">Домой</a>"+"</html>");
	}
	//*/
	/*
	protected void doPost(jakarta.servlet.http.HttpServletRequest request,jakarta.servlet.http.HttpServletResponse response) throws IOException {
		StringBuffer jb = new StringBuffer();
		String line;
		
		try {
			BufferedReader reader = request.getReader();
			while((line = reader.readLine()) != null) {
				jb.append(line);
			}
		} catch(Exception e) {
			System.out.println("Error");
		}
			
		JsonObject jobj = gson.fromJson(String.valueOf(jb),JsonObject.class);
		
		request.setCharacterEncoding("UTF-8");
		
		String name = jobj.get("name").getAsString();
		String surname = jobj.get("surname").getAsString();
		Double salary = jobj.get("salary").getAsDouble();
		
		User user = new User(name,surname,salary);
		model.add(user, counter.getAndIncrement());
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		pw.print(gson.toJson(model.getFromList()));
		
		}
		*/
	
}
