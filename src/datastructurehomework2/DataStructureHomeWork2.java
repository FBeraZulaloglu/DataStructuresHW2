/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructurehomework2;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;

/**
 * @file DataStructureHomeWork2
 * @description Bu program bir klasör içindeki dosyaların içinde gelen kelimeleri sıklıklarına göre max heap yapısında listeler.
 * @assignment Ödev 2
 * @date 26.05.2020
 * @author Faruk Bera Zulaloglu farukbera.zulaloglu@stu.fsm.edu.tr
 */
public class DataStructureHomeWork2 {
	
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		// read the files
		JFileChooser fc = new JFileChooser();
		JButton choose = new JButton("Choose The Directory");
		fc.setCurrentDirectory(new java.io.File("C:/Users/faruk/Desktop"));
		fc.setDialogTitle("DATA STRUCTURES");
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fc.showOpenDialog(choose) == JFileChooser.APPROVE_OPTION) {

			File f = fc.getSelectedFile();
			
			// loop the files in a spesific dir
			for (File file : f.listFiles()) {
				int count = 0;
				String word = "";
				
				try (FileReader fr = new FileReader(file)) {

					while ((count = fr.read()) != -1) {

						if (isCharacter((char) count)) {
							word += makeLowerCase((char) count);

						}

						if ((char) count == ' ' || (char) count == '\n') {
							
							if (word != "") {
							System.out.println("WORD :" + word);
								if (!bst.isExist(word)) {
									bst.insert(word);
									System.out.println(file.getName());
									try{
										bst.getNode(word).fileList.addFile(file.getName());
										bst.getNode(word).fileList.getFile(file.getName()).frequency = 1;
									}
									catch(Exception e){
										//System.out.println(e);
										//System.out.println("FILE EKLENEMEDİ");
									}
									
									//bst.addFile(bst.getNode(word), file.getName());
									//bst.getNode(word).fileList.getFile(file.getName()).frequency = 1;
								}
								else{
									//System.out.println("EXİSTS");
									if(!bst.getNode(word).fileList.isExist(file.getName())){
										bst.addFile(bst.getNode(word), file.getName());
										bst.getNode(word).fileList.getFile(file.getName()).frequency = 1;
									}
									else{
										bst.getNode(word).fileList.getFile(file.getName()).frequency++;
									}
									
								}

								word = "";
							}
						}
						
					}
					System.out.println("");
				} catch (Exception e) {
					System.out.println("WORD = "+word+" FILE "+file.getName());
					System.out.println(e);
				}

			}

		}
		MaxHeap mH = new MaxHeap(bst.size);
		
		//bst.printPreOrder();
		//System.out.println("ROOT OF THE BST : "+bst.root.data);
		bst.buildMaxHeap(mH);
		//mH.heapify();
		mH.print();
		maxHeapSort(bst, mH);
		
		
	}

	// if it is number or punctuation dont take it
	static boolean isCharacter(char c) {

		return Character.isAlphabetic(c);
	}

	static char makeLowerCase(char c) {
		if (Character.isUpperCase(c)) {
			c += 32;
		}

		return c;
	}
	
	// mainde yap 
	static void maxHeapSort(BinarySearchTree bst,MaxHeap mx){
		SortingList sortingList = new SortingList();
		while(mx.size >= 1){
			//System.out.println(mx.size+" MX SİZE HAS");
			sortingList.insert(mx.heap[0]);
			if(mx.size != 1){	
				mx.swap(0,mx.size-1);
			}
				mx.size--;
				mx.heapify();
				
		}
		System.out.println("------- SORTED LIST-----------");
		sortingList.print();
	}
	
	
	
	

}
