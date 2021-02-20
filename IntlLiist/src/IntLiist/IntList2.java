package IntLiist;

public class IntList2 {

	public class Node {
		  public int value;
		  public Node next;
		}
	
	private Node firstNode;
	
	/**
	 * Make a new object of type IntList, without any elements in it (yet).
	 * @basic
	 */
	private IntList2() {
		this.firstNode = null;
	}
	
	public static IntList2 getList() {
		return new IntList2();
	}
	
	/**
	 * Get the length of the List structure.
	 * @basic
	 */
	public int getLenList() {
		Node nodeNext = firstNode;
		int counter = 0;
		while (nodeNext!=null) {
			counter+=1;
			nodeNext=nodeNext.next;
		}
		return counter;
	}
	
	/**
	 * Geeft het element in de lijst op de gegeven index.
	 * @throws IllegalArgumentException als de index kleiner is dan 0 of groter of gelijk aan de lengte van de lijst.
	 * 		| (index < 0 || index >= this.getLenList())
	 */
	public int getElementByIndex(int index) {
		if (index < 0 || index >= this.getLenList()) {
			throw new IllegalArgumentException("Ongeldige index.");
		}
		int indexCounter = 0;
		Node nodeNext = firstNode;
		for (;;) {
			if (indexCounter==index) {
				return nodeNext.value;
			}
			indexCounter+=1;
			nodeNext=nodeNext.next;
		}
	}
	
	/**
	 * Get an array with all the elements of the list object.
	 * @basic
	 */
	public int[] getArrayOfList() {
		int[] array = new int[this.getLenList()];
		Node nodeNext = firstNode;
		int index = 0;
		while (nodeNext!=null) {
			array[index] = nodeNext.value;
			index+=1;
			nodeNext=nodeNext.next;
		}
		return array;
	}
	
	/**
	 * Voegt een element toe aan de List.
	 * @post De lengte van de lijst is vermeerdert met 1.
	 * 		| this.getLenList() == old(this.getLenList())+1
	 */
	public void appendList(int element) {
		
		Node nodeNext = firstNode;
		if (firstNode==null) {
			Node newNode = new Node();
			newNode.value = element;
			newNode.next = null;
			firstNode = newNode;
			return;
		}
		for (;;) {
			if (nodeNext.next==null) {
				Node newNode = new Node();
				newNode.value = element;
				newNode.next = null;
				nodeNext.next = newNode;
				return;
			}
			nodeNext=nodeNext.next;
		}
	}
	
	/*public void removeLastList() {
		Node nodeNext = firstNode;
		if (firstNode==null) {
			return;
		}
		for (;;) {
			if (nodeNext.next==null) {
				nodeNext = null;
				return;
			}
			nodeNext=nodeNext.next;
		}
	}*/
	
	/**
	 * Verwijdert een element uit de List.
	 * @post De lengte van de lijst is vermindert met 1.
	 * 		| this.getLenList() == old(this.getLenList())-1
	 */
	public void removeLastList() {
		if (firstNode == null) {
			return;
		}
		Node nodeNow = firstNode;
		Node nodeNext = nodeNow.next;
		if (nodeNext==null) {
			firstNode=null;
			return;
		}
		Node nodeNextNext = nodeNext.next;
		for (;;) {
			if (nodeNextNext==null) {
				nodeNow.next = null;
				return;
			}
			nodeNow=nodeNow.next;
			nodeNext=nodeNext.next;
			nodeNextNext=nodeNextNext.next;
		}
		
		
		
		
		
	}
}
