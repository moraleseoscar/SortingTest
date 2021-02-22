import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*; 
import java.util.*; 

/**
 * @author Oscar Estrada
 *
 */
public class Sorts {
	
	/**
	 * Constructor
	 */
	public Sorts(){
		// TODO Auto-generated constructor stub
	}
	
	/** 
	 * Genera una vista para el array de entrada.
	 * @param listado
	 * @return String
	 */
	public String verListado(int[] listado) {
		String cadena = "";
		for(int i: listado) {
			cadena = cadena + " " + i;
		}
		return cadena;
	}
	
	
	/** 
	 * Algoritmo de sort Gnome
	 * Referencia: https://panthema.net/2013/sound-of-sorting/
	 * Algoritmo de notación O(n), siendo en un caso desfavorable hasta O(n2)
	 * @param numeros
	 * @return int[]
	 */
	public int[] gnomeSort(int[] numeros) {
		int i = 1;
		int temp;
		while (i < numeros.length) {
			if (numeros[i] >= numeros[i-1]) {
				i = i + 1;
			}else {
				temp = numeros[i];
				numeros[i] = numeros[i-1];
				numeros[i-1] = temp;
				if(i>1) {
					i = i-1;
				}
			}
		}
		return numeros;
	} 
	
	
	/** 
	 * Algoritmo de sort Merge.
	 * Algoritmo de notación O(n logn)
	 * Referencia: https://www.youtube.com/watch?v=yv6svAfoYik&t=444s
	 * @param numeros
	 * @return int[]
	 */
	public int[] mergeSort(int[] numeros) {
		if (numeros.length <= 1) {
			return numeros;
		}
		
		int midpoint = numeros.length / 2;
		
		int[] left = new int[midpoint];
		int[] right;
		
		if(numeros.length % 2 == 0) {
			right = new int[midpoint];
		}else {
			right = new int[midpoint + 1];
		}
		
		for(int i = 0; i < midpoint; i++) {
			left[i] = numeros[i];
		}
		
		for(int j = 0; j < right.length; j++) {
			right[j] = numeros[midpoint +j];
		}
		int[] result = new int[numeros.length];
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		result = merge(left, right);
		
		return result;
	}
	
	
	/**
	 * Merge parte del algoritmo MergeSort. En esta parse se une cada mitad. 
	 * Referencia: https://www.youtube.com/watch?v=yv6svAfoYik&t=444s
	 * @param left
	 * @param right
	 * @return int[]
	 */
	public int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		
		int leftPointer, rightPointer, resultPointer;
		leftPointer = rightPointer = resultPointer = 0;
		
		while (leftPointer < left.length || rightPointer < right.length) {
			if(leftPointer < left.length && rightPointer < right.length) {
				if(left[leftPointer] < right[rightPointer]) {
					result[resultPointer++] = left[leftPointer++];
				}else {
					result[resultPointer++] = right[rightPointer++];
				}
			}else if(leftPointer < left.length) {
				result[resultPointer++] = left[leftPointer++];
			}else if(rightPointer < right.length) {
				result[resultPointer++] = right[rightPointer++];
			}
		}
		
		return result;
	}
	
	
	/** 
	 * Llamada para quickSort y tener un valor de retorno.
	 * @param numeros
	 * @param izquierda
	 * @param derecha
	 * @return String
	 */
	public String quickSortMethod(int[] numeros, int izquierda, int derecha) {
		int[] mostrar = numeros;
		long nano_startTime = System.nanoTime(); 
    	quickSort(mostrar, izquierda, derecha);
    	long nano_endTime = System.nanoTime();
    	System.out.println("Tiempo en ordenar con datos desordenados: " + (nano_endTime - nano_startTime)); 
    	nano_startTime = System.nanoTime(); 
    	quickSort(mostrar, izquierda, derecha);
    	nano_endTime = System.nanoTime();
    	System.out.println("Tiempo en ordenar con datos ordenados: " + (nano_endTime - nano_startTime)); 
        return "\n" + verListado(mostrar);
	}
	
	
	/** 
	 * Algoritmo de sort Quick
	 * Referencia: https://www.youtube.com/watch?v=Fiot5yuwPAg&t=477s
	 * Quick sort puede llegar a ser O(n2) o hasta el peor de los casos O(n logn)
	 * @param numeros
	 * @param izquierda
	 * @param derecha
	 */
	public void quickSort(int[] numeros, int izquierda, int derecha) {
		int pivot = numeros[izquierda];
		int i = izquierda;
		int j = derecha;
		int temp;
		
		while(i<j) {
			while(numeros[i] <= pivot && i<j) {
				i++;
			}
			while(numeros[j] > pivot) {
				j--;
			}
			if(i < j) {
				temp = numeros[i];
				numeros[i] = numeros[j];
				numeros[j] = temp;
			}
		}
		
		numeros[izquierda] = numeros[j];
		numeros[j] = pivot;
		
		if(izquierda < j-1) {
			quickSort(numeros, izquierda, j-1);
		}
		if(j+1 < derecha) {
			quickSort(numeros, j+1, derecha);
		}
		
	}
	
	
	/** 
	 * Llamada al algoritmo para tener un valor de retorno.
	 * @param numeros
	 * @param n
	 * @return String
	 */
	public String radixMethod(int[] numeros, int n) {
		int[] mostrar = numeros;
		radixSort(mostrar, n);
		return verListado(mostrar);
	}
	
	/** 
	 * Algoritmo parte de RadixSort, encargado de encotrar el máximo para sus bordes.
	 * Referencia: //https://www.geeksforgeeks.org/radix-sort/
	 * @param arr[]
	 * @param n
	 * @return int
	 */
	public int getMax(int arr[], int n) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    } 
  
    
	/** 
	 * Algoritmo parte de RadixSort, 
	 * Referencia: //https://www.geeksforgeeks.org/radix-sort/
	 * @param arr[]
	 * @param n
	 * @param exp
	 */
	public void countSort(int arr[], int n, int exp) 
    { 
        int output[] = new int[n];
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count, 0); 
        for (i = 0; i < n; i++) 
            count[(arr[i] / exp) % 10]++; 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
        for (i = n - 1; i >= 0; i--) { 
            output[count[(arr[i] / exp) % 10] - 1] = arr[i]; 
            count[(arr[i] / exp) % 10]--; 
        } 
        for (i = 0; i < n; i++) 
            arr[i] = output[i]; 
    } 
  
    
	/** 
	 * Algoritmo para sort Radix
	 * Referencia: //https://www.geeksforgeeks.org/radix-sort/
	 * Tiene una notación de O(n) en el mejor comportamiento. Si no se aprovecha la estructura
	 * de claves, este tiene una estructura de O(n logn).
	 * @param arr[]
	 * @param n
	 */
	public void radixSort(int arr[], int n) 
    { 
        int m = getMax(arr, n); 
        for (int exp = 1; m / exp > 0; exp *= 10)  
            countSort(arr, n, exp); 
    } 
    
    
    
	/** 
	 * Algoritmo para sort Bubble
	 * Elegido. Referencia por: https://panthema.net/2013/sound-of-sorting/
	 * Tiene una notación O(n2)
	 * @param numeros
	 * @return int[]
	 */
	public int[] bubbleSort(int[] numeros) {
    	int i, j, temp = 0;
    	for(i = 0; i< numeros.length - 1; i++) {
    		for(j = 0; j<numeros.length - 1 -i; j++) {
    			if(numeros[j]> numeros[j+1]) {
    				temp = numeros[j];
    				numeros[j] = numeros[j+1];
    				numeros[j+1] = temp;
    			}
    		}
    	}
    	return numeros;
    }
	
	
	/** 
	 * Generamos el archivo según la cantidad que nos indiquen
	 * @param cantidad
	 */
	public void generarArchivo(int cantidad) {
		int numero;
		numero = (int) (Math.random() * 10000 + 1);
		String cadena = "" + numero;
		for (int i = 0; i <= (cantidad-1); i++) {
		    numero = (int) (Math.random() * 10000 + 1);
		    cadena = cadena + ", " + numero;
		}
		try {
			FileWriter fw = new FileWriter("numeros.txt"+ ""); 
			fw.write(cadena);
			fw.close();	
		}catch(Exception e) {
			System.out.println("Error en creacion de archivo");
		}
	}
	
	
	/** 
	 * Lee el archivo para cada vez que se vaya a ejecutar cada sort, sea el mismo
	 * @return int[]
	 */
	public int[] leerArchivo() {
		String texto = new String();
		try {
			FileReader fr = new FileReader("numeros.txt");
			BufferedReader entrada = new BufferedReader(fr); 
			String s;
			String[] temp = null;
			
			while((s = entrada.readLine()) != null) {
				temp = s.split(", ");
			}
			int[] numeros = new int[temp.length];
			for(int i = 0; i < temp.length; i++) {
				numeros[i] = Integer.parseInt(temp[i]);
			}
			return numeros;
		}
		catch(java.io.FileNotFoundException fnfex) {
			System.out.println("Archivo no encontrado: " + fnfex);return null;}
		catch(java.io.IOException ioex) {return null;}
	}
}
