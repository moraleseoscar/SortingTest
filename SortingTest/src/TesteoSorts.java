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
	
	@Test
	public void testgnomeSort() {
		escenario();
		assertEquals(sorts.gnomeSort(prueba), " 1 2 3 4 5");
	}
	
	@Test
	public void testmergeSort() {
		escenario();
		assertArrayEquals(sorts.mergeSort(prueba), ordenado);
	}
	
	@Test
	public void testquickSortMethodSort() {
		escenario();
		assertEquals(sorts.quickSortMethod(prueba, 0, 4), " 1 2 3 4 5");
	}
	
	@Test
	public void testradixMethodSort() {
		escenario();
		assertEquals(sorts.radixMethod(prueba, 5), " 1 2 3 4 5");
	}
	
	@Test
	public void testbubbleSort() {
		escenario();
		assertArrayEquals(sorts.bubbleSort(prueba), ordenado);
	}
	
	
}
