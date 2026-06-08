1. Simple Printer- One printer on single floor
	+--------+       +--------------+       +---------+
	|  User  | ----> | PrintManager | ----> | Printer |
	+--------+       +--------------+       +---------+
						  |
						  |
						  v
					 +-----------+
					 | PrintItem |
					 +-----------+

	**Design Patterns Used**
	Queue-Based Processing:
	  -Printer uses a FIFO Queue (LinkedList).
	  -Documents are printed in the same order they are received.
	Facade Pattern (Lightweight):
	  -PrintManager hides printer implementation details from the user.
	  -User interacts only with PrintManager.

	**Output:**
	Doc submitted to printer!
	Print doc enqueued:  doc = Print doc 1 userID = 100

	Doc submitted to printer!
	Print doc enqueued:  doc = Print doc 2 userID = 200

	Doc submitted to printer!
	Print doc enqueued:  doc = Print doc 3 userID = 30

	Printing: 
		 doc = Print doc 1 userID = 100

	Printing: 
		 doc = Print doc 2 userID = 200

	Printing: 
		 doc = Print doc 3 userID = 30

2. One printer per floor with multiple floors
	Doc submitted to printer!
	Print doc enqueued:  doc = Print doc 1 userID = 100

	Doc submitted to printer!
	Print doc enqueued:  doc = Print doc 2 userID = 200

	Doc submitted to printer!
	Print doc enqueued:  doc = Print doc 3 userID = 30

	Doc submitted to printer!
	Print doc enqueued:  doc = Print doc 4 userID = 100

	Doc submitted to printer!
	Print doc enqueued:  doc = Print doc 5 userID = 222

	Doc submitted to printer!
	Print doc enqueued:  doc = Print doc 6 userID = 30


	Printer:1 Printing:
			doc = Print doc 1 userID = 100

	Printer:1 Printing:
			doc = Print doc 4 userID = 100

	Printer:2 Printing:
			doc = Print doc 2 userID = 200

	Printer:2 Printing:
			doc = Print doc 5 userID = 222

	Printer:3 Printing:
			doc = Print doc 3 userID = 30

	Printer:4 Printing:
			doc = Print doc 6 userID = 30

3. One printer per floor with multiple floors. If printer queue is full then print jobs get redirected to printer on nearest floor.
	Submitting doc 'Print doc 1' to printer!
	Print doc enqueued:  doc = 'Print doc 1' userID = 100

	Submitting doc 'Print doc 2' to printer!
	Print doc enqueued:  doc = 'Print doc 2' userID = 200

	Submitting doc 'Print doc 3' to printer!
	Print doc enqueued:  doc = 'Print doc 3' userID = 30

	Submitting doc 'Print doc 4' to printer!
	Print doc enqueued:  doc = 'Print doc 4' userID = 100

	Submitting doc 'Print doc 5' to printer!
	Print doc enqueued:  doc = 'Print doc 5' userID = 222

	Submitting doc 'Print doc 6' to printer!
	Print doc enqueued:  doc = 'Print doc 6' userID = 30

	Submitting doc 'Print doc 7' to printer!
	Printer 10 not found

	Submitting doc 'Print doc 8' to printer!
	Print doc enqueued:  doc = 'Print doc 8' userID = 22

	Submitting doc 'Print doc 9' to printer!
	Print doc enqueued:  doc = 'Print doc 9' userID = 23
	###ERROR: Floor 3 Queue Full!###
	Printer queue full on your floor. Want to try other floors? Type 
		1: Yes 
		2: No 
	: 1
	Check lower floor printer: 
	Printer: 2 printQueue.size = 2
	Printer: 1 printQueue.size = 2
	Check higher floor printer: 
	Printer: 4 printQueue.size = 1
	Nearest available printer: 4
	Print doc enqueued:  doc = 'Print doc 9' userID = 23

	Submitting doc 'Print doc 10' to printer!
	Print doc enqueued:  doc = 'Print doc 10' userID = 24
	###ERROR: Floor 3 Queue Full!###
	Printer queue full on your floor. Want to try other floors? Type 
		1: Yes 
		2: No 
	: 1
	Check lower floor printer: 
	Printer: 2 printQueue.size = 2
	Printer: 1 printQueue.size = 2
	Check higher floor printer: 
	Printer: 4 printQueue.size = 2
	Printer: 5 printQueue.size = 0
	Nearest available printer: 5
	Print doc enqueued:  doc = 'Print doc 10' userID = 24

	Submitting doc 'Print doc 11' to printer!
	Print doc enqueued:  doc = 'Print doc 11' userID = 25
	###ERROR: Floor 3 Queue Full!###
	Printer queue full on your floor. Want to try other floors? Type 
		1: Yes 
		2: No 
	: 1
	Check lower floor printer: 
	Printer: 2 printQueue.size = 2
	Printer: 1 printQueue.size = 2
	Check higher floor printer: 
	Printer: 4 printQueue.size = 2
	Printer: 5 printQueue.size = 1
	Nearest available printer: 5
	Print doc enqueued:  doc = 'Print doc 11' userID = 25

	Submitting doc 'Print doc 12' to printer!
	Print doc enqueued:  doc = 'Print doc 12' userID = 26
	###ERROR: Floor 3 Queue Full!###
	Printer queue full on your floor. Want to try other floors? Type 
		1: Yes 
		2: No 
	: 1
	Check lower floor printer: 
	Printer: 2 printQueue.size = 2
	Printer: 1 printQueue.size = 2
	Check higher floor printer: 
	Printer: 4 printQueue.size = 2
	Printer: 5 printQueue.size = 2
	No printer available- Please try again later!

	Printer:1 Printing: 
		 doc = 'Print doc 1' userID = 100

	Printer:1 Printing: 
		 doc = 'Print doc 4' userID = 100

	Printer:2 Printing: 
		 doc = 'Print doc 2' userID = 200

	Printer:2 Printing: 
		 doc = 'Print doc 5' userID = 222

	Printer:3 Printing: 
		 doc = 'Print doc 3' userID = 30

	Printer:3 Printing: 
		 doc = 'Print doc 8' userID = 22

	Printer:4 Printing: 
		 doc = 'Print doc 6' userID = 30

	Printer:4 Printing: 
		 doc = 'Print doc 9' userID = 23

	Printer:5 Printing: 
		 doc = 'Print doc 10' userID = 24

	Printer:5 Printing: 
		 doc = 'Print doc 11' userID = 25

4. Each printer has status via enum PrinterStatus. To simulate, printer 2 is marked OFFLINE in PrintManager.java.
	Submitting doc 'Print doc 1' to printer 1
	Printer 1 is ONLINE
	Print doc enqueued:  doc = 'Print doc 1' userID = 100

	Submitting doc 'Print doc 2' to printer 2
	Printer 2 is ONLINE
	Print doc enqueued:  doc = 'Print doc 2' userID = 200

	Submitting doc 'Print doc 3' to printer 3
	Printer 3 is ONLINE
	Print doc enqueued:  doc = 'Print doc 3' userID = 30

	Submitting doc 'Print doc 4' to printer 1
	Printer 1 is ONLINE
	Print doc enqueued:  doc = 'Print doc 4' userID = 100

	Submitting doc 'Print doc 5' to printer 2
	Printer 2 is ONLINE
	Print doc enqueued:  doc = 'Print doc 5' userID = 222

	Submitting doc 'Print doc 6' to printer 4
	Printer 4 is ONLINE
	Print doc enqueued:  doc = 'Print doc 6' userID = 30

	Submitting doc 'Print doc 7' to printer 10
	Printer 10 not found

	Submitting doc 'Print doc 8' to printer 3
	Printer 3 is ONLINE
	Print doc enqueued:  doc = 'Print doc 8' userID = 22

	Submitting doc 'Print doc 9' to printer 3
	Printer 3 is ONLINE
	Print doc enqueued:  doc = 'Print doc 9' userID = 23
	###ERROR: Floor 3 Queue Full!###
	Printer queue full on your floor. Want to try other floors? Type 
		1: Yes 
		2: No 
	: 1
	Check lower floor printer: 
	Printer: 2 printQueue.size = 2
	Printer: 1 printQueue.size = 2
	Check higher floor printer: 
	Printer: 4 printQueue.size = 1
	Nearest available printer: 4
	Print doc enqueued:  doc = 'Print doc 9' userID = 23

	Submitting doc 'Print doc 10' to printer 3
	Printer 3 is ONLINE
	Print doc enqueued:  doc = 'Print doc 10' userID = 24
	###ERROR: Floor 3 Queue Full!###
	Printer queue full on your floor. Want to try other floors? Type 
		1: Yes 
		2: No 
	: 1
	Check lower floor printer: 
	Printer: 2 printQueue.size = 2
	Printer: 1 printQueue.size = 2
	Check higher floor printer: 
	Printer: 4 printQueue.size = 2
	Printer: 5 printQueue.size = 0
	Nearest available printer: 5
	Print doc enqueued:  doc = 'Print doc 10' userID = 24

	Submitting doc 'Print doc 11' to printer 3
	Printer 3 is ONLINE
	Print doc enqueued:  doc = 'Print doc 11' userID = 25
	###ERROR: Floor 3 Queue Full!###
	Printer queue full on your floor. Want to try other floors? Type 
		1: Yes 
		2: No 
	: 1
	Check lower floor printer: 
	Printer: 2 printQueue.size = 2
	Printer: 1 printQueue.size = 2
	Check higher floor printer: 
	Printer: 4 printQueue.size = 2
	Printer: 5 printQueue.size = 1
	Nearest available printer: 5
	Print doc enqueued:  doc = 'Print doc 11' userID = 25

	Submitting doc 'Print doc 12' to printer 3
	Printer 3 is ONLINE
	Print doc enqueued:  doc = 'Print doc 12' userID = 26
	###ERROR: Floor 3 Queue Full!###
	Printer queue full on your floor. Want to try other floors? Type 
		1: Yes 
		2: No 
	: 1
	Check lower floor printer: 
	Printer: 2 printQueue.size = 2
	Printer: 1 printQueue.size = 2
	Check higher floor printer: 
	Printer: 4 printQueue.size = 2
	Printer: 5 printQueue.size = 2
	No printer available- Please try again later!

	Printer:1 Printing: 
		 doc = 'Print doc 1' userID = 100

	Printer:1 Printing: 
		 doc = 'Print doc 4' userID = 100

	Printer:2 Printing: 
		 doc = 'Print doc 2' userID = 200

	Printer:2 Printing: 
		 doc = 'Print doc 5' userID = 222

	Printer:3 Printing: 
		 doc = 'Print doc 3' userID = 30

	Printer:3 Printing: 
		 doc = 'Print doc 8' userID = 22

	Printer:4 Printing: 
		 doc = 'Print doc 6' userID = 30

	Printer:4 Printing: 
		 doc = 'Print doc 9' userID = 23

	Printer:5 Printing: 
		 doc = 'Print doc 10' userID = 24

	Printer:5 Printing: 
		 doc = 'Print doc 11' userID = 25

	Submitting doc 'Print doc 13' to printer 2
	Printer 2 is OFFLINE
	Printer queue full on your floor. Want to try other floors? Type 
		1: Yes 
		2: No 
	: 1
	Check lower floor printer: 
	Printer: 1 printQueue.size = 0
	Check higher floor printer: 
	Printer: 3 printQueue.size = 0
	Nearest available printer: 1
	Print doc enqueued:  doc = 'Print doc 13' userID = 27

	Printer:1 Printing: 
		 doc = 'Print doc 13' userID = 27

