/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructurehomework2;

/**
 * @file DataStructureHomeWork2
 * @description Bu program bir klasör içindeki dosyaların içinde gelen kelimeleri sıklıklarına göre max heap yapısında listeler.
 * @assignment Ödev 2
 * @date 26.05.2020
 * @author Faruk Bera Zulaloglu farukbera.zulaloglu@stu.fsm.edu.tr
 */
public class MaxHeap  {
	BNode[] heap;
	int size;
	
	
	public MaxHeap(int capacity){
		heap = new BNode[capacity];
	}
	
	private int parentIndex(int i){
		return (i-1)/2;
	}
	
	void insert(BNode newData){
		if(size < heap.length){
			heap[size] = newData;
			
			int current = size;
			
			if(parentIndex(size) >= 0){
			while(heap[current].getFrequency() > (heap[parentIndex(current)].getFrequency())){
				swap(current,parentIndex(current));
				current = parentIndex(current);
				
				}
			}
			size++;
			
		}
		else{
			System.out.println("Heap is full. Sorry mate :)");
		}
	}
	
	
	
	void print(){
		for (int i = 0; i < size; i++) {
			System.out.print(heap[i].data +" = "+heap[i].getFrequency()+" --> ");
		}
	}
	
	void swap(int index,int index1){
		BNode temp = heap[index1];
		heap[index1] = heap[index];
		heap[index] = temp;
		//System.out.println(heap[index].getFrequency()+" has level upped.");
	}
	
	void heapify(){
		int lastİndex = size -1;
		
		for (int i = parentIndex(lastİndex); i >= 0; i--) {
			maxHeap(i);
		}
	}
	
	void maxHeap(int i){
		int leftIndex = (i*2)+1;
		int rightIndex = (i*2)+2;
		int max = i;
		if(leftIndex < size && heap[max].getFrequency() < heap[leftIndex].getFrequency()){
				max = leftIndex;
		}
		else if(rightIndex < size && heap[max].getFrequency() < heap[rightIndex].getFrequency()){
				max = rightIndex;
		}
		if(max != i){
			swap(i,max);
			maxHeap(parentIndex(max));// it was just max at first
		}
	}
	
	private void maxHeapMove(int i){
		int leftIndex = (i*2)+1;
		int rightIndex = (i*2)+2;
		int max = i;
		if(leftIndex<size && heap[max].getFrequency() < heap[leftIndex].getFrequency()){
				max = leftIndex;
		}
		else if(rightIndex<size && heap[max].getFrequency() < heap[rightIndex].getFrequency()){
				max = rightIndex;
		}
		
		if(max != i){
			move(i,max);
			maxHeapMove(max);
		}
	}
	
	private void move(int i, int max){
		heap[i] = heap[max];
		max = i;
	}
	
	// not working control after wakeup 
	void deleteMax(){
		//BNode deleted = heap[0];
		maxHeapMove(0);
		size--;
	}
	
	void remove(int index){
		heap[index] = heap[size-1];
		size--;
	}
	
	
	
	
	
	
}
