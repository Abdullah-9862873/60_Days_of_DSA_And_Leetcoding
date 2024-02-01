





/*
__________________________NOTES__________________________
__________________________Background______________________
---> Both arrays and ArrayLists in Java involve heap memory allocation, and their elements are often stored contiguously. The references to objects are used to access the actual data, and these references are typically stored contiguously, providing efficient access to the elements. However, the memory layout within the heap may not always be strictly contiguous due to factors like dynamic resizing and garbage collection.

________________________Terminologies_______________________
---> Every single box is called node, and that node has two internal variables, one is the value of the node and the other is whom it is pointing to... 
---> First node, on which no node is pointing is known as Head Node...
---> Last node, which is pointing to null rather than node is known as Tail Node...

*/