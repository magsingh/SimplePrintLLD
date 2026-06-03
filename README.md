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

<img width="402" height="612" alt="image" src="https://github.com/user-attachments/assets/a5828c2d-bd56-4bfd-8ee7-609e8a43aba1" />
