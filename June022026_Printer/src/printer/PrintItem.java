package printer;

public class PrintItem {

	private static int printItemNo = 0;
	private String doc;
	private int userID;
	private int floorNo;
	
	public PrintItem(String d, int id, int fNo) {
		printItemNo++;
		doc = d;
		userID = id;
		floorNo = fNo;
	}
	
	public void debugPrintItem() {
		System.out.println(" doc = " + doc + " userID = " + userID);
	}
	
	public int getFloorNo() {
		return floorNo;
	}
}
