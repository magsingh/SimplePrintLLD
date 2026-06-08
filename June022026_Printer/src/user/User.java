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
		
		PrintItem d7 = new PrintItem("Print doc 7", 30, 10);
		
		PrintItem d8 = new PrintItem("Print doc 8", 22, 3);
		PrintItem d9 = new PrintItem("Print doc 9", 23, 3); //Print queue full
		PrintItem d10 = new PrintItem("Print doc 10", 24, 3); //Print queue full
		PrintItem d11 = new PrintItem("Print doc 11", 25, 3); //Print queue full
		PrintItem d12 = new PrintItem("Print doc 12", 26, 3); //Print queue full
		
		PrintManager pm = new PrintManager();
		pm.submitDocForPrint(d1);
		pm.submitDocForPrint(d2);
		pm.submitDocForPrint(d3);
		pm.submitDocForPrint(d4);
		pm.submitDocForPrint(d5);
		pm.submitDocForPrint(d6);
		pm.submitDocForPrint(d7);
		pm.submitDocForPrint(d8);
		pm.submitDocForPrint(d9);
		pm.submitDocForPrint(d10);
		pm.submitDocForPrint(d11);
		pm.submitDocForPrint(d12);
		
		pm.processAllPrints();
		
		//Printer 2 is now OFFLINE
		PrintItem d13 = new PrintItem("Print doc 13", 27, 2);
		pm.submitDocForPrint(d13);
		
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

/*
Version 3: (check commit history)
If printer queue is full then print jobs get redirected to printer on nearest floor.
*/
