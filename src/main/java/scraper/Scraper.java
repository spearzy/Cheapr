package scraper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import websiteHelpers.GameHelpers;

public class Scraper {

	public String generateURL(String searchQuery, String website) throws UnsupportedEncodingException {
		String url = "";
		if(website == "Game") {
			url = WebsiteUrls.Game;			
		} else if(website == "Amazon") {
			url = WebsiteUrls.Amazon;
		} else if(website == "Tesco") {
			url = WebsiteUrls.Tesco;
		}
		String websiteName = url.replace("{REPLACEME}", URLEncoder.encode(searchQuery, "UTF-8"));		
		System.out.println("website: " + websiteName);
		return websiteName;
	}
	
	public HtmlPage getPage(String url) {

		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		try {
			System.out.println(url);
			HtmlPage page = client.getPage(url);
			client.close();
			return page;
		} catch (Exception e) {
			e.printStackTrace();
		}
		client.close();
		return null;
		
	}

}
