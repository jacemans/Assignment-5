import java.util.ArrayList;
/**
 * This is a MorseCodeTree which is specifically used for the conversion of morse code to english
 * 
 * @author Justin Hixson
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	private TreeNode<String> root;
	
	/**
	 * Constructor - calls the buildTree method
	 */
	public MorseCodeTree() {
		buildTree();
	}
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}
	/**
	 * sets the root of the Tree
	 * @param newNode a TreeNode<String> that will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}
	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * @return the linkedConverterTree with the new node added
	 */
	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		addNode(root, code, result);
		
		return this;
	}
	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		TreeNode<String> node = new TreeNode<>(letter);
		
		if (code.length() == 1) {
			if (code.equals(".")) {
				root.setLeft(node);
			} else {
				root.setRight(node);
			}
		}
		else {
			String newCode = code.substring(1);
			
			if (code.charAt(0) == '.') {
				addNode(root.getLeft(), newCode, letter);
			} else {
				addNode(root.getRight(), newCode, letter);
			}
		}
	}
	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}
	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String fetch = "";
		
		if (code.length() == 0) {
			return "";
		}
		
		if (code.length() == 1) {
			if (code.equals(".")) {
				fetch = root.getLeft().getData();
			} else {
				fetch = root.getRight().getData();
			}
		}
		else {
			String newCode = code.substring(1);
			
			if (code.charAt(0) == '.') {
				fetch = fetchNode(root.getLeft(), newCode);
			} else if(code.charAt(0) == '-') {
				fetch = fetchNode(root.getRight(), newCode);
			}
		}
		
		return fetch;
	}
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException not supported for a LinkedConverterTree
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("This operation is not supported for a LinkedConverterTree");
	}
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException not supported for a LinkedConverterTree
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("This operation is not supported for a LinkedConverterTree");
	}
	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<String> into their proper locations
	 */
	@Override
	public void buildTree() {
		 root = new TreeNode<>("");

		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}
	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<>();
		LNRoutputTraversal(root, list);
		
		return list;
	}
	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<String> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root != null) {
			LNRoutputTraversal(root.getLeft(), list);
			list.add(root.getData());
			LNRoutputTraversal(root.getRight(), list);
		}
	}
}
