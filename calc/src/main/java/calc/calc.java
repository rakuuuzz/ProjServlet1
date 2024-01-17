package calc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/calc")
public class Calc extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder jb = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            jb.append(line);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jsonObject = gson.fromJson(jb.toString(), JsonObject.class);
        double a = jsonObject.get("a").getAsDouble();
        double b = jsonObject.get("b").getAsDouble();
        String math = jsonObject.get("math").getAsString();

        double result = 0;

        switch (math) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                break;
        }

        JsonObject resultObject = new JsonObject();
        resultObject.addProperty("result", result);

        response.setContentType("application/json");
        PrintWriter pw = response.getWriter();
        pw.print(resultObject.toString());
    }
}
