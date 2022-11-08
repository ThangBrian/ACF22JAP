
package Model;

import javafx.scene.paint.Color;

/**
 * Model class
 * @author Quoc Thang Tran
 */
public class Data {

    private int dim;					// Dimension
    private int points;					// Player's points
    private int moves;					// Number of moves
    private StringBuilder movements;	// Record of moves
    private String type;				// Type of input (Text or Number)
    private String mode;				// design (create the game) or play (play the game)
    private Color colorCode;			// Code of the tile's color
    private boolean won = false;		// If the user wins
    private boolean showed = false;		// If the splash window is showed
    private boolean inputGiven = true;	// If input (for text type) is given
    private int[][] solution;			// Array for the solution
    private int[][] play;				// Array for the play mode
    private int[][] color;				// Array for colors of tiles			
    
    /**
     * Default constructor
     */
    public Data() {
    	dim = 3;
    	type = "Number";
    	mode = "design";
    	colorCode = Color.web("#80ff00");
    	movements = new StringBuilder("");
    	points = 0;
    	setMoves(0);
    	setSolution(null);
    	play = new int [dim][dim];
    	color = new int [dim][dim];   	
    	setPlay();
    }  
    
    /**
     * Function to check how much points the user currently has
     */
    public void checkPoint() {
    	int counter = 0;
    	for (int i =0;i<play.length;i++){
  	      for(int j =0;j<play[0].length;j++){   		
  	        if(play[i][j] == solution[i][j]) {
  	        	counter++;
  	        	setColor(i, j, 1); // Change color when the tile's position is correct
  	        }
  	        else {
  	        	setColor(i,j,0);
  	        }
  	      }  				
      	}
    	points=counter;
    }
    
    /**
     * Function to shuffle the tiles so the user can start to play
     */
    public void shuffleGame() {
    	
    	/*
    	 * Find the blank tile
    	 */
    	int col=-1, row=-1;
    	for (int i =0;i<play.length;i++){
  	      for(int j =0;j<play[0].length;j++){   		
  	        if(play[i][j] == 0)
  	        	row = i;
  	        	col = j;
  	      }  				
      	}
    	/*
    	 * Each loop will swap the blank tile and
    	 * a random tile next to it.
    	 */
    	for (int i =0;i<play.length*2;i++){
	      for(int j =0;j<play[0].length*2;j++){   		
	    	boolean done = false;
	    	while(done == false) {
	    		int randNum = (int)(Math.random() * (5 - 1)) + 1;
	    		int temp = play[row][col];
	    		switch(randNum) {
	    		case 1:
	    			if(col != play[0].length-1) {
	    				play[row][col] = play[row][col+1];
	    				play[row][col+1] = temp;
	    				col = col +1;
	    				done = true;
	    			}
	    			break;
	    		case 2:
	    			if(row != play.length-1) {
	    				play[row][col] = play[row+1][col];
	    				play[row+1][col] = temp;
	    				row=row+1;
	    				done = true;
	    			}
	    			break;
	    		case 3: 
	    			if(col != 0) {
	    				play[row][col] = play[row][col-1];
	    				play[row][col-1] = temp;
	    				col=col-1;
	    				done = true;
	    			}
	    			break;
	    		case 4:
	    			if(row != 0) {
	    				play[row][col] = play [row-1][col];
	    				play[row-1][col] = temp;
	    				row=row-1;
	    				done = true;
	    			}
	    			break;
	    		default:
	    			break;
	    		}
	    	}	
	      }  				
    	}
    }
    
    /**
     * Swap the chosen tile and the blank tile next to it (if possible)
     * @param row - row's index of the clicked tile
     * @param col - collumn's index of the clicked tile
     * @return - true if swap successfully and false if unsuccessfully 
     */
    public boolean move(int row, int col) {
    	int temp, row1=-1, col1=-1;
    	if(row==0) { // chosen tile on first row
    		if(col==0) { // first column
    			if(play[row][col+1] == 0) {
    				row1= row;
    				col1= col+1;
    			}
    			else if(play[row+1][col] == 0) {
    				row1 = row+1;
    				col1 = col;
    			}	
    		}
    		else if(col==play[0].length-1) { // last column
    			if(play[row][col-1]==0) {
    				row1=row;
    				col1 = col - 1;
    			}
    			else if(play[row+1][col] == 0) {
    				row1=row+1;
    				col1=col;
    			}
    		}
    		else { // middle column(s)
    			if(play[row][col-1] == 0) {
    				row1=row;
    				col1=col-1;
    			}
    			else if(play[row+1][col] ==0) {
    				row1=row+1;
    				col1=col;
    			}
    			else if(play[row][col+1] == 0) {
    				row1=row;
    				col1=col+1;
    			}
    		}
    	}
    	else if(row==play.length-1) { // Last row
    		if(col==0) {
    			if(play[row-1][col] == 0) {
    				row1=row-1;
    				col1=col;
    			}
    			else if(play[row][col+1]==0) {
    				row1=row;
    				col1=col+1;
    			}
    		}
    		else if(col==play[0].length-1) {
    			if(play[row][col-1] == 0) {
    				row1=row;
    				col1=col-1;
    			}
    			else if(play[row-1][col] == 0) {
    				row1=row-1;
    				col1=col;
    			}
    		}
    		else {
    			if(play[row][col-1] == 0) {
    				row1=row;
    				col1=col-1;
    			}
    			else if(play[row-1][col] ==0) {
    				row1=row-1;
    				col1=col;
    			}
    			else if(play[row][col+1] == 0) {
    				row1=row;
    				col1=col+1;
    			}
    		}
    	}
    	else { // middle row(s)
    		if(col==0) {
    			if(play[row-1][col] == 0) {
    				row1=row-1;
    				col1=col;
    			}
    			else if(play[row][col+1] == 0 ) {
    				row1=row;
    				col1=col+1;
    			}
    			else if(play[row+1][col] == 0) {
    				row1=row+1;
    				col1=col;
    			}
    		}
    		else if(col==play[0].length-1) {
    			if(play[row][col-1] == 0) {
    				row1=row;
    				col1=col-1;
    			}
    			else if(play[row-1][col] == 0) {
    				row1=row-1;
    				col1=col;
    			}
    			else if(play[row+1][col] == 0) {
    				row1=row+1;
    				col1=col;
    			}
    		}
    		else {
    			if(play[row][col-1] == 0) {
    				row1=row;
    				col1=col-1;
    			}
    			else if(play[row-1][col] == 0) {
    				row1=row-1;
    				col1=col;
    			}
    			else if(play[row][col+1] == 0 ) {
    				row1=row;
    				col1=col+1;
    			}
    			else if(play[row+1][col] == 0) {
    				row1=row+1;
    				col1=col;
    			}
    		}
    	}
    	if(col1!=-1 && row1!=-1) { // the tile is available to swap
    		temp = play[row][col];
    		play[row][col] = play[row1][col1];
    		play[row1][col1] = temp;
    		checkPoint(); // update points
    		if(points == dim*dim){ // play wins
    			setWon(true);
    		}
    		moves++; // update number of moves
    		addMovement(Integer.toString(row), Integer.toString(col));// Add the move to the moves' record
    		return true;
    	}
		return false; // the tile is unavailable to swap
    }

    /**
     * Set the dimension
     * @param n - the dimesion's number 
     */
    public void setDim(int n) {
    	dim = n;
    }
    
    /**
     * Get the dimension
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
     * Set the solution got from user
     * @param input - the text input got from user
     */
    public void setSolution(String input) {
    	solution = new int[dim][dim];
    	if(input == null && type.equalsIgnoreCase("Number")){ //type is number
    		for(int i=0; i<solution.length; i++) {
            	for(int j=0; j<solution[0].length; j++) {            			
            		if(!(i==(dim-1) && j==(dim-1)))
            			solution[i][j] = dim*i+j+1;		
            	}
            }
    	}
    	else if(input != null && type.equalsIgnoreCase("Text")){ //type is text and input is given
        	for(int i=0; i<solution.length; i++) {
            	for(int j=0; j<solution[0].length; j++) {
            		if(!(i==(dim-1) && j==(dim-1)) && (dim*i+j<input.length()))
            			solution[i][j] = input.charAt(dim*i+j);
            		if(dim*i+j>=input.length() && !(i==(dim-1) && j==(dim-1)))
            			solution[i][j] = 32;
            	}
            }
    	}
    	else if(input == null && type.equalsIgnoreCase("Text")) { //type is text and input is not given yet
    		for(int i=0; i<solution.length; i++) {
            	for(int j=0; j<solution[0].length; j++) {
            		if(!(i==(dim-1) && j==(dim-1)))
            			solution[i][j] = dim*i+j+1;
            	}
            }
    	}
    	play = new int[dim][dim];
    	color = new int[dim][dim];
    	setPlay(); 
    }
    
    /**
     * Get the value of inputGiven
     * @return - inputGiven
     */
	public boolean getInputGiven() {
		return inputGiven;
	}
	
	/** 
	 * Set the value of inputGiven
	 * @param inputGiven - whether the user has entered the text input
	 */
	public void setInputGiven(boolean inputGiven) {
		this.inputGiven = inputGiven;
	}
	
	/**
	 * Get the array of values for playing
	 * @return play - array of values for playing
	 */
	public int[][] getPlay() {
		return play;
	}

	/**
	 * Set the play array the same as the solution array
	 */
	public void setPlay() {
    	for(int i=0; i<solution.length; i++) {
        	for(int j=0; j<solution[0].length; j++) {
        		this.play[i][j] = solution[i][j];
        	}
        }
	}

	/**
	 * Get the current mode
	 * @return mode - current mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * Set the current mode
	 * @param mode - current mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * Get the user's current points
	 * @return points - current points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Set the user's current points
	 * @param points - current points
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	/**
	 * Get the user's current number of moves
	 * @return moves - current number of moves
	 */
	public int getMoves() {
		return moves;
	}

	/**
	 * Set the user's current number of moves
	 * @param moves - current number of moves
	 */
	public void setMoves(int moves) {
		this.moves = moves;
	}

	/**
	 * Get the moves' record
	 * @return movements - record of moves
	 */
	public StringBuilder getMovements() {
		return movements;
	}

	/**
	 * Add a move to the moves' record
	 * @param row - the moved tile's row index
	 * @param col - the moved tile's column index
	 */
	public void addMovement(String row, String col) {
		this.movements.append("(" + row + "," + col + ")" + "\n");
	}

	/**
	 * Delete the content of the moves' record
	 */
	public void deleteMovements() {
		if(this.movements.length()!=0)
			this.movements.delete(0, this.movements.length()-1);
	}

	/**
	 * Get the value of won (if the user wins yet)
	 * @return won - if the user wins yet
	 */
	public boolean isWon() {
		return won;
	}

	/**
	 * Set the value for won(if the user wins yet)
	 * @param won - if the user wins yet
	 */
	public void setWon(boolean won) {
		this.won = won;
	}

	/**
	 * Get the array of tiles' color
	 * @return color - array of tiles' color
	 */
	public int[][] getColor() {
		return color;
	}

	/**
	 * Set a tile's color
	 * @param row - tile's row index
	 * @param col - tile's column index
	 * @param value - 1 if the position is right and 0 if not
	 */
	public void setColor(int row, int col, int value) {
		this.color[row][col] = value; 
	}

	/**
	 * Get the color's code
	 * @return colorCode - the color's code
	 */
	public Color getColorCode() {
		return colorCode;
	}

	/**
	 * Set the color's code
	 * @param colorCode - the color's code
	 */
	public void setColorCode(Color colorCode) {
		this.colorCode = colorCode;
	}

	/**
	 * Get the value of showed
	 * @return showed - if the splash window is showed
	 */
	public boolean isShowed() {
		return showed;
	}

	/**
	 * Set the value of showed
	 * @param showed - if the splash window is showed
	 */
	public void setShowed(boolean showed) {
		this.showed = showed;
	}
}