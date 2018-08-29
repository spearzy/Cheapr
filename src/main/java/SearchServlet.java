

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("searchTerm"); // should be same name as form input name
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Hello World!</title></head>");
		out.println("<body><h1>Hello World!</h1></body></html>");
		System.out.println(name);
	}
}
