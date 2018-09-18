package websiteHelpers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import scraper.GameTitle;

public class AmazonHelpers {

	public ArrayList<GameTitle> getAmazonPageData(HtmlPage pageData) {

		ArrayList<GameTitle> a = new ArrayList<>();
		System.out.println("PAGE DATA: " + pageData.asXml());
//		List<HtmlElement> items = (List<HtmlElement>) pageData.getByXPath("//article");
//		if (items.isEmpty()) {
//			System.out.println("No items found !");
//			return null;
//		} else {
//			int x;
//			GameTitle[] g = new GameTitle[items.size()];
//
//			for (HtmlElement item : items) {
//				HtmlAnchor itemAnchor = ((HtmlAnchor) item.getFirstByXPath(".//h2/a"));
//				String itemName = itemAnchor.asText();
//				String itemUrl = itemAnchor.getHrefAttribute();
//				HtmlElement image = (item.<HtmlElement>getFirstByXPath(".//a/img"));
//				String imageText = image.asXml();
//				String itemImage = "";
//				String itemConsole = "";
//				Pattern p = Pattern.compile("\"([^\"]*)\"");
//				Matcher m = p.matcher(imageText);
//				if (m.find() && m.group().contains("png")) {
//					itemImage = m.group(1);
//					System.out.println(m.group(1));
//				}
//				HtmlElement spanPrice = ((HtmlElement) item.getFirstByXPath(".//a[@class='mintPrice row']/span[@class='value']"));
//				if (spanPrice == null) {
//					spanPrice = ((HtmlElement) item.getFirstByXPath(".//a[@class='preownedPrice row']/span[@class='value price']"));
//				}
//				String itemPrice = spanPrice == null ? "no price" : spanPrice.asText();
//				HtmlElement spanConsole = ((HtmlElement) item.getFirstByXPath(".//div[@class='productHeader']/span"));
//				itemConsole = spanConsole.asText();
//				itemConsole = itemConsole.substring(1, itemConsole.length() - 1);
//				g[items.indexOf(item)] = new GameTitle(itemName, itemPrice, itemConsole, itemUrl, itemImage);
//				a.add(g[items.indexOf(item)]);
//			}
//		}
		return a;
	}

}
