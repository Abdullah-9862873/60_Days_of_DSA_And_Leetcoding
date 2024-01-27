/*
Vectors are same as arraylist but the difference is that in arraylist multiple threads can access the arraylist at a time but vector does not allow it and only one thread can access it at a time while the other have to wait for its turn...

It has some benefits like fewer system resource usage, predicted resources, execution order prediction, resolution of concurrency issues like deadlocks...

Deadlock is a situation in concurrent programming where two or more threads are unable to proceed because each is waiting for the other to release a resource.
Coffman conditions tells us the causes of deadlocks which are circular wait, hold and wait, mutual exclusion, No preemption...

Thread synchronization is a mechanism used in concurrent programming to ensure that multiple threads access shared resources in a coordinated and orderly manner. It prevents issues such as data corruption, race conditions, and inconsistencies that can arise when multiple threads try to modify shared data simultaneously.

 */