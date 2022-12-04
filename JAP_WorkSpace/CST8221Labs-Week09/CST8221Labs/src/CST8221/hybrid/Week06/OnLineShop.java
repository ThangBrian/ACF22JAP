package CST8221.hybrid.Week06;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Facade from costumer.
 * @author sousap
 *
 */
public class OnLineShop {
	
	/**
	 * Default constructor.
	 */
	public OnLineShop() {
		; // Empty declaration
	}
	
	/**
	 * Basic method for simulating on-line shopping.
	 */
	public void simulation() {
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product("Book", 20.0f));
		productList.add(new Product("Notebook", 5.0f));
		productList.add(new Product("Gift", 50.5f));
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(new Customer("John", 1000.0f));
		customerList.add(new Customer("Mary", 2000.0f));
		OrderFacade order = new OrderFacade();
		order.includeProduct(customerList.get(0), productList.get(0));
		order.includeProduct(customerList.get(1), productList.get(1));
		order.removeProduct(customerList.get(0), productList.get(0));
		order.includeProduct(customerList.get(0), productList.get(2));
		order.finalizeShop(customerList.get(0));
		order.finalizeShop(customerList.get(1));
		String str = "";
		String str1 = order.printStatus(customerList.get(0));
		String str2 = order.printStatus(customerList.get(1));
		str = str1 + str2;
		JOptionPane.showMessageDialog(null, str, "Facade simulator",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
