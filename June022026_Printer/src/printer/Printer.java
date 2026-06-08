package printer;

import java.util.LinkedList;
import java.util.Queue;

import enums.PrinterStatus;

public class Printer {
	private Queue<PrintItem> printQueue;
	private final int PRINT_Q_LIMIT = 2;
	private int floorNo = -1;
	private PrinterStatus printerStatus;
	
	public Printer(int flrNo) {
		printQueue = new LinkedList<>();
		floorNo = flrNo;
		printerStatus = PrinterStatus.ONLINE;
	}
	
	public boolean printDoc(PrintItem i) {
		System.out.print("Print doc enqueued: "); 
		i.debugPrintItem();
		if (printQueue.size() < PRINT_Q_LIMIT)
			printQueue.offer(i);
		else {
			System.out.println("###ERROR: Floor " + floorNo + " Queue Full!###");
			return false;
		}
		return true;
	}
	
	public void processPrintDoc() {
		if (printQueue.isEmpty()) {
			System.out.println("No more jobs to print");
			return;
		}
		PrintItem i = printQueue.poll();
		System.out.println("Printer:" + floorNo + " Printing: ");
		System.out.print("    ");
		i.debugPrintItem();
		System.out.println("");
	}
	
	public void processAllPrintDocs() {
		while (!printQueue.isEmpty()) {
			processPrintDoc();
		}
	}
	
	public boolean isFull() {
		System.out.println("Printer: " + floorNo + " printQueue.size = " + printQueue.size());
		if (printQueue.size() < PRINT_Q_LIMIT) {
			return false;
		}
		return true;
	}
	
	public boolean getPrinterStatus() {
		System.out.println("Printer " + floorNo + " is " + printerStatus);
		if (printerStatus == PrinterStatus.OFFLINE)
			return false;
		return true;
		
	}
	
	public void setPrinterStatus(PrinterStatus pStatus) {
		printerStatus = pStatus;
	}
}
