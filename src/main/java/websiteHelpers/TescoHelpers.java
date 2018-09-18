package websiteHelpers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import scraper.GameTitle;

public class TescoHelpers {

	public ArrayList<GameTitle> getTescoPageData(HtmlPage pageData) {

		ArrayList<GameTitle> a = new ArrayList<>();
		List<HtmlElement> items = (List<HtmlElement>) pageData.getByXPath("//ul[@class='product-list grid']/li");
		if (items.isEmpty()) {
			System.out.println("No items found !");
			return null;
		} else {
			int x;
			GameTitle[] g = new GameTitle[items.size()];
			for (HtmlElement item : items) {
				HtmlAnchor itemAnchor = ((HtmlAnchor) item.getFirstByXPath(".//div[@class='product-details--content']/a"));
				String itemName = itemAnchor.asText();
				String itemUrl = itemAnchor.getHrefAttribute();
				HtmlElement image = (item.<HtmlElement>getFirstByXPath(".//a/div/img"));
				String imageText = image.asXml();
				String itemImage = "";
				String itemConsole = "";
				Pattern p = Pattern.compile("\"([^\"]*)\"");
				Matcher m = p.matcher(imageText);
				if (m.find() && m.group().contains("jpg")) {
					itemImage = m.group(1);
					itemImage = itemImage.substring(itemImage.indexOf("%20768w,") + 1);
				}
				HtmlElement spanPrice = ((HtmlElement) item.getFirstByXPath(".//div[@class='price-control-wrapper']/div/div/span/span[@class='value']"));
				String itemPrice = spanPrice == null ? "no price" : "£" + spanPrice.asText();
				HtmlElement spanConsole = ((HtmlElement) item.getFirstByXPath(".//div[@class='product-details--content']/a[@class='product-tile--title product-tile--browsable']"));
				itemConsole = spanConsole.asText();
				String[] split = itemConsole.split(" ");
				itemConsole = split[split.length -2];
				g[items.indexOf(item)] = new GameTitle(itemName, itemPrice, itemConsole, itemUrl, itemImage);
				a.add(g[items.indexOf(item)]);
			}
		}
		return a;
	}
}