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


##### Delete a node from double linked list

##### Build a hashtable (delete/insert operation)

##### Implement data structure for Least Recent Used Cache

##### Insert an integer to order list

##### Insert an integer to circular list

##### Reverse a single linked list

##### Reverse the circular list

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


### Syntax

#### Strong and Emphasize 

**strong** or __strong__ ( Cmd + B )

*emphasize* or _emphasize_ ( Cmd + I )

**Sometimes I want a lot of text to be bold.
Like, seriously, a _LOT_ of text**

#### Blockquotes

> Right angle brackets &gt; are used for block quotes.

#### Links and Email

An email <example@example.com> link.

Simple inline link <http://chenluois.com>, another inline link [Smaller](http://25.io/smaller/), one more inline link with title [Resize](http://resizesafari.com "a Safari extension").

A [reference style][id] link. Input id, then anywhere in the doc, define the link with corresponding id:

[id]: http://25.io/mou/ "Markdown editor on Mac OS X"

Titles ( or called tool tips ) in the links are optional.

#### Images

An inline image ![Smaller icon](http://25.io/smaller/favicon.ico "Title here"), title is optional.

A ![Resize icon][2] reference style image.

[2]: http://resizesafari.com/favicon.ico "Title"

#### Inline code and Block code

Inline code are surround by `backtick` key. To create a block code:

	Indent each line by at least 1 tab, or 4 spaces.
    var Mou = exactlyTheAppIwant; 

####  Ordered Lists

Ordered lists are created using "1." + Space:

1. Ordered list item
2. Ordered list item
3. Ordered list item

#### Unordered Lists

Unordered list are created using "*" + Space:

* Unordered list item
* Unordered list item
* Unordered list item 

Or using "-" + Space:

- Unordered list item
- Unordered list item
- Unordered list item

#### Hard Linebreak

End a line with two or more spaces will create a hard linebreak, called `<br />` in HTML. ( Control + Return )  
Above line ended with 2 spaces.

#### Horizontal Rules

Three or more asterisks or dashes:

***

---

- - - -

#### Headers

Setext-style:

This is H1
==========

This is H2
----------

atx-style:

# This is H1
## This is H2
### This is H3
#### This is H4
##### This is H5
###### This is H6


### Extra Syntax

#### Footnotes

Footnotes work mostly like reference-style links. A footnote is made of two things: a marker in the text that will become a superscript number; a footnote definition that will be placed in a list of footnotes at the end of the document. A footnote looks like this:

That's some text with a footnote.[^1]

[^1]: And that's the footnote.


#### Strikethrough

Wrap with 2 tilde characters:

~~Strikethrough~~


#### Fenced Code Blocks

Start with a line containing 3 or more backticks, and ends with the first line with the same number of backticks:

```
Fenced code blocks are like Stardard Markdown’s regular code
blocks, except that they’re not indented and instead rely on
a start and end fence lines to delimit the code block.
```

#### Tables

A simple table looks like this:

First Header | Second Header | Third Header
------------ | ------------- | ------------
Content Cell | Content Cell  | Content Cell
Content Cell | Content Cell  | Content Cell

If you wish, you can add a leading and tailing pipe to each line of the table:

| First Header | Second Header | Third Header |
| ------------ | ------------- | ------------ |
| Content Cell | Content Cell  | Content Cell |
| Content Cell | Content Cell  | Content Cell |

Specify alignment for each column by adding colons to separator lines:

First Header | Second Header | Third Header
:----------- | :-----------: | -----------:
Left         | Center        | Right
Left         | Center        | Right


### Shortcuts

#### View

* Toggle live preview: Shift + Cmd + I
* Toggle Words Counter: Shift + Cmd + W
* Toggle Transparent: Shift + Cmd + T
* Toggle Floating: Shift + Cmd + F
* Left/Right = 1/1: Cmd + 0
* Left/Right = 3/1: Cmd + +
* Left/Right = 1/3: Cmd + -
* Toggle Writing orientation: Cmd + L
* Toggle fullscreen: Control + Cmd + F

#### Actions

* Copy HTML: Option + Cmd + C
* Strong: Select text, Cmd + B
* Emphasize: Select text, Cmd + I
* Inline Code: Select text, Cmd + K
* Strikethrough: Select text, Cmd + U
* Link: Select text, Control + Shift + L
* Image: Select text, Control + Shift + I
* Select Word: Control + Option + W
* Select Line: Shift + Cmd + L
* Select All: Cmd + A
* Deselect All: Cmd + D
* Convert to Uppercase: Select text, Control + U
* Convert to Lowercase: Select text, Control + Shift + U
* Convert to Titlecase: Select text, Control + Option + U
* Convert to List: Select lines, Control + L
* Convert to Blockquote: Select lines, Control + Q
* Convert to H1: Cmd + 1
* Convert to H2: Cmd + 2
* Convert to H3: Cmd + 3
* Convert to H4: Cmd + 4
* Convert to H5: Cmd + 5
* Convert to H6: Cmd + 6
* Convert Spaces to Tabs: Control + [
* Convert Tabs to Spaces: Control + ]
* Insert Current Date: Control + Shift + 1
* Insert Current Time: Control + Shift + 2
* Insert entity <: Control + Shift + ,
* Insert entity >: Control + Shift + .
* Insert entity &: Control + Shift + 7
* Insert entity Space: Control + Shift + Space
* Insert Scriptogr.am Header: Control + Shift + G
* Shift Line Left: Select lines, Cmd + [
* Shift Line Right: Select lines, Cmd + ]
* New Line: Cmd + Return
* Comment: Cmd + /
* Hard Linebreak: Control + Return

#### Edit

* Auto complete current word: Esc
* Find: Cmd + F
* Close find bar: Esc

#### Post

* Post on Scriptogr.am: Control + Shift + S
* Post on Tumblr: Control + Shift + T

#### Export

* Export HTML: Option + Cmd + E
* Export PDF:  Option + Cmd + P


### And more?

Don't forget to check Preferences, lots of useful options are there.

Follow [@Mou](https://twitter.com/mou) on Twitter for the latest news.

For feedback, use the menu `Help` - `Send Feedback`