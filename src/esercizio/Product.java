package esercizio;

public class Product {

	private long id;
	private String name;
	private String category;
	private double price;

	public Product(long id, String name, String category, double price) {

		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(double id) {

		this.id = (long) id;
	}

	public String getCategory() {
		return category;
	}

	public void setAge(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
