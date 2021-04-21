/**
 * Observers implement this interface so that
 * their update() method is called by the subject
 * when the state of the subject changes.
 */
public interface Observer {
	/**
	 * This method is called when the state of the subject
	 * changes.
	 * @param stock - the specific stock has been traded
	 * @param newState - the new state of the subject
	 */
	public void update(Subject stock, Object newstate);
}
