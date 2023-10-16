/**
 * Utility
 * @author T540p
 *
 */
public class Utilities {
	
	public Utilities() {
		
	}
	/**
	 * This method help i waiting for some time
	 * @param seconds
	 */
	public void waitSomeTime(long seconds) {
		try {
			System.out.println("Waiting for " + seconds + " seconds before continuing....");
			Thread.sleep(seconds);
			System.out.println("I believe you saw the magic?('_')");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
