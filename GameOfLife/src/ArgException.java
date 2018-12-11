/**
 * 	SubClass of Exception which handles argument exceptions.
 */
class ArgException extends Exception {
	private static final long serialVersionUID = 123456L;
	public ArgException() { super(); }
	public ArgException(String s) { super(s); }
}
