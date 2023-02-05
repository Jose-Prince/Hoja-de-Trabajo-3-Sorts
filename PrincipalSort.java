import java.util.Scanner;

public class PrincipalSort<T> {

    public static void main(String[] args) {
        System.out.println("¿Cuántos valores desea generar?");
        Scanner teclado = new Scanner(System.in);
        int qty = Integer.parseInt( teclado.nextLine());

        int valores[] = new int[qty];
        int datos[] = new int[qty];
        Sorts<Integer> lista = new Sorts<Integer>();

        for (int i = 0; i < qty; i++){
            valores[i] = (int) (Math.floor(Math.random()*(1000)));
            datos[i] = valores[i];
        }

        //Gnome Sort
        System.out.println("\nOrdenado los datos del arreglo con GnomeSort...");
        lista.gnomeSort(datos);
        System.out.println("Los datos han sido arreglados");
        for (int i = 0; i < datos.length; i++){
            System.out.println(datos[i]);
        }

        System.out.println("Presione enter para usar el siguiente sort");
        String next = teclado.nextLine();

        //Merge Sort
        System.out.println("\nOrdenado los datos del arreglo con MergeSort...");
        Sorts.mergeSort(datos, datos.length);
        System.out.println("Los datos han sido arreglados");
        for (int i = 0; i < datos.length; i++){
            System.out.println(datos[i]);
        }

        System.out.println("Presione enter para usar el siguiente sort");
        next = teclado.nextLine();

        //Quick Sort
        System.out.println("\nOrdenado los datos del arreglo con QuickSort...");
        lista.quickSort(datos, 0, datos.length-1);
        System.out.println("Los datos han sido arreglados");
        for (int i = 0; i < datos.length; i++){
            System.out.println(datos[i]);
        }

        System.out.println("Presione enter para usar el siguiente sort");
        next = teclado.nextLine();

        //Radix Sort
        System.out.println("\nOrdenado los datos del arreglo con RadixSort...");
        Sorts.radixSort(datos);
        System.out.println("Los datos han sido arreglados");
        for (int i = 0; i < datos.length; i++){
            System.out.println(datos[i]);
        }

        System.out.println("Presione enter para usar el siguiente sort");
        next = teclado.nextLine();

        //Selection Sort
        System.out.println("\nOrdenado los datos del arreglo con SelectionSort...");
        Sorts.selectionSort(datos);
        System.out.println("Los datos han sido arreglados");
        for (int i = 0; i < datos.length; i++){
            System.out.println(datos[i]);
        }
        
    }
}
