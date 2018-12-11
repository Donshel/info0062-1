/**
 *	Structure which interacts with its neighborhood to change of state.
 */
public class Cell {

	/**
	 *	The width of the neighborhooding zone around the cell.
	 */
	public final static int RANGE = 1;

	/**
	 *	The probability a central cell has to be filled to true at start.
	 */
	public final static double PROBABILITY = 0.5;

	private final static int SURVIVE = 2;
	private final static int CREATE = 3;
	private final static int ASPHYXIATE = 4;

	private final static String ALIVE_STRING = "*";
	private final static String DEAD_STRING = "-";

	private boolean state = false;
	private boolean change = false;
	private int nbrNeighbors = 0;

	/**
	 *	The array which contains the cell's neighbors.
	 */
	private Cell[] neighborhood;

	/**
 	 *	Sets, or replaces, the neighborhood of the cell.
 	 *
 	 *	@param	neighborhood the new neighborhood
 	 */
	public void setNeighborhood(Cell[] neighborhood) {
		this.neighborhood = neighborhood;
	}

	/**
 	 *	Adjusts the number of alive neighbors of the cell's neighbors according to its (new) state.
 	 */
	public void callNeighbors() {
		if (this.change)
			for (int i = 0; i < this.neighborhood.length; i++)
				if (this.state)
					this.neighborhood[i].nbrNeighbors++;
				else
					this.neighborhood[i].nbrNeighbors--;

		this.change = false;
	}

	/**
 	 *	Determines the next state according to the number of alive neighbors.
 	 *
 	 *	@return	the new state
 	 */
	public boolean nextState() {
		if (this.nbrNeighbors < Cell.SURVIVE || this.nbrNeighbors >= Cell.ASPHYXIATE)
			this.setState(false);
		else if (this.nbrNeighbors >= Cell.CREATE)
			this.setState(true);

		return this.state;
	}

	/**
 	 *	Replaces the current state by the new one and notice if a change occured.
 	 *
 	 *	@param	state the new state
 	 *	@return	true if a change occured and false otherwise
 	 */
	public boolean setState(boolean state) {
		this.change = this.state ^ (this.state = state);
		return this.change;
	}

	/**
 	 *	Writes down the current state of the cell.
 	 *
 	 *	@return a representation of the cell
 	 */
	public String toString() {
		String string = this.state ? Cell.ALIVE_STRING : Cell.DEAD_STRING;
		return string + " ";
	}

}
