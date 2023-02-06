import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sorts<T> {
    
    /**
     * Implementación de QuickSort
     * Impelmentación obtenida de Baeldung.com 
     */
    public void quickSort(int[] datos, int begin, int end){
        if (begin < end){
            int partitionIndex = partition(datos, begin, end);

            quickSort(datos, begin, partitionIndex-1);
            quickSort(datos, partitionIndex+1, end);
        }
    }

    public int partition(int[] datos, int begin, int end){
        int pivot = datos[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++){
            if (datos[j] <= pivot){
                i++;

                int swapTemp = datos[i];
                datos[i] = datos[j];
                datos[j] = swapTemp;
            }
        }

        int swapTemp = datos[i+1];
        datos[i+1] = datos[end];
        datos[end] = swapTemp;

        return i + 1;
    }

    /**
     * Implementación de GnomeSort
     * Implementación obtenida de OpenGenus IQ
     * @param datos
     */
    public void gnomeSort(int[] datos){
        int i = 1;
        int n = datos.length;

        while (i < n){
            if (i == 0 || datos[i - 1] <= datos[i]){
                i++;
            } else {
                int tmp = datos[i];
                datos[i] = datos[i - 1];
                datos[--i] = tmp;
            }
        }
    }

    /**
     * Implementación de MergeSort
     * Implementación obtenida de educative.io
     */
    public static void merge(int[] left_arr,int[] right_arr, int[] arr,int left_size, int right_size) {
        int i=0,l=0,r=0;

        while(l<left_size && r<right_size){
            if(left_arr[l]<right_arr[r]){
                arr[i++]=left_arr[l++];
            } else {
                arr[i++]= right_arr[r++];
            }
        }
        while(l<left_size){
            arr[i++] = left_arr[l++];
        }
        while(r<right_size){
            arr[i++] = right_arr[r++];
        }
    }

    public static void mergeSort(int[] arr, int len){
        if (len < 2){return;}

        int mid = len / 2;
        int[] left_arr = new int[mid];
        int[] right_arr = new int[len-mid];

        int k = 0;
        for(int i = 0;i<len;++i){
            if(i<mid){
                left_arr[i] = arr[i];
            } else {
                right_arr[k] = arr[i];
                k = k + 1;
            }
        }

        mergeSort(left_arr, mid);
        mergeSort(right_arr, len-mid);

        merge(left_arr,right_arr,arr,mid,len-mid);
    }

    /**
     * Implementación de RadixSort
     *Implementación obtenida de java67.com
     */
    public static void radixSort(int[] input) {
        final int RADIX = 10;

        List<Integer>[] bucket = new ArrayList[RADIX];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;

            for (Integer i : input) {
                tmp = i / placement;
                bucket[tmp % RADIX].add(i);
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }

            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : bucket[b]) {
                    input[a++] = i;
                }
                bucket[b].clear();
            }

            placement *= RADIX;
        }
    }


    /**
     * Implementación de SelectionSort
     * Implementación obtenida de edureka.co
     * 
     */
    public static void selectionSort(final int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minElementIndex] > arr[j]) {
                    minElementIndex = j;
                }
            }
            if (minElementIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minElementIndex];
                arr[minElementIndex] = temp;
            }
        }
    }


    public static void main(String[] args) {
        boolean funcionar = true;
        while (funcionar) {
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
    
            for (int i = 0; i < datos.length; i++){
                System.out.println(datos[i]);
            }
    
            System.out.println("\nElija el sort que desea utilizar:\n\n1: Gnome Sort\n2: Merge Sort\n3: Quick Sort\n4: Radix Sort\n5: Selection Sort\n6: Salir del programa");
            int eleccion = teclado.nextInt();
            teclado.nextLine();

            switch (eleccion) {
                case 1:
                    //Gnome Sort
                    System.out.println("\nOrdenado los datos del arreglo con GnomeSort...");
                    lista.gnomeSort(datos);
                    System.out.println("Los datos han sido arreglados");
                    for (int i = 0; i < datos.length; i++){
                        System.out.println(datos[i]);
                    }
                        
                    break;
                case 2:
                    //Merge Sort
                    System.out.println("\nOrdenado los datos del arreglo con MergeSort...");
                    Sorts.mergeSort(datos, datos.length);
                    System.out.println("Los datos han sido arreglados");
                    for (int i = 0; i < datos.length; i++){
                        System.out.println(datos[i]);
                    }
                    break;
                case 3:
                        //Quick Sort
                        System.out.println("\nOrdenado los datos del arreglo con QuickSort...");
                        lista.quickSort(datos, 0, datos.length-1);
                        System.out.println("Los datos han sido arreglados");
                        for (int i = 0; i < datos.length; i++){
                            System.out.println(datos[i]);
                        }
                    break;
                case 4:
                    //Radix Sort
                    System.out.println("\nOrdenado los datos del arreglo con RadixSort...");
                    Sorts.radixSort(datos);
                    System.out.println("Los datos han sido arreglados");
                    for (int i = 0; i < datos.length; i++){
                        System.out.println(datos[i]);
                    }
                    break;
                    case 5:
                        //Selection Sort
                        System.out.println("\nOrdenado los datos del arreglo con SelectionSort...");
                        Sorts.selectionSort(datos);
                        System.out.println("Los datos han sido arreglados");
                        for (int i = 0; i < datos.length; i++){
                            System.out.println(datos[i]);
                        }
                    break;
                case 6:
                    funcionar = false;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    break;
            }
            
        }
    }   
}

