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
	 * 
	 */
	public Sorts(){
		// TODO Auto-generated constructor stub
	}
	
	
	public String verListado(int[] listado) {
		String cadena = "";
		for(int i: listado) {
			cadena = cadena + " " + i;
		}
		return cadena;
	}
	
	public String gnomeSort(int[] numeros) {
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
		return verListado(numeros);
	} 
	
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
	
	public String quickSortMethod(int[] numeros, int izquierda, int derecha) {
		int[] mostrar = numeros;
		quickSort(mostrar, izquierda, derecha);
		return verListado(mostrar);
	}
	
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
	
	public String radixMethod(int[] numeros, int n) {
		int[] mostrar = numeros;
		radixSort(mostrar, n);
		return verListado(mostrar);
	}
	
	
	
    public int getMax(int arr[], int n) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    } 
  
    public void countSort(int arr[], int n, int exp) 
    { 
        int output[] = new int[n]; // output array 
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
  
    public void radixSort(int arr[], int n) 
    { 
        int m = getMax(arr, n); 
        for (int exp = 1; m / exp > 0; exp *= 10)  //https://www.geeksforgeeks.org/radix-sort/
            countSort(arr, n, exp); 
    } 
    
    
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
	
	public void generarArchivo(int cantidad) {
		int numero;
		numero = (int) (Math.random() * 3000 + 1);
		String cadena = "" + numero;
		for (int i = 0; i <= (cantidad-1); i++) {
		    numero = (int) (Math.random() * 3000 + 1);
		    cadena = cadena + ", " + numero;
		}
		try {
			FileWriter fw = new FileWriter("numeros.txt"
					+ ""); 
			fw.write(cadena);
			fw.close();	
		}catch(Exception e) {
			System.out.println("Error en creacion de archivo");
		}
	}
	
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
