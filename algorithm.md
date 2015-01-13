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

Map<Integer,String> map = new HashMap<Integer,String>()
map.put(0, "zero")  
map.put(1, "one")  
map.put(2, "two")  
map.put(3, "three")  
map.put(4, "four")  
map.put(5, "five")  
map.put(6, "six")  
map.put(7, "seven")  
map.put(8, "eight")  
map.put(9, "nine")  
map.put(10, "ten")  
map.put(11, "eleven")  
map.put(12, "twelve")  
map.put(13, "thirteen")  
map.put(14, "fourteen")  
map.put(15, "fifteen")  
map.put(16, "sixteen")  
map.put(17, "seventeen")  
map.put(18, "eighteen")  
map.put(19, "nineteen")  
map.put(20, "twenty")  
map.put(30, "thirty")  
map.put(40, "forty")  
map.put(50, "fifty")  
map.put(60, "sixty")  
map.put(70, "seventy")  
map.put(80, "eighty")  
map.put(90, "ninety")  
map.put(100, "hundred")  
map.put(1000, "thousand")  
map.put(1000000, "million")  
map.put(1000000000, "billion")  
map.put(1000000000000, "brillion")  

String hundred(int[] arr)
{
		if(arr[0] > 0)
		{
			first = map.get(arr[0]*1)					}
		if(arr[1] > 0)
		{
			second = map.get(arr[1]*10)
		}
		if(arr[2] > 0)
		{
			if(arr[2] == 1)
				third = map.get(arr[2]*100) + "hundred"
			else 
				third = map.get(arr[2]*100) + "hundreds"
		}
		s = third + second + first + s
}

f(int n)
{
	h = Math.ceiling(log(1000, n)) + 1
	if(n == 0)
	{
	}
	else
	{ 
		col = 0
		while(n > 0)
		{
			r = n % 1000
			n = n / 1000
			
			row = 0
			while(r > 0)
			{
				rr = r % 100
				r = r / 100
				arr[col][row] = rr
				row++ 
			}
			col++
		}
	}
	
	s = ""
	for(i=0; i<h i++)
	{
		p = pow(1000, i)
		if(i == 0)
		{
			s = hundred(arr[i]) + s
		}
		else 
		{
			base = map.get(p)
			s = hundred(arr[i]) + base + s
		}
	}
}



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

	Convert(String str)
	{
		if(str != null)
		{
			List<String> list = str.split(" ")
			s = 0
			for(int i=0; i<list.size() i++)
			{
				b1000 = 1
				b100 = 1
				if(list[i] == "thousand" || list[i] == "million" || list[i] == "billion")
				{
					b1000 = map.get(list[i])
					b100 = 1
				}
				else
				{
					if(list[i] == "hundred")
					{
						b100 = map.get(list[i])
					}
					else
					{
						n = map.get(arr[i])
						s += n*b100*b1000
					}
				}
			}
			
		}
	}


2. e.g. five millons eleven thundreds thousand six thundreds and forty six(5110646)

5000000
110000
600
42

##### Given two integers, find the least common ancesor of binary tree
		Node LCA(Node curr, int n1, int n2)
		{
			if(curr != null)
			{
				if(curr.data == n1 || curr.data == n2)
				{
					return curr;
				}
				else
				{
					Node ln = LCA(curr.left)
					Node rn = LCA(curr.right)
					
					if(ln != null && rn != null)
					{
						return curr;
					}
					else if(ln != null)
					{
						return ln;
					}
					else if(rn != null)
					{
						return rn;
					}
				}
			}
			return null;
		}

##### Build a binary tree from preorder
* Given preorder nodes, and build a binary tree from the preorder nodes

##### Given an input expression that can contain positive integers, parenthesis or square brackets, return if the input is balanced, An expression is considered balanced if it has the following form: ( expression ) OR [ expression ] and if expression is also balanced

		//Use stack to check the whether the expression is balanced
		boolean isBalanced(String expression)
		{
			boolean ret = true;
			Stack<Character> stack = new Stack<Character>()
			for(i=0 i< expression.length() && ret i++)
			{	char ch = expression.charAt(i)
				
				if( ch == '[' || ch == '(')
				{
					stack.push(ch)
				}
				else if( ch == ']' || ch == ')')
				{
					ch left = stack.pop()
					if( (left == '[' && ch == ']') || (left == '(' && ch == ')') )
					{
						ret = false
					}
				} 
				else if(!('0' <= ch <= '9'))
				{
					ret = false
				}
			}
			
			//stack has to be empty
			if(!stack.empty())
				ret = false 
				
			return ret
		}

##### Find a maximum path in a binary tree

##### Print all the numbers from 1 to N in lexicographic order

##### Merge two sorted linked list

##### Sort a linked list

##### Mirror a binary tree

##### Find the longest path in a binary tree

##### Find the number of connected components in a two dimension array

##### Print a binary tree in level order
		void printLevelOrer(Node curr)
		{
			if(curr != null)
			{
				Queue<Node> q1 = new LinkedList<Node>()
				Queue<Node> q2 = new LinkedList<Node>()
				
				q1.enqueue(curr);
				while(!q1.empty() || !q2.empty())
				{
					while(!q1.empty())
					{
						Node node = q1.dequeue()
						print(node.data)
						
						if(node.left != null)
							q2.enqueue(node.left)
						if(node.right != null)
							q2.enqueue(node.right)
					}
					while(!q2.empty())
					{
						Node node = q2.dequeue()
						print(node.data)
						if(node.left != null)
							q1.enqueue(node.left)
						if(node.right != null)
							q1.enqueue(node.right)
					}
				}
				
			}
		}

##### Serialize binary tree and deserialize binary tree
* There are three(two) algorithms to serialize and deserialize a binary tree
	1. Use parent children relationship(parent->left right)
		if parent has no child, use special symbol to mark it(parent-># right)
		
	2. Use special character to indicate null nodes
	
	3. Use array to represent binary tree with leftchild = 2*k parent=k rightchild=2*k+1 
	relationship
			
##### Serialize/Deserialize N-ary			
	
##### Build a heap with array
	
##### Print out the first occurrence character from a stream
* Data Structure: HashMap and LinkedList	
* The Algorithm is similar to LRU/Least Recent Used Cache

##### Print all the node k distance from a given node
		class Node
		{
			Node left = null
			Node right = null
			Node parent = null
			boolean visited = false
			int data
			public Node(data)
			{this.data = data}
		}
		void FindKthDistance(Node curr, int k, int[] arr, int depth)
		{
			if(curr != null && !curr.visited)
			{
				curr.visited = true;
				arr[depth] = curr;
				if( k==0)
				{
					for(i=0 i<=depth; i++)
						arr[i]
				}
				else
				{	
					FindKthDistance(curr.left, k-1, depth++)
					FindKthDistance(curr.right, k-1, depth++)
					FindKthDistance(curr.parent, k-1, depth++)
				}
				
			}
		}

##### Print all the continuous/connected components from a 2D grid
		1. Use Depth First Search to find all connected squares

##### Find a path from top left corner to the right botton cornder in a maze

##### Given a binary tree, determine whether the tree is binary search tree or not

##### Given a binary tree, determine whether the tree is a sumtree or not


##### Delete a node from double linked list

##### Build a hashtable (delete/insert operation)

##### Implement data structure for Least Recent Used Cache

##### Insert an integer to order list

##### Insert an integer to circular list

##### Reverse a single linked list

##### Reverse the circular list

##### Given to polynomal p1[2, 0, 3, 4], p2[0, 4, 3, 5, 7] Multiply two polynomals p = p1*p2
		Using convolution C(k) = Sum(A(k)*B(m+n-k)) where k = 1 to m+n

##### Given two integers, determine the sum of two integers are overflowed
		isOverFlowed(int x, int y)
		{
			return x + y < x
		}
##### Given an integer, determine whether the integer is square number or not
		isSquareNum(int num)
		{
			return !(num - 1 & num);
		}

##### Find the longest increasing subsequence integers
		sub(i) = 1 + max(sub(i)), where if [j] < [i] 
		
##### Print out all the square number up to n without using multiplication, division and module 

		// 1 + 3 + 5 + 2k+1 = n*n
		//  (x-1)^2 = x^2 +1 - 2x
		//=> x^2 = (x-1)^2 + 2x - 1
		//=> x^2 = (x-1)^2 + (x - 1) + x
		SquareNumber(int n)
		{
			int prevSquare = 0
			int prev = 0
			for(i=1; i<n; i++)
			{
				prevSquare = prevSquare + prev + curr
				prev = curr
			}
		}
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
##### Given a sequence of words, print all anagrams
##### Inorder Preorder Postorder with iteration
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
 		
 		
##### Regular Expression
	* 	zero or more
	+ 	one or more
	?	zero or one
	*?	zero or more non greedy
	+? 	one or more non greedy
	??	zero or one non greedy
	
 		


