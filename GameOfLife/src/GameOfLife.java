/**
 *	GameOfLife is the executive class.
 *
 *	@author	François Rozet - s161024
 */
public class GameOfLife {

	/**
 	 *	Instantiates the grid, calls and prints each step.
 	 *
	 * 	@param 	args the array which contains the arguments :
 	 *			<br> args[0] (n) - a length s.t. n * n is the size of the grid (default = 10)
 	 *			<br> args[1] (m) - a length s.t. m * m is the size of the initially randomly filled center region (default = 10)
 	 *			<br> args[2] (end) - the number of steps to compute (infinite if 0) (default = 0)
 	 */
	public static void main(String[] args) {
		int n = 10;
		int m = 10;
		int end = 0;
		final int wait = 500;

		if (args.length < 2)
			System.out.println("Warning" + " : " + "This method needs at least two arguments. Variables set to default.");
		else
			try {
				n = Integer.parseUnsignedInt(args[0]);
				m = Integer.parseUnsignedInt(args[1]);
				if (args.length > 2)
					end = Integer.parseUnsignedInt(args[2]);
			} catch(NumberFormatException e1) {
				System.err.println(e1.getClass().getSimpleName() + " : " + "Arguments have to be positive integers.");
				System.exit(0);
			}

		try {
			Grid gridOfLife = new Grid(n, m); // Instantiates the grid
			do {
				System.out.println(gridOfLife.toString()); // Prints the current grid
				gridOfLife.nextStep(); // Calls the next step
				Thread.sleep(wait);
			} while (gridOfLife.getStep() != end);
		} catch (Exception e2) {
			System.err.println(e2.getClass().getSimpleName() + " : " + e2.getMessage());
			System.exit(0);
		}
	}

}
