package com.bgu.workground.assignment2.MemoryManagement; /**
 * 
 * @author ADD YOUR NAME & ID
 */
import com.bgu.workground.assignment2.MemoryManagement.BTree.BTree;

import java.util.Arrays;


public class MemoryManagementSystem{
	public String[] secondaryMemory;
	private boolean useLRU;
	private BTree bTree;

	// YOU CAN ADD MORE FIELDS HERE
	 
	public MemoryManagementSystem(int mainMemorySize, int secondaryMemorySize, boolean useLRU) {
		// ADD YOUR CODE HERE
		this.useLRU = useLRU;
		this.secondaryMemory = new String[secondaryMemorySize];
		this.bTree = new BTree(mainMemorySize);
	}

	@Override
	public String toString() {
		return "secondaryMemory=" + Arrays.toString(secondaryMemory);
	}
	
	public String read(int index) {
		// ADD YOUR CODE HERE
		return bTree.read(index).toString();
	}

	public void write(int index, char c) {
		// ADD YOUR CODE HERE
		bTree.write(index,c);
	}
}
