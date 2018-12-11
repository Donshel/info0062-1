/**
 * 	SubClass of ReportCell which writes its report left into its {@link toString} output.
 */
public class LeftCell extends ReportCell {

	/**
 	 *	Writes down the current state and a report of the cell's number of births and deaths.
 	 *
 	 *	@return	a representation of the cell
 	 */
	public String toString() {
		return this.stateReport() + " " + super.toString();
	}

}
