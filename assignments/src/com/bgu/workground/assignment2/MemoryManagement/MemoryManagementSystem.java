package com.bgu.workground.assignment2.MemoryManagement; /**
 * 
 * @author ADD YOUR NAME & ID
 */

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.HashMap;


public class MemoryManagementSystem{
	public String[] secondaryMemory;
	private boolean useLRU;
	// YOU CAN ADD MORE FIELDS HERE
	SuperQueue mainMemory;

	 
	public MemoryManagementSystem(int mainMemorySize, int secondaryMemorySize, boolean useLRU) {
		// ADD YOUR CODE HERE
		this.useLRU = useLRU;
		this.secondaryMemory = new String[secondaryMemorySize];
		for (int i = 0; i < secondaryMemorySize; i++) {
			secondaryMemory[i]="";
		}
		this.mainMemory = new SuperQueue(mainMemorySize,secondaryMemory,useLRU);

	}

	@Override
	public String toString() {
		return "secondaryMemory=" + Arrays.toString(secondaryMemory);
	}
	
	public String read(int index) {
		// ADD YOUR CODE HERE
		updateMemory(index,"");
		return mainMemory.getPointers()[index].pointTo.element.value;
	}

	public void write(int index, char c) {
		// ADD YOUR CODE HERE
		updateMemory(index,""+c);
	}

	private void updateMemory(int index, String s){
		//check if item is exist in the list
		if (mainMemory.getPointers()[index] == null){
			//add a new item to the list
			Page p = new Page(index,secondaryMemory[index]+s);
			Node <Page>myNode = new Node<Page>(mainMemory.getLast(), null, p);
			//if the there no place, remove the first item
			if (mainMemory.isFull()) {
				Node<Page> tmpNode = mainMemory.removeFirst();
				secondaryMemory[tmpNode.element.key] = tmpNode.element.value;
			}
			mainMemory.append(myNode);
		}else{
			//write new data and update his position
			if (!s.equals(""))
				mainMemory.getPointers()[index].pointTo.element.addData(s);
			if (useLRU)
				mainMemory.lruUpdate(mainMemory.getPointers()[index].pointTo);

		}
	}


}
