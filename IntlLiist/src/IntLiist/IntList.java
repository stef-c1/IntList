package IntLiist;

import java.util.Arrays;


/**
 * @invar | getArrayOfList() != null
 * @author stefc
 *
 */
public class IntList {
	/**
	 * The class IntList represents a mutable array object named List with integer elements.
	 */
	
	private int[] storeArray;
	
	/**
	 * Make a new object of type IntList, without any elements in it (yet).
	 * @post | getLenList() == 0 
	 */
	private IntList() {
		int[] emptyArray = {};
		this.storeArray = emptyArray;
		/*
		 * of liever storeArray = new int[0];
		 */
	}
	
	public static IntList getList() {
		return new IntList();
	}
	
	/*public static IntList getList() {
	IntList lst =  new IntList();
	int[] emptyArray = {};
	lst.storeArray = emptyArray;
	return lst;
	}*/
	
	/**
	 * Get the length of the List structure.
	 * @basic
	 */
	public int getLenList() {
		return storeArray.length;
	}
	
	/**
	 * Geeft het element in de lijst op de gegeven index.
	 * @throws IllegalArgumentException als de index kleiner is dan 0 of groter of gelijk aan de lengte van de lijst.
	 * 		| (index < 0 || index >= this.getLenList())
	 * @post | result == getArrayOfList()[index]
	 * 
	 */
	public int getElementByIndex(int index) {
		if (index<0||index>=this.getLenList()) {
			throw new IllegalArgumentException("Ongeldige index.");
		}
		return storeArray[index];
	}
	
	/**
	 * Get a copied array with all the elements of the list object.
	 * @creates | result
	 */
	/*
	 * Representation exposure, de klant kan aan het private field storeArray (aan de interne representatie) als het zonder de .clone was!!!
	 * creates zorgt dat het een nieuw element is als output, deze heeft dan niets te maken met de interne representatie.
	 */
	public int[] getArrayOfList() {
		return storeArray.clone();
	}
	
	/**
	 * Voegt een element toe aan de List.
	 * @post De lengte van de lijst is vermeerdert met 1.
	 * 		 | this.getLenList() == old(this.getLenList())+1
	 * @post | getElementByIndex(old(getLenList())) == element
	 * @post | Arrays.equals(getArrayOfList(), 0, getLenList()-1, old(getArrayOfList()),0 , old(getLenList()))
	 */
	/*@post | IntStream.range(0, old(getLenList())).allMatch(i ->
	 * 		|		elementByIndex(i) == old(getArrayOfList())[i])
	 *laatste post om te checken of alle andere elementen dezelfde zijn gebleven, IntStream.range(a, b).allMatch(i -> uitspraak over i
	 *inclusief a en exclusief b checken of geldt voor elke i (i mag niet onder de old gebruikt worden!) of via Arrays.equals*/
	public void appendList(int element) {
		
		int[] result = new int[storeArray.length+1];
		for (int i=0; i<storeArray.length; i++) {
			result[i]=storeArray[i];
		}
		result[storeArray.length] = element;
		storeArray = result;
	}
	
	/**
	 * Verwijdert een element uit de List.
	 * @post De lengte van de lijst is vermindert met 1.
	 * 		| this.getLenList() == old(this.getLenList())-1
	 * @post | Arrays.equals(getArrayOfList(), 0, getLenList(), old(getArrayOfList()),0 , old(getLenList())-1)
	 */
	public void removeLastList() {
		int[] result = new int[storeArray.length-1];
		for (int i=0;i<storeArray.length-1;i++) {
			result[i]=storeArray[i];
		}
		storeArray = result;
	}
	
}


