package printer;

public class PrintItem {

	private static int printItemNo = 0;
	private String doc;
	private int userID;
	
	public PrintItem(String d, int id) {
		printItemNo++;
		doc = d;
		userID = id;
	}
	public void debugPrintItem() {
		System.out.println(" doc = " + doc + " userID = " + userID);
	}
}
