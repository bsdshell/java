import Lib.BST;

public class Hellok
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        test9();
    }

    public static void test9()
    {
		BST b1 = new BST();
		b1.Insert(9);
		b1.Insert(7);
		b1.Insert(12);
		b1.Insert(4);
		b1.Insert(8);
		b1.Insert(11);
		b1.Insert(13);

        Lib.Node prev = null;
        boolean isbst = isBST(b1.root, prev);
        System.out.println("isbst=" + isbst);
    } 

    public static boolean isBST(Lib.Node root, Lib.Node prev)
    {
        if( root != null)
        {
            if(!isBST(root.left, prev))
                return false;

            
            if(prev != null && prev.data >= root.data)
                return false;

            if(prev == null)
                System.out.println("(r=" + root.data + ", p=" + "null" + ")");
            else
                System.out.println("(r=" + root.data + ", p=" + prev.data + ")");

            prev = root; 
            
            if(!isBST(root.right, prev))
                return false;
        }
        return true;
    }
}
