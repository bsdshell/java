* Given an array of integer/char, print all the permutation of integer/char
* E.g. Given "abc"
* permutation: abc, acb, bac, bca, cab, cba

####There are a few algorithms to generate permutation of the characters of a string in order

##### I will present two algorithms here
##### Algorithm 1 ( strings are not in order )
(e.g. abc, acb, bac, bca, cba, cab)

The algorithm is short, but it is not easy to understand why it works
In order to understand why the algorithm 1 works  
Some group theory are need to understand.  
In particular, it is called permutation group



##### Algorithm 2 ( string are in order)
(e.g. abc, acb, bac, bca, cab, cba)

This algorithm is relative easier to understand

0. Given a string "abc"
1. Choose the first character of the string and permute the rest of the character
	* permute("abc") => "a" permute("bc")
	* "a" permute("bc") => "a" "b" permute("c")
	* "a" "b" permute("c") => "a" "b" "c" permute("")


##### Algorithm 3 (Use permutation with repeated characters)
The algorithm is similar to (1), but strings with repeated characters are removed with HashSet

0. Image two dimension array  
	*. First, go down the rows vertically	
	*. Second, return to the previous row once the last row is reached. 
1. Permute all characters with Depth First Search
2. Remove all strings with duplicated characters with LinkedHashSet(keep insection order)

##### Algorithm to solve Eight Queen problem
1. Eight Queeen problem can be solved with permutation with repeated characters(algorithm 3)  
2. The two algorithms are "same"
3. They are both use Depth First Search and find the path from root to leaf node

##### Algorithm to solve sudoku 
1. Again, the algorithm to solve sudoku are very "similar" to Eight Queen algorithm 


##### Convert Number to English Words Algorithm
* Given an Integer 1240, output: one thousand two thundred forty 
* Use 2D array to store the integer in base 1000

map.put("0", "zero")  
map.put("1", "one")  
map.put("2", "two")  
map.put("3", "three")  
map.put("4", "four")  
map.put("5", "five")  
map.put("6", "six")  
map.put("7", "seven")  
map.put("8", "eight")  
map.put("9", "nine")  
map.put("10", "ten")  
map.put("11", "eleven")  
map.put("12", "twelve")  
map.put("13", "thirteen")  
map.put("14", "fourteen")  
map.put("15", "fifteen")  
map.put("16", "sixteen")  
map.put("17", "seventeen")  
map.put("18", "eighteen")  
map.put("19", "nineteen")  
map.put("20", "twenty")  
map.put("30", "thirty")  
map.put("40", "forty")  
map.put("50", "fifty")  
map.put("60", "sixty")  
map.put("70", "seventy")  
map.put("80", "eighty")  
map.put("90", "ninety")  
map.put("100", "hundred")  
map.put("1000", "thousand")  
map.put("1000000", "million")  
map.put("1000000000", "billion")  
map.put("1000000000000", "trillion")  


##### Convert English words number to numerical integer
1. e.g. two thousand four thundred and twelve (2411)
2000
400
11

2. e.g. five millons eleven thundreds thousand six thundreds and forty six(5110646)

5000000
110000
600
42

##### Build a binary tree from preorder
* Given preorder nodes, and build a binary tree from the preorder nodes

##### Find a maximum path in a binary tree

##### Mirror a binary tree

##### Find the longest path in a binary tree

##### Find the number of connected components in a two dimension array

##### Print a binary tree in level order

##### Serialize binary tree and deserialize binary tree
* There are three(two) algorithms to serialize and deserialize a binary tree
	1. Use parent children relationship(parent->left right)
		if parent has no child, use special symbol to mark it(parent-># right)
		
	2. Use special character to indicate null nodes
	
	3. Use array to represent binary tree with leftchild = 2*k parent=k rightchild=2*k+1 
	relationship
			
##### Serialize/Deserialize N-ary			
	
##### Build a heap with array
	
##### Inorder traveral with iteration
* Print out all the nodes in order traveral without using recursion


##### Print out the first occurrence character from a stream
* Data Structure: HashMap and LinkedList	
* The Algorithm is similar to LRU/Least Recent Used Cache

##### Print all the node k distance from a given node

##### Print all the continuous/connected components from a 2D grid
		1. Use Depth First Search to find all connected squares

##### Find a path from top left corner to the right botton cornder in a maze

##### Given a binary tree, determine whether the tree is binary search tree or not

##### Given a binary tree, determine whether the tree is a sumtree or not

##### Given a binary tree, determine whether the tree is height balanced

##### Delete a node from double linked list

##### Build a hashtable (delete/insert operation)

##### Implement data structure for Least Recent Used Cache

##### Insert an integer to order list

##### Insert an integer to circular list

##### Move all the spaces to Front of given string
	e.g string = " my cat is black"
	    output = "    mycatisblack"

##### Reverse a single linked list

##### Reverse the circular list
##### Binary Search in 2d array
		Revise the original algorithm

##### Clone a single linked list
##### Clone and reverse a single linked list
##### Clone double linked list
##### Clone and reverse a double linked list
##### Clone a list with random node
##### Clone a binary tree
##### Find the least common ancestor from two given nodes
##### Shuffle a n elements array with n random 
##### Print all the primes from 2 to n
	printPrime(int n)
	{
		boolean prime[n] = new boolean[n];
		prime[n] = true;
		for(int i=3; i<=n; i++)
			for(int j=2; j<i && prime[i]; j++)
			{
				if(prime[i] && i%j==0)
					prime[i] = false;
			}
		}
		//print all the primes
		for(int i=2; i<=n; i++)
		{
			if(prime[i])
				System.out.print(prime[i])
		}
	}
##### Given a sequence of words, print all anagrams
	str = "abc"
	a = 2
	b = 3
	c = 5
	
	abc = 2*3*5
	acb = 2*3*5
	
##### Inorder Preorder Postorder with iteration

	void PreorderIteration(Node curr)
	{
		Stack<Node> stack = new Stack<Node>();
		while(curr != null || !stack.empty())
		{
			if(curr != null)
			{
				System.out.print(curr.data);
				stack.push(curr);
				curr = curr.left;
			}
			else
			{
				Node node = stack.pop();
				curr = node.right;
			}
		}
	}

	void InorderIteration(Node curr)
	{
		Stack<Node> stack = new Stack<Node>();
		while(curr != null || !stack.empty())
		{
			if(curr != null)
			{
				stack.push(curr);
				curr = curr.left;
			}
			else
			{
				Node node = stack.pop();
				System.out.print(node.data)
				curr = node.right;
			}
		}
	}
	
	void PostorderIteration(Node curr)
	{
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		if(curr != null)
		{
			stack1.push(curr);
			while(!stack1.empty())
			{
				Node node = stack1.pop()
				stack2.push(node);
				if(node.left != null)
					stack1.push(node.left);
				if(node.right != null)
					stack2.push(node.right);
			}
			
			while(!stack2.empty())
			{	//print out all the node in post order
				System.out.print(stack2.pop().data);
			}
		}
	}
##### Excel Sheet row problem
		1. Given 

##### PostOrder Traversal in iteration
 		1. Use two stacks
 		2. Use one stack(e.g Stack<List<Node>> list(parent, left, right))
 		
 		Two Stacks Algorithm
 		
 		PostOrderIteration(Node root)
 		{
 			if(root != null)
 			{
 				Stack<Node> st1 = new Stack<Node>();
 				Stack<Node> st2 = new Stack<Node>();
 				st1.push(root)
 				whiel(!st1.empty())
 				{
 					Node node = st1.pop()
 					st2.push(node)
 					if(node.left != null)
 						st1.push(node.left)
 					if(node.right != null)
 						st1.push(node.right)
 					
 				}
 				while(!st2.empty())
 				{
 					print(st2.pop().data)
 				}
 			}
 		}
 		
##### PostOrder or Depth First Search in iteration 
		1. Use one Stack, one list, and hashmap
		
##### Given a string "123" and putchar, write a function to print out unsigned long decimal
		e.g. "123" -> 123
		int printLong(String s)
		{
			unsigned s=0;
			for(int i=s.length()-1; i >= 0 i--)
			{	//check '0' <= s.charAt(i) <= '9'
				int n = s.charAt(i) - '0';
				s += n*Math.pow(10, i);
			}
			return s;
		}
		
##### Given unsigned integer, write a function to print out the decimal(use preorder traversal)
		e.g 123 -> 1, 2, 3
		printDeciaml(unsigned num)
		{
			putchar('0'+num%10)
			if(num >= 10)
			{
				printDeciaml(num/10)
			}
		}
		
##### Given unsigned integer, write a function to print out the decimal in reverse order (use postorder traversal)
		e.g 123 -> 3, 2, 1
		printReverseDeciaml(unsigned num)
		{
			if(num >= 10)
			{
				printReverseDeciaml(num/10)
			}
			putchar('0'+num%10)
		}

##### Given a list, print all the node in order(use preorder traversal)
		e.g [1]->[2]->[3] output:[1] [2] [3]
		printNode(Node curr)
		{
			if(curr != null)
			{
				print(curr.data)
				printNode(curr.next)
			}
		}

##### Given a list, print all the node in reverse order (use postorder traversal)
		e.g [1]->[2]->[3] output: [3] [2] [1]
		printNode(Node curr)
		{
			if(curr != null)
			{
				printNode(curr.next)
				print(curr.data)
			}
		}
		
##### Find reverse pair of string in two arrays
		A1 = "6 2 8 9 7 1"
		A2 = "1 2 7 9 6"
		2 & 1
 		2 & 6
 		7 & 9
 		

 		


