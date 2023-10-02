Compilation Instructions from /dir$

Compile Code
    javac -d bin src/ItemType.java
    javac -cp bin -d bin src/NodeType.java
    javac -cp bin -d bin src/BinarySearchTree.java
    javac -cp bin -d bin src/BinarySearchTreeDriver.java

Run Code
    java -cp bin BinarySearchTreeDriver file.txt


Time Complexities:

getSingleParent
	- if statements are constants. T = null = O(1)
	- recursive call are T(n/2) for left and right, so they add to T(n)
	- T(n) = aT(n) + 1, rule 2 applies, a = 1
	- T(n) = O(n) complexity
getNumLeafNodes
	- if statements are constants T = null, return 0. T = null, return 1.
	- recursive calls are T(n/2) for left and right, so they add to T(n)
	- T(n) = aT(n) + 2, rule 2 applies, a = 1
	- T(n) = O(2n) = O(n) complexity
getCousins
	- findParent method used,
	- findParent:
		- while last for n height of tree. O(n)
	- find parent used again to rescale tree for another level. O(n).
	- Therefore at O(n^2).
	- Rest of function in cousinPrinter is if statements
	- No recursion used. So O(n^2) complexity
