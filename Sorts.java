import java.util.ArrayList;
import java.util.List;

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
}

