import java.util.*;

class Sort <E extends Comparable<? super E>>{
    static long numberOfIterations;
    
    // a. selectionSort
    static <E extends Comparable<E>> void selectionSort(E[] array){
        // step 1: loop from the beginning of the array to the second to last item
        
        for (int currentIndex = 0; currentIndex < array.length - 1; currentIndex++)
        {
            numberOfIterations++; 
            // step 2: save a copy of the currentIndex
            int minIndex = currentIndex;
            
            // step 3: loop through all indexes that proceed the currentIndex
            for (int i = currentIndex + 1; i < array.length; i++)
            {
                // step 4:  if the value of the index of the current loop is less
                //          than the value of the item at minIndex, update minIndex
                //          with the new lowest value index */
                if (array[i].compareTo(array[minIndex]) < 0){
                    // update minIndex with the new lowest value index
                    
                    minIndex = i;
                }
                numberOfIterations++; 
            }
            // step 5: if minIndex has been updated, swap the values at minIndex and currentIndex
            if (minIndex != currentIndex){
                numberOfIterations++; 
                E temp = array[currentIndex];
                array[currentIndex] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }


    // b. Insertion Sort 
    static <E extends Comparable<E>> void insertionSort(E[] array){
        // start at the first index and iterate through to the end
        
        for (int i = 1; i < array.length; i++)
        {
            numberOfIterations++; 
            int currentIndex = i;
            
            /*
             * Check:
             *      1. that currentIndex is at least 1
             *      2. that the item directly before the currentIndex is greater than the item at currentIndex
             *
             * If both conditions are met, swap the indexes
             */
            while (currentIndex > 0 && array[currentIndex - 1].compareTo(array[currentIndex]) > 0)
            {
                
                E temp = array[currentIndex];
                array[currentIndex] = array[currentIndex - 1];
                array[currentIndex - 1] = temp;
                currentIndex--;
                numberOfIterations++; 
            }
        }
    }


    // c. Bubble Sort
    static <E extends Comparable<E>> void bubbleSort(E[] list){
        
        int n = list.length;
        while (n > 0)
        {
            int lastModifiedIndex = 0;
            
            for (int currentIndex = 1; currentIndex < n; currentIndex++)
            {
                // if the item at the previous index is greater than the item at the `currentIndex`, swap them
                if (list[currentIndex - 1].compareTo(list[currentIndex]) > 0){
                    // swap
                    E temp = list[currentIndex - 1];
                    list[currentIndex - 1] = list[currentIndex];
                    list[currentIndex] = temp;
                    
                    // save the index that was modified
                    lastModifiedIndex = currentIndex;
                    
                }
                numberOfIterations++; 
            }
            // save the last modified index so we know not to iterate past it since all proceeding values are sorted
            n = lastModifiedIndex;
        }
    }


    // d. Merge Sort
    // in class
    static <E extends Comparable<E>> void mergeSort(E[] list) {
        if (list.length > 1) { // base case


            E[] leftArray  = (E[]) new Comparable[list.length/2];
            E[] rightArray = (E[]) new Comparable[list.length -list.length/2];

            System.arraycopy(list, 0, leftArray, 0, list.length/2);
            System.arraycopy(list, list.length/2, rightArray, 0,list.length-list.length/2);
            mergeSort(leftArray);
            numberOfIterations++; 
            mergeSort(rightArray);
            numberOfIterations++; 
            merge(leftArray, rightArray, list);
            }
    }

    static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] list) {
        int list1Index = 0;
        int list2Index = 0;
        int listIndex = 0;
        while( list1Index < list1.length && list2Index < list2.length) {
            if (list1[list1Index].compareTo(list2[list2Index]) < 0){
            list[listIndex++] = list1[list1Index++];
            } else {
            list[listIndex++] = list2[list2Index++];
            }
            numberOfIterations++; 
        }

        while(list1Index < list1.length){
            list[listIndex++] = list1[list1Index++];
            numberOfIterations++; 
        }

        while(list2Index < list2.length){
            list[listIndex++] = list2[list2Index++];
            numberOfIterations++; 
        }
    }


    // e. Quick Sort
    static <E extends Comparable<E>> void quickSort(E[] list) {
        numberOfIterations++; // 
        quickSort(list, 0, list.length-1);
    }

    static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
        numberOfIterations++; // 
        if (last > first) {
            numberOfIterations++; // 
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex-1);
            numberOfIterations++; // 
            quickSort(list, pivotIndex+1, last);
            numberOfIterations++; // 
        }
    }
        
    static <E extends Comparable<E>> int partition(E list[], int first, int last){
        numberOfIterations++; // 
        E pivot;
        int index, smallIndex;
        pivot = list[first];// pivot is the first element
        smallIndex = first;{
        for (index = first + 1; index <= last; index++)
        
            if (list[index].compareTo(pivot) < 0){
                numberOfIterations++; // 

                smallIndex++;
                numberOfIterations++; // 
                swap(list, smallIndex, index);
            }
            numberOfIterations++; // 
            swap(list, first, smallIndex);
            numberOfIterations++; //
            
        }
        return smallIndex;
    }

    

    static <E extends Comparable<E>> void heapSort(E[] list) {
        Heap<E> heap = new Heap<>(list);
        for (int i=list.length-1; i>=0; i--) {
            list[i] = heap.remove();
        }
    }
    

    // g. Bucket Sort
    /**
     * 
     * @param <E>
     * @param list
     * @param t largest number or array
     */
    static <E extends Comparable<E>> void bucketSort (E[] list, int t){
        ArrayList<ArrayList<E>> buckets;
        buckets = new ArrayList<>(t+1);
        for(int i=0; i<t+1; i++){
            buckets.add(new ArrayList<>());
            numberOfIterations++;
        }

        //Distribute data on buckets
        for(int i=0; i<list.length; i++) {
            ArrayList<E> bucket = buckets.get(i);
            bucket.add(list[i]);
            buckets.set(i, bucket);
            numberOfIterations++;
        }

        // Move data from the buckets back to the list
        int k = 0;
        for(int i=0; i<buckets.size(); i++) {
            ArrayList<E> bucket = buckets.get(i);
            for(int j=0; j<bucket.size(); j++){
                
                list[k++] = bucket.get(j);
                numberOfIterations++;
            }
        }

    }


    // h. Radix Sort
    static void radixSort(Integer[] randomArray) {
        sortRadixSort(randomArray, 10);
        numberOfIterations++; //
    }

    static void sortRadixSort(Integer[] array, int radix) {
        if (array.length == 0) {
            return;
        }

        // Determine minimum and maximum values
        int minValue = array[0];
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            numberOfIterations++; //
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        // Perform counting sort on each exponent/digit, starting at the least
        // significant digit
        int exponent = 1;
        while ((maxValue - minValue) / exponent >= 1) {
            numberOfIterations++; //
            countingSortByDigitradixSort(array, radix, exponent, minValue);
            exponent *= radix;
        }
    }

    static void countingSortByDigitradixSort(Integer[] array, int radix, int exponent, int minValue) {
        numberOfIterations++; //

        int bucketIndex;
        int[] buckets = new int[radix];
        int[] output = new int[array.length];
        
        // Initialize bucket
        for (int i = 0; i < radix; i++) {
            numberOfIterations++; //
            buckets[i] = 0;
        }

        // Count frequencies
        for (int i = 0; i < array.length; i++) {
            numberOfIterations++; //
            bucketIndex = (int)(((array[i] - minValue) / exponent) % radix);
            buckets[bucketIndex]++;
        }

        // Compute cumulates
        for (int i = 1; i < radix; i++) {

            buckets[i] += buckets[i - 1];
        }

        // Move records
        for (int i = array.length - 1; i >= 0; i--) {
            numberOfIterations++; //
            bucketIndex = (int)(((array[i] - minValue) / exponent) % radix);
            output[--buckets[bucketIndex]] = array[i];
        }

        // Copy back
        for (int i = 0; i < array.length; i++) {

            array[i] = output[i];
        }
    }
    /*
    static <E extends Comparable<E>> void radixSort(int[] array)
    {
        // get the largest number to know how many place values we need to sort
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++){
            numberOfIterations--;
            if (array[i] > maxValue){
                // numberOfIterations++;
                maxValue = array[i];
            }
        }
        // sort the array at each placeValue
        for (int placeValue = 1; maxValue / placeValue > 0; placeValue *= 10){
            countingSort(array, placeValue);
            // numberOfIterations++;
        }

    }

    static <E extends Comparable<E>> void countingSort(int[] array, int placeValue)
    {
        // numberOfIterations++; // 
        // step 1: create an empty array that will store the sorted version of the array
        int[] output = new int[array.length];
        // step 2: create an empty array that will track the placeValue frequency
        int[] placeValueFrequency = new int[10];

        // step 3: find the amount of times the array has a value in the placeValue we're searching for
        for (int i = 0; i < array.length; i++)
        {
            // numberOfIterations++; // 
            int value = (array[i] / placeValue) % 10;
            placeValueFrequency[value]++;
        }

        // step 4: reposition the indexes so that the indexes with smaller placeValues are moved to the beginning of the array
        for (int i = 1; i < 10; i++){
            // numberOfIterations++; // 
            placeValueFrequency[i] += placeValueFrequency[i - 1];
        }

        // step 5: starting from the end of the array, add each index index from the original array to the output array
        // the frequency - 1 of the value in the current placeValue will represent the index to place the original index
        for (int i = array.length - 1; i >= 0; i--)
        {
            // numberOfIterations++; // 
            int value = (array[i] / placeValue) % 10; // the value of the current placeValue
            output[placeValueFrequency[value] - 1] = array[i];
            placeValueFrequency[value]--;
        }

        // step 6: copy the more sorted version of the array back into the original array
        for (int i = 0; i < array.length; i++){
            // numberOfIterations++; // 
            array[i] = output[i];
        }
    }
    */



    // Helper
    public static <E> void swap (E[] a, int i, int j) {
        numberOfIterations++; //
        E t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}