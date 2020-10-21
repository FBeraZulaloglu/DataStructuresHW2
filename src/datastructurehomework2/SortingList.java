
package datastructurehomework2;
/**
 * @file DataStructureHomeWork2
 * @description Bu program bir klasör içindeki dosyaların içinde gelen kelimeleri sıklıklarına göre max heap yapısında listeler.
 * @assignment Ödev 2
 * @date 26.05.2020
 * @author Faruk Bera Zulaloglu farukbera.zulaloglu@stu.fsm.edu.tr
 */
public class SortingList {

	BNode head;

	void insert(BNode newNode) {
		if (isEmpty()) {
			head = newNode;
		} else {
			BNode temp = head;

			while (temp.nextNode != null) {
				temp = temp.nextNode;
			}

			temp.nextNode = newNode;
		}
	}

	private boolean isEmpty() {
		return head == null;
	}

	void print() {
		BNode temp = head;
		while (temp != null) {
			System.out.println(temp.data + "(" + temp.getFrequency() + ")");
			temp = temp.nextNode;
		}

	}
}
