import java.util.Comparator;

import java.util.Vector;

public class Sorts<T> {
    
    /**
     * Implementación de QuickSort
     * Impelmentación obtenida del repositorio de GitHub
     * @param myArray
     * @param inf
     * @param sup
     * @param myCompare
     */
    public void quickSort(T[] myArray, int inf, int sup, Comparator<T> myCompare) {
        int i = inf - 1;
        int j = sup;
        boolean flag = true;
        T temp;
        
        
        if (inf >= sup) {
            return;
        }
        
        T elem_div = myArray[sup];
        
        
        while (flag) {
            while(myCompare.compare(myArray[++i], elem_div) < 0); //Move the index i until it finds an element bigger than elem_div
            while((myCompare.compare(myArray[--j], elem_div) > 0)  && (j > inf)); //Move the index j until it finds element smaller than elem_div
            
            if (i < j) {
                temp = myArray[i];
                myArray[i] = myArray[j];
                myArray[j] = temp;
            } else {
                flag = false;
            }
        }
        
        temp = myArray[i];
        myArray[i] = myArray[sup];
        myArray[sup] = temp;
        quickSort(myArray, inf, i - 1, myCompare);
        quickSort(myArray, i + 1, sup, myCompare);
    }

    /**
     * Implementación de GnomeSort
     * Implementación obtenida de OpenGenus IQ
     * @param myArray
     */
    public void gnomeSort(T[] myArray){
        int i = 1;
        int n = myArray.length;

        while (i < n){
            if (i == 0 || Integer.valueOf((String) myArray[i - 1]) <= Integer.valueOf((String) myArray[i])){
                i++;
            } else {
                T tmp = myArray[i];
                myArray[i] = myArray[i - 1];
                myArray[--i] = tmp;
            }
        }
    }

    /**
     * Implementación de MergeSort
     * Implementación obtenida de JavaStructures
     * @param myArray
     * @param temp
     * @param low
     * @param middle
     * @param high
     */
    public void mergeSort(T[] myArray, T[] temp, int low, int middle, int high) {
        int ri = low;
        int ti = low;
        int di = middle;

        while (ti < middle && di <= high){
            if (Integer.valueOf((String) myArray[di]) < Integer.valueOf((String) myArray[ti])){
                myArray[ri++] = myArray[di++];
            } else {
                myArray[ri++] = temp[ti++];
            }
        }
    }

    /**
     * Implementación de RadixSort
     * Implementación obtenida de Programiz.com
     */
    public void countingSort(T[] myArray, int size, int place){
        int array;
        int i;
        int[] output = new int[size + 1];
        int max = Integer.valueOf((String) myArray[0]);
        for (i = 1; i < size; i++) {
            if (Integer.valueOf((String) myArray[i]) > max)
                max = Integer.valueOf((String) myArray[i]);
        }

        int[] count = new int[max + 1];

        for (i = 0; i < max; i++)
            count[i] = 0;

        for (i = 0; i < size; i++)
            count[(Integer.valueOf((String) myArray[i])/place) % 10]++;
        
        for (i = size - 1; i >= 0; i--) {
            output[count[(Integer.valueOf((String) myArray[i]) / place) % 10] - 1] = Integer.valueOf((String) myArray[i]);
            count[(Integer.valueOf((String) myArray[i])/ place) % 10]--;
        }

        for (i= 0; i < size; i++)
            array = Integer.valueOf((String) myArray[i]);
            array = output[i];
    }

    public int getMax(T[] myArray, int n) {
        int max = Integer.valueOf((String) myArray[0]);
        for (int i = 1; i < n; i++)
            if (Integer.valueOf((String) myArray[i]) > max)
                max = Integer.valueOf((String) myArray[i]);
            return max;
    }

    public void radixSort(T[] myArray, int size){
        int max = getMax(myArray, size);

        for (int place = 1; max / place > 0; place *= 10)
            countingSort(myArray, size, place);
    }
    

    /**
     * Implementación de SelectionSort
     * Implementación obtenida de edureka.co
     * 
     */
    public void selectionSort(T[] myArray){
        int n = myArray.length;
        for (int i = 0; i < n-1; i++){
            int min_element = i;
            for (int j = i+1; j< n; j++){
                if (Integer.valueOf((String) myArray[j]) < Integer.valueOf((String) myArray[min_element]))
                    min_element = j;
                
                int array = Integer.valueOf((String) myArray[min_element]); 
                int Iarray = Integer.valueOf((String) myArray[i]);  
                int temp = array;
                array = Iarray;
                Iarray = temp;
            }

        }
    }
}

