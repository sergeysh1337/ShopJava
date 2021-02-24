package application;

public class Book {
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
    	return Math.round(sale);
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
    public String toString()
	{
		String info="bookName:"+name+"\n";
		info+="Price:"+price+"\n";
		info+="Sale:"+sale+"\n";
		info+="Number Of Catalog:"+numOfCatalog+"\n";
		return info;

	}
    public double getPriceAfterSale() {
    	double totalPrice = 0;
    	totalPrice+=price-(price*sale/100);
    	return Math.round(totalPrice);
    }
}
