package application;

public class Product {
	private String name;
	private double price;
	private double sale;
	private int numOfCatalog;
    private String imgSrc;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public double getSale() {
		return sale;
	}

	public void setSale(double sale) {
		this.sale = sale;
	}

	public int getNumOfCatalog() {
		return numOfCatalog;
	}

	public void setNumOfCatalog(int numOfCatalog) {
		this.numOfCatalog = numOfCatalog;
	}

	public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
