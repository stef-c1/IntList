package IntLiist;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	@org.junit.jupiter.api.Test
	void test() {

		IntList List1 = IntList.getList();
		List1.appendList(5);
		assertEquals(1,List1.getLenList());
		List1.appendList(-6);
		List1.appendList(99);
		assertEquals(3,List1.getLenList());
		List1.removeLastList(); 
		assertEquals(2,List1.getLenList());
		assertEquals(5,List1.getElementByIndex(0));
		assertEquals(-6,List1.getElementByIndex(1));
		int[] array1 = {5,-6};
		int[] answerArray = List1.getArrayOfList();
		for (int i=0;i<answerArray.length;i++) {
			assertEquals(array1[i], answerArray[i]);
		/*
		 * kan ook via assertArrayEquals(...)
		 */
		}
	}

}
