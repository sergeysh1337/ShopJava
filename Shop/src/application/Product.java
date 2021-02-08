package application;

public class Product {
private String nameOfProduct;
private int numOfCatalog;
private double price;
private double sale;
public double getPrice()
{
	return price-=price*(sale/100);
}
public double getSale()
{
	return sale;
}
public void setPrice(int price)
{
	this.price=price;
}
public void setSale(int sale)
{
	this.sale=sale;
}
}
