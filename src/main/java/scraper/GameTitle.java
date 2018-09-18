package scraper;

public class GameTitle {
	
	private String name;
	private String price;
	private String console;
	private String url;
	private String image;
	
	public GameTitle(String name, String price, String console, String url, String image) {
		this.name = name;
		this.price = price;
		this.console = console;
		this.url = url;		
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.name = image;
	}
	
	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.name = console;
	}
	
}
