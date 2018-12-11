/**
 * 	Abstract subClass of Cell which counts its number of births and deaths.
 */
public abstract class ReportCell extends Cell {

	private int nbrBirths = 0;
	private int nbrDeaths = 0;

	/**
 	 *	Replaces the current state by the new one and notices if a change occured.
 	 *
 	 *	@param 	state the new state
 	 *	@return	true if a change occured and false otherwise
 	 */
	public boolean setState(boolean state) {
		boolean xor = super.setState(state);

		if (xor)
			if (state)
				nbrBirths++;
			else
				nbrDeaths++;

		return xor;
	}

	/**
 	 *	Reports the number of births and deaths of the cell in a string.
	 *
	 *	@return a report of the number of births and deaths of the cell
 	 */
	protected String stateReport() {
		String report = " [+" + String.format("%3d", this.nbrBirths);
		report += " / -" + String.format("%3d", this.nbrDeaths) + "] ";

		return report;
	}

}
