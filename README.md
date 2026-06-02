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
