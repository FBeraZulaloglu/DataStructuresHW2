
package datastructurehomework2;
/**
 * @file DataStructureHomeWork2
 * @description Bu program bir klasör içindeki dosyaların içinde gelen kelimeleri sıklıklarına göre max heap yapısında listeler.
 * @assignment Ödev 2
 * @date 26.05.2020
 * @author Faruk Bera Zulaloglu farukbera.zulaloglu@stu.fsm.edu.tr
 */
public class LinkedList{
	Node head;
	
	void insert(Node newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.nextNode != null) {
                temp = temp.nextNode;
            }

            temp.nextNode = newNode;
        }
		//System.out.println("File listesine Listeye eleman eklendi");
    }
	// add file function is the same function in the bst
	void addFile(String fileName){
		insert(fileName);
	}

    void insert(String newData) {
        insert(new Node(newData));
    }
	
	
	boolean isExist(String data){
		Node temp = head;
		while(temp != null){
			if(temp.data.equals(data)){
				return true;
			}
			temp = temp.nextNode;
		}
		return false;
	}
	
	private boolean isEmpty(){
		return head==null;
	}
	
	Node getFile(String fileName){
		Node temp = head;
		while(temp != null){
			if(temp.data.equals(fileName)){
				return temp ;
			}
			temp = temp.nextNode;
		}
		return null;
	}
	
	void print(){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data+"("+temp.frequency+")");
			temp = temp.nextNode;
		}
	
	}
}