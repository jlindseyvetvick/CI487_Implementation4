import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> {

	public static class TreeNode<E extends Comparable<E>> {

		E data;
		TreeNode<E> left;
		TreeNode<E> right;

		public TreeNode(E data) {
			this.data = data;
			left = null;
			right = null;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

	private TreeNode<E> root;
	private int size;

	public BinarySearchTree() {
		root = null;
		size = 0;
	}

	public void add(E data) {
		root = add(root, data);
		size++;
	}

	public int getSize() {
		return size;
	}

	private TreeNode<E> add(TreeNode<E> curr, E data) {
		if (curr == null) {
			return new TreeNode<>(data);
		} else if (data.compareTo(curr.data) > 0) {
			curr.right = add(curr.right, data);
		} else {
			curr.left = add(curr.left, data);
		}
		return curr;
	}

	public TreeNode<E> search(E data) {
		return search(root, data);
	}

	public TreeNode<E> search(TreeNode<E> curr, E data) {
		if (curr == null || data == curr.data) {
			return curr;
		} else if (data.compareTo(curr.data) < 0) {
			return search(curr.left, data);
		} else {
			return search(curr.right, data);
		}
	}

	public void remove(E data) {
		root = remove(root, data);
		size--;
	}

	private TreeNode<E> remove(TreeNode<E> curr, E data) {

		TreeNode<E> minNode = new TreeNode<E>(null);

		if (curr == null) {
			return null;
		}
		if (curr.data.compareTo(data) < 0) {
			curr.right = remove(curr.right, data);
		} else if (curr.data.compareTo(data) > 0) {
			curr.left = remove(curr.left, data);
		} else {
			if (curr.left == null && curr.right == null) {
				return null;
			} else if (curr.left == null) {
				return curr.right;
			} else if (curr.right == null) {
				return curr.left;
			} else {
				minNode = findMinNode(curr.right);
				curr.data = minNode.data;
				curr.right = remove(curr.right, minNode.data);
				return curr;
			}
		}
		return curr;
	}

	public TreeNode<E> findMinNode() {
		return findMinNode(root);
	}

	private TreeNode<E> findMinNode(TreeNode<E> curr) {
		while (curr.left != null) {
			curr = curr.left;
		}
		return curr;
	}

	/* Inorder Traversal */
	public void traverseInOrder() {
		System.out.print("Inorder Traversal: ");
		traverseInOrder(root);
		System.out.println();
	}

	private void traverseInOrder(TreeNode<E> curr) {
		if (curr == null) {
			return;
		} else {
			traverseInOrder(curr.left);
			System.out.print(curr.data + "  ");
			traverseInOrder(curr.right);
		}
		return;
	}

	/* Preorder Traversal */
	public void traversePreOrder() {
		System.out.print("Preorder Traversal: ");
		traversePreOrder(root);
		System.out.println();
	}

	private void traversePreOrder(TreeNode<E> curr) {
		if (curr == null) {
			return;
		} else {
			System.out.print(curr.data + "  ");
			traversePreOrder(curr.left);
			traversePreOrder(curr.right);
		}
		return;
	}

	/* Post Order Traversal */
	public void traversePostOrder() {
		System.out.print("Postorder Traversal: ");
		traversePostOrder(root);
		System.out.println();
	}

	private void traversePostOrder(TreeNode<E> curr) {
		if (curr == null) {
			return;
		} else {
			traversePostOrder(curr.left);
			traversePostOrder(curr.right);
			System.out.print(curr.data + "  ");
		}
		return;
	}
}
