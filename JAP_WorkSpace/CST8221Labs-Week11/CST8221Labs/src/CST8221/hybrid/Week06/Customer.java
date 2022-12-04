package CST8221.hybrid.Week06;

/**
 * Class customer
 * @author sousap
 *
 */
public class Customer {

	/**
	 * Customer name
	 */
	private String name;
	
	/**
	 * Credit for customer
	 */
	private float credit;
	
	/**
	 * Cart of products.
	 */
	private Cart cart;

	/**
	 * Constructor
	 * @param custName Name of costumer.
	 * @param custCredit Credit to costumer.
	 */
	public Customer(String custName, float custCredit) {
		this.name = custName;
		this.credit = custCredit;
		this.cart = new Cart();
	}

	/**
	 * Getter for name
	 * @return Customer name.
	 */
	protected String getName() {
		return this.name;
	}

	/**
	 * Getter for cart.
	 * @return Cart from costumer.
	 */
	protected Cart getCart() {
		return this.cart;
	}

	/**
	 * Getter for credit.
	 * @return Customer credit.
	 */
	protected float getCredit() {
		return this.credit;
	}

	/**
	 * Payment from costumer.
	 * @param value Payment value
	 * @return Validity from payment.
	 */
	protected boolean doPayment(float value) {
		if (value > this.credit)
			return false;
		this.credit -= value;
		return true;
	}
}