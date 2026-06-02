package printer;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {
	private Queue<PrintItem> printQueue;
	public Printer() {
		printQueue = new LinkedList<>();
	}
	
	public void printDoc(PrintItem i) {
		System.out.print("Print doc enqueued: "); 
		i.debugPrintItem();
		printQueue.offer(i);
	}
	
	public void processPrintDoc() {
		if (printQueue.isEmpty()) {
			System.out.println("No more jobs to print");
			return;
		}
		PrintItem i = printQueue.poll();
		System.out.println("Printing: ");
		System.out.print("    ");
		i.debugPrintItem();
		System.out.println("");
	}
	
	public void processAllPrintDocs() {
		while (!printQueue.isEmpty()) {
			processPrintDoc();
		}
	}
}
