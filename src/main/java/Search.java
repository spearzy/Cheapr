

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

import scraper.GameTitle;
import scraper.Scraper;
import websiteHelpers.AmazonHelpers;
import websiteHelpers.GameHelpers;
import websiteHelpers.TescoHelpers;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HtmlPage page = null;
	Scraper scraper = new Scraper();
	GameHelpers gameHelper = new GameHelpers();
	TescoHelpers tescoHelper = new TescoHelpers();
    public Search() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("searchTerm"); // should be same name as form input name
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Hello World!</title></head>");
		out.println("<body><h1>Hello World! This is the doGet method responding.</h1></body></html>");
		System.out.println(name);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("Parameters are: ").append(name);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<GameTitle> allData = new ArrayList<>();
		ArrayList<GameTitle> data = new ArrayList<>();
		ArrayList<GameTitle> tescoData = new ArrayList<>();
		
		String searchTerm = request.getParameter("searchTerm");
		
		String[] companies = new String[2];
		
		companies[0] = "Game";
		companies[1] = "Tesco";
		
		for (int i = 0; i < companies.length; i++) {
			String url = scraper.generateURL(searchTerm, companies[i]);			
			page = scraper.getPage(url);
			if(page == null)
				System.out.println("An error occured");
			if(companies[i] == "Game") {
				data = gameHelper.getGamePageData(page);				
			} else if(companies[i] == "Tesco") {
				data = tescoHelper.getTescoPageData(page);
			}
				allData.addAll(data);
		}
		
		request.setAttribute("data", allData);
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
