/**
 * 	Structure which contains and manages a grid of cells.
 */
public class Grid {

	private final int n;

	/**
	 *	The current step number.
	 */
	private int step = 0;

	private final Cell[][] grid;

	/**
 	 *	Instantiates the cells and sets each cell's neighborhood.
 	 *
 	 *	@param	n the size of the grid
 	 *	@param	m the size of the initially randomly filled center region
 	 *
 	 *	@throws	ArgException if <br> - m and/or n are not strictly positive
 	 *							<br> - m is greater than n
 	 *							<br> - m and n don't have the same parity
 	 */
	public Grid(int n, int m) throws ArgException {

		if (m < 1 || n < 1)
			throw new ArgException("Arguments are required to be strictly positive.");
		if (m > n)
			throw new ArgException("The second argument has to be smaller or equal than the first one.");
		if (m % 2 != n % 2)
			throw new ArgException("Arguments have to be of the same parity.");

		this.grid = new Cell[this.n = n][n];

		if (this.n < 2) {
			System.out.println("Warning" + " : " + "First argument should be greater than 1 for the simulation to be relevant.");
			this.grid[0][0] = new Cell();
			this.grid[0][0].setState(true);
			return;
		}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				// Differentiates left, right and normal cells by inheritance
				if (j == 0)
					this.grid[i][j] = new LeftCell();
				else if (j == this.n - 1)
					this.grid[i][j] = new RightCell();
				else
					this.grid[i][j] = new Cell();
				//	If the cell is in the central zone, fills it randomly
				if (i >= (n - m) / 2 && i < (n + m) / 2 && j >= (n - m) / 2 && j < (n + m) / 2)
					if (Math.random() < Cell.PROBABILITY)
						this.grid[i][j].setState(true);
			}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				// Counts neighbors
				int[][] x = new int[2][2];

				x[0][0] = i < Cell.RANGE ? i : Cell.RANGE;
				x[0][1] = (n - 1) - i < Cell.RANGE ? (n - 1) - i : Cell.RANGE;
				x[1][0] = j < Cell.RANGE ? j : Cell.RANGE;
				x[1][1] = (n - 1) - j < Cell.RANGE ? (n - 1) - j : Cell.RANGE;

				int nbr = (x[0][0] + x[0][1] + 1) * (x[1][0] + x[1][1] + 1) - 1;
				Cell[] neighborhood = new Cell[nbr];
				// Selects neighbors
				for (int k = - x[0][0]; k <= x[0][1]; k++)
					for (int l = - x[1][0]; l <= x[1][1]; l++)
						if (k != 0 || l != 0)
							neighborhood[--nbr] = this.grid[i + k][j + l];

				this.grid[i][j].setNeighborhood(neighborhood);
			}
	}

	/**
	 *	Returns the current step.
	 *
	 *	@return the current step
	 */
	 public int getStep() {
		 return this.step;
	 }

	/**
 	 *	Handles each cell's work for the next step.
 	 */
	public void nextStep() {
		this.step++;

		if (this.n != 1)
			for (int i = 0; i < this.n; i++)
				for (int j = 0; j < this.n; j++)
					this.grid[i][j].callNeighbors();

		for (int i = 0; i < this.n; i++)
			for (int j = 0; j < this.n; j++)
				this.grid[i][j].nextState();
	}

	/**
 	 *	Writes down the current state of the whole grid.
 	 *
 	 *	@return a representation of the grid
 	 */
	public String toString() {
		String string = "";

		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++)
				string += this.grid[i][j].toString(); // Asks each cell a representation of its state
			string += "\r\n";
		}

		return string;
	}

}
