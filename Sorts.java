import java.util.Comparator;

import java.util.Vector;

public class Sorts<T> {
    
    /**
     * Implementación de QuickSort
     * Impelmentación obtenida de Baeldung.com 
     */
    public void quickSort(Integer[] myArray, int begin, int end){
        if (begin < end){
            int partitionIndex = partition(myArray, begin, end);

            quickSort(myArray, begin, partitionIndex-1);
            quickSort(myArray, partitionIndex+1, end);
        }
    }

    public int partition(Integer[] myArray, int begin, int end){
        int pivot = myArray[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++){
            if (myArray[j] <= pivot){
                i++;

                int swapTemp = myArray[i];
                myArray[i] = myArray[j];
                myArray[j] = swapTemp;
            }
        }

        int swapTemp = myArray[i+1];
        myArray[i+1] = myArray[end];
        myArray[end] = swapTemp;

        return i + 1;
    }

    /**
     * Implementación de GnomeSort
     * Implementación obtenida de OpenGenus IQ
     * @param myArray
     */
    public void gnomeSort(Integer[] myArray){
        int i = 1;
        int n = myArray.length;

        while (i < n){
            if (i == 0 || myArray[i - 1] <= myArray[i]){
                i++;
            } else {
                int tmp = myArray[i];
                myArray[i] = myArray[i - 1];
                myArray[--i] = tmp;
            }
        }
    }

    /**
     * Implementación de MergeSort
     * Implementación obtenida de geeksforgeeks.org
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
    // public void merge(Integer[] myArray, Integer[] l, Integer[] r, int left, int right){
    //     int i = 0, j = 0, k = 0;
    //     while (i < left && j < right){
    //         if (l[i] <= r[j]) {
    //             myArray[k++] = l[i++];
    //         } else {
    //             myArray[k++] = l[i++];
    //         }
    //     }

    //     while (i < left) {
    //         myArray[k++] = l[i++];
    //     }
    //     while (j < right) {
    //         myArray[k++] = r[j++];
    //     }
    // }

    // public void mergeSort(Integer[] myArray, int n){
    //     if (n < 2){
    //         return;
    //     }
    //     int mid = n / 2;
    //     Integer[] l = new Integer[mid];
    //     Integer[] r = new Integer[n - mid];

    //     for (int i = 0; i < mid; i++){
    //         l[i] = myArray[i];
    //     }
    //     for (int i = mid; i < n; i++){
    //         r[i - mid] = myArray[i];
    //     }
    //     mergeSort(l, mid);
    //     mergeSort(r, n - mid);

    //     merge(myArray, l, r, mid, n - mid);
    // }

    /**
     * Implementación de RadixSort
     * Implementación obtenida de Programiz.com
     */
    public void countingSort(Integer[] myArray, int size, int place){
        int array;
        int i;
        int[] output = new int[size + 1];
        int max = myArray[0];
        for (i = 1; i < size; i++) {
            if (myArray[i] > max)
                max = myArray[i];
        }

        int[] count = new int[max + 1];

        for (i = 0; i < max; i++)
            count[i] = 0;

        for (i = 0; i < size; i++)
            count[(myArray[i]/place) % 10]++;
        
        for (i = size - 1; i >= 0; i--) {
            output[count[(myArray[i] / place) % 10] - 1] = myArray[i];
            count[(myArray[i]/ place) % 10]--;
        }

        for (i= 0; i < size; i++)
            array = myArray[i];
            array = output[i];
    }

    public int getMax(Integer[] myArray, int n) {
        int max = myArray[0];
        for (int i = 1; i < n; i++)
            if (myArray[i] > max)
                max = myArray[i];
            return max;
    }

    public void radixSort(Integer[] myArray, int size){
        int max = getMax(myArray, size);

        for (int place = 1; max / place > 0; place *= 10)
            countingSort(myArray, size, place);
    }
    

    /**
     * Implementación de SelectionSort
     * Implementación obtenida de edureka.co
     * 
     */
    public void selectionSort(Integer[] myArray){
        int n = myArray.length;
        for (int i = 0; i < n-1; i++){
            int min_element = i;
            for (int j = i+1; j< n; j++){
                if (myArray[j] < myArray[min_element])
                    min_element = j;
                
                int array = myArray[min_element]; 
                int Iarray = myArray[i];  
                int temp = array;
                array = Iarray;
                Iarray = temp;
            }

        }
    }
}

