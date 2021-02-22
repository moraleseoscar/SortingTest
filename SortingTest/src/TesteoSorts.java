import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import junit.framework.TestCase;


public class TesteoSorts extends TestCase{
	private Sorts sorts;
	private int[] prueba = {5,2,3,1,4};
	private int[] ordenado = {1,2,3,4,5};
	
	public void escenario() {
		sorts = new Sorts();
	}
	
	/** 
	 * Testeo de GnomeSort
	 */
	@Test
	public void testgnomeSort() {
		escenario();
		assertEquals(sorts.gnomeSort(prueba), ordenado);
	}
	
	/** 
	 * Testeo de MergeSort
	 */
	@Test
	public void testmergeSort() {
		escenario();
		assertArrayEquals(sorts.mergeSort(prueba), ordenado);
	}
	
	/** 
	 * Testeo de QuickSort
	 */
	@Test
	public void testquickSortMethodSort() {
		escenario();
		assertEquals(sorts.quickSortMethod(prueba, 0, 4), " 1 2 3 4 5");
	}
	
	/** 
	 * Testeo de RadixSort
	 */
	@Test
	public void testradixMethodSort() {
		escenario();
		assertEquals(sorts.radixMethod(prueba, 5), " 1 2 3 4 5");
	}
	
	/** 
	 * Testeo de BubbleSort
	 */
	@Test
	public void testbubbleSort() {
		escenario();
		assertArrayEquals(sorts.bubbleSort(prueba), ordenado);
	}
	
	
}
