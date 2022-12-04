package CST8221.hybrid.Week06;

import java.util.ArrayList;
import java.util.List;
/**
 * Class Cart
 * @author sousap
 *
 */
public class Cart {

	/**
	 * List of products
	 */
	private List<Product> productList;
	
	/**
	 * Total price
	 */
	private float totalPrice;

	/**
	 * Constructor
	 */
	public Cart() {
		this.productList = new ArrayList<Product>();
		totalPrice = 0.0f;
	}

	/**
	 * Add product
	 * @param item Product to be included.
	 */
	protected void addProduct(Product item) {
		this.productList.add(item);
		this.totalPrice += item.getPrice();
	}

	/**
	 * Delete the product
	 * @param item Product to be deleted.
	 */
	protected void delProduct(Product item) {
		if (this.productList.remove(item))
			this.totalPrice -= item.getPrice();
	}

	/**
	 * Getter for total price
	 * @return Total price
	 */
	protected float getTotalPrice() {
		return this.totalPrice;
	}
}