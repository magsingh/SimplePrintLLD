package printer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class PrintManager {
	final private int TOTAL_FLOORS = 5;
	HashMap<Integer,Printer> printers;
	public PrintManager() {
		printers = new HashMap<Integer, Printer>();
		for (int i = 1; i <= TOTAL_FLOORS; i++) {
			printers.put(i,new Printer(i));
		}
	}
	
	public void submitDocForPrint(PrintItem i) {
		System.out.println("Submitting doc '" + i.getDoc() + "' to printer!");
		int fNo = i.getFloorNo();
		if (printers.containsKey(fNo)) {
			boolean res = printers.get(fNo).printDoc(i);
//			System.out.println("res = " + res);
			if (!res)
				reroutePrint(i);
		} else {
			System.out.println("Printer " + i.getFloorNo() + " not found");
		}
		System.out.println("");
	}
	
	private void reroutePrint(PrintItem i) {
		int fNo = i.getFloorNo();
		Scanner scr = new Scanner(System.in);
		System.out.print("Printer queue full on your floor. Want to try other floors? Type \n    1: Yes \n    2: No \n: ");
		int choice = scr.nextInt();
		//System.out.println("User choice is " + choice);
		if (choice != 1) {
			System.out.println("Job terminated");
			return;
		}
		int nearestPrinter = findNearestPrinter(fNo);
		if (nearestPrinter > 0 && nearestPrinter <= TOTAL_FLOORS) {
			System.out.println("Nearest available printer: " + nearestPrinter);
			printers.get(nearestPrinter).printDoc(i);
		} else
			System.out.println("No printer available- Please try again later!");
	}
	
	private int findNearestPrinter(int fNo) {
		//Check availability- if a lower floor printer is available?
		System.out.println("Check lower floor printer: ");
		int lFNo = -1;
		for (int lowerFloor = fNo - 1; lowerFloor > 0; lowerFloor--) {
			if (!(printers.get(lowerFloor).isFull())) {
				lFNo = lowerFloor;
				break;
			}
		}
		
		System.out.println("Check higher floor printer: ");
		//Check availability- if a higher floor printer is available?
		int hFNo = -1;
		for (int higherFloor = fNo + 1; higherFloor <= TOTAL_FLOORS; higherFloor++) {
			if (!printers.get(higherFloor).isFull()) {
				hFNo = higherFloor;
				break;
			}
		}
		if (lFNo != -1 && hFNo != -1) {
			if (fNo - lFNo <= hFNo - fNo)
				return lFNo;
			else
				return hFNo;
			
		} else if (lFNo != -1) {
			return lFNo;
		} else if (hFNo != -1) {
			return hFNo;
		}
		
		return 0;
	}
	
	public void processAllPrints() {
		for (Printer p : printers.values()) {
			p.processAllPrintDocs();
		}
	}
}
