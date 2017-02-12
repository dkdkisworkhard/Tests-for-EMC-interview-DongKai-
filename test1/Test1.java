package com.dk.test1;

import java.awt.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Test1 {
	
	/*
	 * The method that reverse every k nodes of a linked list.
	 */
	public LinkedList<String> getNewList(LinkedList<String> inputList, int node) {
		int indexNode = 0;
		int listLength = inputList.size();
		while (listLength - indexNode >= node) {
			for (int i = indexNode; i <= indexNode+node/2; i++) {
				String temp = inputList.get(i);
				inputList.set(i, inputList.get(indexNode + node - (i - indexNode) - 1)); 
				inputList.set(indexNode + node - (i - indexNode) - 1, temp);
			}
			indexNode += node;
		}
		return inputList;
	}

	public static void main(String[] args) {
		
		LinkedList<String> originalList = new LinkedList<String>();
		int nodeNum = 0;
		
		/***************method1: get linkedlist and node from arguments of main.***************** 
		 *   
		 *   the last element of args is node,and the others are the element of listedlist. 
		 * 
		//get LinkedList from args.
		for (int i = 0; i < args.length - 1; i++) {
			originalList.add(args[i]);
		}
		
		//get node from args
		try {
			nodeNum = Integer.parseInt(args[args.length - 1]);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		*****************************************************************************************/
		
		/********************method2: get linkedlist and node from keyboard.*********************/ 
		//get LinkedList from keyboard.
		Scanner scanner = new Scanner(System.in);
		System.out.println("The program is running now!!!");
		System.out.println();
		System.out.println("Please input a line of data, and separate them by a space:");
		String inputString = scanner.nextLine();
		String[] inputList = inputString.split(" ");
		for (String string11 : inputList) {
			System.out.print(string11 + " ");
		}
		
		for (int i = 0; i < inputList.length; i++) {
			originalList.add(inputList[i]);
		}
		System.out.println("OK, got the data list.");
		System.out.println();
		
		//get node from keyboard.
		System.out.println("Please input a num:");
		String node = scanner.nextLine();
		nodeNum = Integer.parseInt(node);
		/*****************************************************************************************/

		Test1 test1 = new Test1();
		LinkedList<String> newList = test1.getNewList(originalList, nodeNum);
		Iterator<String> iterator = newList.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

	}

}
