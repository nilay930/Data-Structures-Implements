import java.util.Random;

public class Sorting {

    private int comparisons = 0;

    public Sorting() {} // constructor

    public void getComparisons() {
        System.out.println(comparisons);
    }
    public int getComparisons2() {
      return comparisons;
    }

    // https://www.javadevjournal.com/algorithms/quick-sort/
    // code taken from link above
    public void quickSortRP(int start, int end, int[] a) {
        if (start < end) {
            int index = partitionRP(start, end, a);
            comparisons++;
            quickSortRP(start, index - 1, a);
            quickSortRP(index + 1, end, a);
        }
        comparisons++;
        //return;
    }

    public int partitionRP(int start, int end, int[] a) {
        // #Quick-sort-rp comparisons: 299674
        Random rand = new Random();
        int median = rand.nextInt(end - start) + start;
        int pIndex = start;
        swap2(median, end, a);
        int pivot = end;
        for (int i = start; i <= end - 1; i++) {
            if (a[i] <= a[pivot]) {
                swap2(i, pIndex, a);
                pIndex++;
                comparisons++;
            }
            comparisons++;
        }
        swap2(pivot, pIndex, a);
        return pIndex;
    }

    public void swap2(int s1, int s2, int[] a) {
        int temp = a[s1];
        a[s1] = a[s2];
        a[s2] = temp;
    }

    // https://www.javadevjournal.com/algorithms/quick-sort/
    // code taken from link above
    public void quickSortFP(int start, int end, int[] a) {
        if (start < end) {
            int index = partitionFP(start, end, a);
            comparisons++;
            quickSortFP(start, index - 1, a);
            quickSortFP(index + 1, end, a);
        }
        comparisons++;
        //return;
    }
    public int partitionFP(int start, int end, int[] a) {
        int p = start;
        int i = start;
        int j = end;

        while (i < j) {
            comparisons++;
            while (a[i] <= a[p] && i < end) {
                comparisons++;
                i++;
            }
            while (a[j] > a[p] && j > start) {
                comparisons++;
                j--;
            }
            if (i < j) {
                comparisons++;
                swap(i, j, a);
            }
        }
        swap(j, p, a);
        //comparisons++;
        return j;
    }
    public void swap(int p1, int p2, int[] a) {
        int temp = a[p1];
        a[p1] = a[p2];
        a[p2] = temp;
    }

    // https://www.programiz.com/dsa/heap-sort
    // Code taken from link above
    public void heapSort(int arr[]) {
        // random Heap-sort comparisons: 235440
        int n = arr.length;
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify root element
            heapify(arr, i, 0);
        }
    }
    public void heapify(int arr[], int n, int i) {
        // Find largest among root, left child and right child
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
            comparisons++;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
            comparisons++;
        }
        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            comparisons++;
            heapify(arr, n, largest);
        }
    }

    // https://www.programiz.com/dsa/selection-sort
    // Code taken from link above
    public int[] selectionSort(int array[]) {
        // random run is 49995000
        int size = array.length;
        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;
            for (int i = step + 1; i < size; i++) {
                // Select the minimum element in each loop.
                if (array[i] < array[min_idx]) {
                    min_idx = i;
                    // comparisons++;
                }
                comparisons++;
            }
            // put min at the correct position
            int temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;
        }
        return array;
    } // selectionSort

    public int[] mergeSort(int array[], int first, int last) {
        // random merge on example: 120414
        if (first < last) {
            //comparisons++;
            int middle = (first + last) / 2;
            mergeSort(array, first, middle);
            mergeSort(array, middle + 1, last);
            merge(array, first, middle, middle + 1, last);
        }
        return array;
    } // mergeSort

    public void merge(int array[], int leftFirst, int leftLast, int rightFirst, int rightLast) {
        int len = array.length;
        int tempArray[] = new int[len];
        int index = leftFirst;
        int saveFirst = leftFirst;
        while ((leftFirst <= leftLast) && (rightFirst <= rightLast)) {
            if (array[leftFirst] < array[rightFirst]) {
                tempArray[index] = array[leftFirst];
                leftFirst++;
                comparisons++;
            } else {
                tempArray[index] = array[rightFirst];
                rightFirst++;
                comparisons++;
            }
            index++;
        } // while
        while (leftFirst <= leftLast) { // Copy remaining items from left half.
            tempArray[index] = array[leftFirst];
            leftFirst++;
            index++;
            //comparisons++;
        } // while
        while (rightFirst <= rightLast) {
            tempArray[index] = array[rightFirst];
            rightFirst++;
            index++;
            //comparisons++;
        }
        for (index = saveFirst; index <= rightLast; index++) {
            array[index] = tempArray[index];
        }
    } // merge
}
