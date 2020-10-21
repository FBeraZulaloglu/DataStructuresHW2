
package datastructurehomework2;
/**
 * @file DataStructureHomeWork2
 * @description Bu program bir klasör içindeki dosyaların içinde geçen kelimeleri sıklıklarına göre max heap yapısında listeler.
 * @assignment Ödev 2
 * @date 26.05.2020
 * @author Faruk Bera Zulaloglu farukbera.zulaloglu@stu.fsm.edu.tr
 */
public class BNode {
	// added data should be only just string 
	BNode leftChild;
	BNode rightChild;
	BNode nextNode;// for sorting in sortied list
	String data;
	LinkedList fileList = new LinkedList();

	public BNode(String data) {
		this.data = data;
	}
	
	int getFrequency(){
		int freq = 0;
		 // control whether node is  in any file
		if(this.fileList.head != null){
			Node temp = this.fileList.head;
			while(temp != null){
				freq += temp.frequency;
				temp = temp.nextNode;
			}
		}
		return freq;
	}
	
	
}
