package printer;

public class PrintItem {
	private String doc;
	private int userID;
	private int floorNo;
	
	public PrintItem(String d, int id, int fNo) {
		doc = d;
		userID = id;
		floorNo = fNo;
	}
	
	public void debugPrintItem() {
		System.out.println(" doc = '" + doc + "' userID = " + userID);
	}
	
	public int getFloorNo() {
		return floorNo;
	}
	
	public String getDoc() {
		return doc;
	}
}
