	package user;

import printer.PrintItem;
import printer.PrintManager;

public class User {
	public static void main(String[] args) {
		PrintItem d1 = new PrintItem("Print doc 1", 100, 1);
		PrintItem d2 = new PrintItem("Print doc 2", 200, 2);
		PrintItem d3 = new PrintItem("Print doc 3", 30, 3);
		
		PrintItem d4 = new PrintItem("Print doc 4", 100, 1);
		PrintItem d5 = new PrintItem("Print doc 5", 222, 2);
		PrintItem d6 = new PrintItem("Print doc 6", 30, 4);
		
		PrintManager pm = new PrintManager();
		pm.submitDocForPrint(d1);
		pm.submitDocForPrint(d2);
		pm.submitDocForPrint(d3);
		pm.submitDocForPrint(d4);
		pm.submitDocForPrint(d5);
		pm.submitDocForPrint(d6);
		
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

/*
Version 2: (check commit history)
Added support of multiple floors
*/
