package websiteHelpers;

import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import scraper.GameTitle;

public class Helpers {

	public ArrayList<GameTitle> getGamePageData(HtmlPage pageData) {
		ArrayList<GameTitle> a = new ArrayList<>();
		System.out.println(pageData);
		List<HtmlElement> items = (List<HtmlElement>) pageData.getByXPath("//article");
		if (items.isEmpty()) {
			System.out.println("No items found !");
		} else {
			int x;
			GameTitle[] g = new GameTitle[items.size()];
			
			for (HtmlElement item : items) {
								
				HtmlAnchor itemAnchor = ((HtmlAnchor) item.getFirstByXPath(".//h2/a"));

				String itemName = itemAnchor.asText();
				String itemUrl = itemAnchor.getHrefAttribute();
				HtmlElement spanPrice = ((HtmlElement) item.getFirstByXPath(".//a[@class='mintPrice row']/span[@class='value']"));
				if(spanPrice == null) {
					spanPrice = ((HtmlElement) item.getFirstByXPath(".//a[@class='preownedPrice row']/span[@class='value price']"));
				}
				String itemPrice = spanPrice == null ? "no price" : spanPrice.asText();			
				g[items.indexOf(item)] = new GameTitle(itemName, itemPrice, itemUrl);			
				a.add(g[items.indexOf(item)]);			
			}
		}
		return a;
	}
	
}
