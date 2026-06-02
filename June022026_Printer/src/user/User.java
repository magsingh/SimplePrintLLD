	package user;

import printer.PrintItem;
import printer.PrintManager;

public class User {
	public static void main(String[] args) {
		PrintItem d1 = new PrintItem("Print doc 1", 100);
		PrintItem d2 = new PrintItem("Print doc 2", 200);
		PrintItem d3 = new PrintItem("Print doc 3", 30);
		
		PrintManager pm = new PrintManager();
		pm.submitDocForPrint(d1);
		pm.submitDocForPrint(d2);
		pm.submitDocForPrint(d3);
		
		pm.processAllPrints();
	}
}

/*
Queue-Based Processing
	-Printer uses a FIFO Queue (LinkedList).
	-Documents are printed in the same order they are received.
Facade Pattern (Lightweight)
	-PrintManager hides printer implementation details from the user.
	-User interacts only with PrintManager.
 */
