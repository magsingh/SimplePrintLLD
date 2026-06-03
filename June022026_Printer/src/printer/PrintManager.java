package printer;

import java.util.HashMap;
import java.util.Iterator;

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
		System.out.println("Doc submitted to printer!");
		int fNo = i.getFloorNo();
		if (printers.containsKey(fNo)) {
			printers.get(fNo).printDoc(i);
			System.out.println("");
		} else {
			System.out.println("Printer not found");
		}
	}
	
	public void processAllPrints() {
		for (Printer p : printers.values()) {
			p.processAllPrintDocs();
		}
	}
}
