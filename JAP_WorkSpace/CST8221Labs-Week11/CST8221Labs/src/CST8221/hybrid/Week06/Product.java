package CST8221.hybrid.Week06;

/**
 * Product calss
 * @author sousap
 *
 */
public class Product {

	/**
	 * Product name.
	 */
	private String name;
	
	/**
	 * Unit price
	 */
	private float unitPrice;

	/**
	 * Constructor
	 * @param prodName Name of the product.
	 * @param prodUnitPrice Unitary price.
	 */
	public Product(String prodName, float prodUnitPrice) {
		this.name = prodName;
		this.unitPrice = prodUnitPrice;
	}

	/**
	 * Getter for product
	 * @return Product name.
	 */
	protected String getName() {
		return this.name;
	}

	/**
	 * Getter for price.
	 * @return Product price.
	 */
	protected float getPrice() {
		return this.unitPrice;
	}

}