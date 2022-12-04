package CST8221.hybrid.Week06;

/**
 * Facade to be used in the online shopping
 * @author sousap
 *
 */
public class OrderFacade {
	
	/**
	 * Default constructor.
	 */
	public OrderFacade() {
		; // Empty declaration
	}
	
	/**
	 * Inclusion of product in the cart.
	 * @param customer User
	 * @param product Item to be included.
	 */
	protected void includeProduct(Customer customer, Product product) {
		Cart cart = customer.getCart();
		cart.addProduct(product);
	}
	
	/**
	 * Remotion of product in the cart.
	 * @param customer User
	 * @param product Item to be included.
	 */
	protected void removeProduct(Customer customer, Product product) {
		Cart cart = customer.getCart();
		cart.delProduct(product);
	}

	
	/**
	 * Shop finalization.
	 * @param customer User
	 * @return Indicator of the success.
	 */
	protected boolean finalizeShop(Customer customer) {
		Cart cart = customer.getCart();
		return customer.doPayment(cart.getTotalPrice());
	}

	/**
	 * Print status.
	 * @param customer User
	 * @return String about status.
	 */
	protected String printStatus(Customer customer) {
		String str = customer.getName() + " - Credit: " + customer.getCredit() + "\n";
		return str;
	}
}
