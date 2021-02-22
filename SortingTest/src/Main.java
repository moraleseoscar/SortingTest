import java.util.Scanner;

/**
 * @author Oscar Estrada 20565
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sorts st = new Sorts();
		Scanner sc = new Scanner(System.in);
		st.generarArchivo(100);

		boolean menu = true;
		
        while(menu) {
        	System.out.println("");
        	System.out.println("+---------------------------------+");
            System.out.println("|           Sort Testing          |");
            System.out.println("+---------------------------------+");
            System.out.println("");
            System.out.println("1. Generar  nuevo archivo.");
            System.out.println("2. Gnome Sort.");
            System.out.println("3. Merge Sort.");
            System.out.println("4. Quick Sort.");
            System.out.println("5. Radix Sort.");
            System.out.println("6. Bubble Sort.");
            System.out.println("7. Ver archivo de numeros.");
            System.out.println("0. Salir.");
            System.out.println("");
            System.out.print("Seleccione el numero de la accion que desea realizar: ");
            int sel = sc.nextInt();
            sc.nextLine();
            while(sel < 0 || sel > 7) {
            	System.out.print("Seleccion fuera de rango. Intente de nuevo:");
                sel = sc.nextInt();
                sc.nextLine();
    		}
            System.out.println("");
            if(sel == 0) {
            	menu = false;
            }else if (sel == 1) {
            	int cantidad = getNumero("Indique de cuantos numeros hara su archivo (10 a 3000): ");
                while (cantidad <10 || cantidad > 3000) {
                	cantidad = getNumero("Parece que no selecciono un numero dentro del rango indicado, intente de nuevo: ");
                }
                st.generarArchivo(cantidad);
                System.out.println("Archivo generado correctamente...\n");
            }else if (sel == 2) {
            	int[] datos = st.leerArchivo();
            	long nano_startTime = System.nanoTime(); 
            	int[] test = st.gnomeSort(datos);
            	long nano_endTime = System.nanoTime();
            	System.out.println("Tiempo en ordenar con datos desordenados: " + (nano_endTime - nano_startTime)); 
            	nano_startTime = System.nanoTime(); 
            	test = st.gnomeSort(test);
            	nano_endTime = System.nanoTime();
            	System.out.println("Tiempo en ordenar con datos ordenados: " + (nano_endTime - nano_startTime)); 
                System.out.println("\n" + st.verListado(test));
            }
            else if (sel == 3) {
            	int[] datos = st.leerArchivo();
            	long nano_startTime = System.nanoTime(); 
            	int[] test = st.mergeSort(datos);
            	long nano_endTime = System.nanoTime();
            	System.out.println("Tiempo en ordenar con datos desordenados: " + (nano_endTime - nano_startTime)); 
            	nano_startTime = System.nanoTime(); 
            	test = st.mergeSort(test);
            	nano_endTime = System.nanoTime();
            	System.out.println("Tiempo en ordenar con datos ordenado: " + (nano_endTime - nano_startTime)); 
                System.out.println("\n" + st.verListado(test));
            }
            else if (sel == 4) {
            	st.quickSortMethod(st.leerArchivo(), 0, st.leerArchivo().length -1);
            }
            else if (sel == 5) {
            	int[] test = st.leerArchivo();
            	long nano_startTime = System.nanoTime(); 
            	st.radixMethod(test, test.length);
            	long nano_endTime = System.nanoTime();
            	System.out.println("Tiempo en ordenar con datos desordenados: " + (nano_endTime - nano_startTime)); 
            	nano_startTime = System.nanoTime(); 
            	st.radixMethod(test, test.length);
            	nano_endTime = System.nanoTime();
            	System.out.println("Tiempo en ordenar con datos ordenados: " + (nano_endTime - nano_startTime)); 
                System.out.println("\n" + st.verListado(test));
            	
            	
            	
            }
            else if (sel == 6) {
            	long nano_startTime = System.nanoTime(); 
            	int[] test = st.leerArchivo();
            	long nano_endTime = System.nanoTime();
            	System.out.println("Tiempo en ordenar con datos desordenados: " + (nano_endTime - nano_startTime)); 
            	nano_startTime = System.nanoTime(); 
            	test = st.bubbleSort(test);
            	nano_endTime = System.nanoTime();
            	System.out.println("Tiempo en ordenar con datos ordenados: " + (nano_endTime - nano_startTime)); 
                System.out.println("\n" + st.verListado(st.bubbleSort(test)));
            }
            else if (sel == 7) {
                System.out.println(st.verListado(st.leerArchivo()));
            }
        }
		
	}
	
	/** 
	 * Verifica que todo lo ingresado sea un numero.
	 * @param texto
	 * @return int
	 */
	private static int getNumero(String texto){
        Scanner teclado = new Scanner(System.in);
        String entrada="";
        
        int num = 0;
        boolean ok = true;
        
        do{
            System.out.print(texto);
            entrada = teclado.nextLine();
            
            try{
                num = Integer.parseInt(entrada);
                ok = true;
            }
            catch(Exception e){
                System.out.println(entrada + " no es un numero. Intente de nuevo.");
                ok = false;
            }
        }while (!ok); 
        
        return num;
    }

}
