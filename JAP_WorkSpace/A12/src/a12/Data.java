
package a12;

/**
 * Class that stores the application's data
 * @author Quoc Thang Tran
 */
public class Data {

    private int dim ;
    private String type = "Number";
    private String input;
    
    /**
     * Default constructor
     */
    public Data() {}  
    
    /**
     * One-argument constructor
     * @param dim - the dimension's number
     */
    public Data(int dim) {
        this.dim = dim ;
    }

    /**
     * Set the dimension
     * @param n - the dimesion's number got from user
     */
    public void setDim(int n) {
    	dim = n;
    }
    
    /**
     * Set the dimension
     * @return dim - the dimension's number
     */
    public int getDim(){
    	return dim;
    }
    
    /**
     * Set the input's type (Text or Number)
     * @param x - the input's type got from user
     */
    public void setType(String x) {
    	type = x;
    }
    
    /**
     * get the input's type
     * @return type - the input's type got from user
     */
    public String getType() {
    	return type;
    }
    /**
     * Set the input got from user
     * @param x - the input got from user
     */
    public void setInput(String x) {
    	input = x;
    }
    
	/**
	 * Get the input got from user
	 * @return input - the input got from user
	 */
    public String getInput() {
    	return input;
    }
}