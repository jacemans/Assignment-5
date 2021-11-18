/**
 * The external Tree Node for Linked Trees
 * 
 * @author Justin Hixson
 *
 * @param <T> data type of TreeNode
 */
public class TreeNode<T> {

	private T data;
	private TreeNode<T> left, right;

	/**
	 * New TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode the data node
	 */
	public TreeNode(T dataNode) {
		left = null;
		right = null;
		data = dataNode;
	}
	/**
	 * Used for making deep copies
	 * @param node the node
	 */
	public TreeNode(TreeNode<T> node) {
		left = node.left;
		right = node.right;
		data = node.data;
	}
	/**
	 * Return the data within this TreeNode
	 * @return the data within the TreeNode
	 */
	public T getData() {
		return data;
	}

	protected TreeNode<T> getLeft() {
		return left;
	}

	protected void setLeft(TreeNode<T> node) {
		left = node;
	}

	protected TreeNode<T> getRight() {
		return right;
	}

	protected void setRight(TreeNode<T> node) {
		right = node;
	}
}
