package printer;

public class PrintManager {
	Printer mainPrinter;
	public PrintManager() {
		mainPrinter = new Printer();
	}
	
	public void submitDocForPrint(PrintItem i) {
		System.out.println("Doc submitted to printer!");
		mainPrinter.printDoc(i);
		System.out.println("");
	}
	
	public void processAllPrints() {
		mainPrinter.processAllPrintDocs();
	}
}
