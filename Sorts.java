public class Sorts<T> {
    
    /**
     * Implementación de QuickSort
     * Impelmentación del repositorio de GitHub
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
     * Implementación de OpenGenus IQ
     * @param myArray
     */
    public void gnomeSort(T[] myArray){
        int i = 1;
        int n = myArray.length;

        while (i < n){
            if (i == 0 || myArray[i - 1].compareTo(myArray[i]) <= 0){
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
     * Implementación de JavaStructures
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
            if (myArray[di].compareTo(temp[ti]) < 0) {
                myArray[ri++] = data[di++];
            } else {
                data[ri++] = temp[ti++];
            }
        }
    }
}

