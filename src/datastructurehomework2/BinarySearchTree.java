
package datastructurehomework2;
/**
 * @file DataStructureHomeWork2
 * @description Bu program bir klasör içindeki dosyaların içinde gelen kelimeleri sıklıklarına göre max heap yapısında listeler.
 * @assignment Ödev 2
 * @date 26.05.2020
 * @author Faruk Bera Zulaloglu farukbera.zulaloglu@stu.fsm.edu.tr
 */
public class BinarySearchTree {

	BNode root;
	int size;
	

	void insert(String newData) {
		size++;
		root = insert(root, newData);
	}

	private BNode insert(BNode node, String newData) {

		if(node == null){
			BNode newNode = new BNode(newData);
			return newNode;
			
		}
			if(newData.compareTo(node.data) < 0){
				node.rightChild = insert(node.rightChild, newData);
				//System.out.println("greater in alphabetic order");
			}
			else if(newData.compareTo(root.data) > 0){
				node.leftChild = insert(node.leftChild, newData);
				//System.out.println("smaller in alphabetical order");
			}
			else{
				//System.out.println("equal");
			}
		
		return node;

	}
	
	
	BNode getNode(String search){
		if(search(search) != null){
			return search(search);
		}
		return null;
	}
	
	MaxHeap buildMaxHeap(MaxHeap mH){
	
		buildMaxHeap(root,mH);
		
		return mH;
	}
	
	private MaxHeap buildMaxHeap(BNode root,MaxHeap mH){
		if(root == null){
			System.out.println("Empty -- build max heap");
		}
		else{
			System.out.println("build");
			mH.insert(root);
			buildMaxHeap(root.leftChild,mH);
			buildMaxHeap(root.rightChild,mH);
			return mH;
		}
		return null;
	}
	
	

	 BNode search( String search) {
		if (root == null) {
			System.out.println("Empty");
			return null;
		}
		BNode searchNode = root;
		while (searchNode != null) {
			if (search.compareTo(searchNode.data) < 0) {
				searchNode = searchNode.rightChild;
			} else if (search.compareTo(searchNode.data) > 0) {
				searchNode = searchNode.leftChild;
			} else {
				return searchNode;
			}
		}

		return searchNode;
	}
	 
	 boolean isExist( String search) {
		if (root == null) {
			System.out.println("Empty");
			return false;
		}
		BNode searchNode = root;
		while (searchNode != null) {
			if (search.compareTo(searchNode.data) < 0) {
				searchNode = searchNode.rightChild;
			} else if (search.compareTo(searchNode.data) > 0) {
				searchNode = searchNode.leftChild;
			} else {
				return true;
			}
		}

		return false;
	}
	 
	 
	void addFile(BNode node,String fileName){
		node.fileList.insert(fileName);
	}
	
	void printPreOrder() {
		System.out.println(size);
		System.out.println("PRE ORDER");
		preOrder(root);
		System.out.println("");
	}

	private void preOrder(BNode node) {
		
		if (node != null) {
			System.out.print("\nfrequance = "+node.data + "--->  FILES = ");
			node.fileList.print();
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}

	}

	

}
