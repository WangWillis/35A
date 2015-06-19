public class Exercise31
{
	public static void main(String args[])
	{
		Character [] list = 
		{
			new Character('j'), new Character('p'),
			new Character('d'), new Character('f'),
			new Character('s'), new Character('b'),
			new Character('n'), new Character('k'),
			new Character('e'), new Character('w'),
			new Character('c'), new Character('r'),
			new Character('g')
		};
		BST tree = new BST(list);
		tree.inorder();
		System.out.println();
		tree.preorder();
		System.out.println();
		tree.postorder();
	}
}