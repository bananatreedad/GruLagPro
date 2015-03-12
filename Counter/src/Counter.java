/**
 * Counter which models a Counter on which you can click and after each click
 * the counter shows a by one increased digit. Sounds simple, is simple.
 * 
 * @author bananatreedad
 * 
 */
public class Counter {
	private int value;

	/**
	 * A click increases the value on the <code>Counter</code> once.
	 * 
	 */
	public void click() {
		this.value++;
	}
	
	/**
	 * Returns the <code>value</code> of the <code>Counter</code>.
	 * @return int Current <code>value</code> of <code>Counter</code>.
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Resets the <code>value</code> to zero.
	 */
	public void reset() {
		this.value = 0;
	}
	
}
