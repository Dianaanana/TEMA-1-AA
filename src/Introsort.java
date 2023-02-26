public class Introsort extends  HybridSortAlgorithm {

    // the actual data that has to be sorted
    int a[];

    // the number of elements in the data
    int n;

    // Constructor to initialize the size
    // of the data
    public Introsort(int[] a, int n)
    {
        super(a, n);

    }

    // The utility function to insert the data
    public static void dataAppend(int temp, int[] a, int n)
    {
        a[n] = temp;
        n++;
    }

    // The utility function to swap two elements
    public static void swap(int i, int j, int[] a)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // To maxHeap a subtree rooted with node i which is
    // an index in a[]. heapN is size of heap
    public static void maxHeap(int i, int heapN, int begin, int[] a)
    {
        int temp = a[begin + i - 1];
        int child;

        while (i <= heapN / 2) {
            child = 2 * i;

            if (child < heapN
                    && a[begin + child - 1] < a[begin + child])
                child++;

            if (temp >= a[begin + child - 1])
                break;

            a[begin + i - 1] = a[begin + child - 1];
            i = child;
        }
        a[begin + i - 1] = temp;
    }

    // Function to build the heap (rearranging the array)
    public static void heapify(int begin, int end, int heapN, int[] a)
    {
        for (int i = (heapN) / 2; i >= 1; i--)
            maxHeap(i, heapN, begin, a);
    }

    // main function to do heapsort
    public static void heapSort(int begin, int end, int[] a)
    {
        int heapN = end - begin;

        // Build heap (rearrange array)
        Introsort.heapify(begin, end, heapN, a);

        // One by one extract an element from heap
        for (int i = heapN; i >= 1; i--) {

            // Move current root to end
            swap(begin, begin + i, a);

            // call maxHeap() on the reduced heap
            maxHeap(1, i, begin, a);
        }
    }

    // function that implements insertion sort
    public static void insertionSort(int left, int right, int[] a)
    {

        for (int i = left; i <= right; i++) {
            int key = a[i];
            int j = i;

            // Move elements of arr[0..i-1], that are
            // greater than the key, to one position ahead
            // of their current position
            while (j > left && a[j - 1] > key) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = key;
        }
    }

    // Function for finding the median of the three elements
    public static int findPivot(int a1, int b1, int c1, int[] a)
    {
        int max = Math.max(Math.max(a[a1], a[b1]), a[c1]);
        int min = Math.min(Math.min(a[a1], a[b1]), a[c1]);
        int median = max ^ min ^ a[a1] ^ a[b1] ^ a[c1];
        if (median == a[a1])
            return a1;
        if (median == a[b1])
            return b1;
        return c1;
    }

    // This function takes the last element as pivot, places
    // the pivot element at its correct position in sorted
    // array, and places all smaller (smaller than pivot)
    // to the left of the pivot
    // and greater elements to the right of the pivot
    public static int partition(int low, int high, int[] a)
    {

        // pivot
        int pivot = a[high];

        // Index of smaller element
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {

            // If the current element is smaller
            // than or equal to the pivot
            if (a[j] <= pivot) {

                // increment index of smaller element
                i++;
                swap(i, j, a);
            }
        }
        swap(i + 1, high, a);
        return (i + 1);
    }

    // The main function that implements Introsort
    // low  --> Starting index,
    // high  --> Ending index,
    // depthLimit  --> recursion level
    public static void sortDataUtil(int begin, int end, int depthLimit, int[] a)
    {
        if (end - begin > 16) {
            if (depthLimit == 0) {

                // if the recursion limit is
                // occurred call heap sort
                Introsort.heapSort(begin, end, a);
                return;
            }

            depthLimit = depthLimit - 1;
            int pivot = findPivot(begin,
                    begin + ((end - begin) / 2) + 1,
                    end, a);
            swap(pivot, end, a);

            // p is partitioning index,
            // arr[p] is now at right place
            int p = partition(begin, end, a);

            // Separately sort elements before
            // partition and after partition
            sortDataUtil(begin, p - 1, depthLimit, a);
            sortDataUtil(p + 1, end, depthLimit, a);
        }

        else {
            // if the data set is small,
            // call insertion sort
            insertionSort(begin, end, a);
        }
    }

    // A utility function to begin the
    // Introsort module
    public static void sortData(int[] a, int n)
    {

        // Initialise the depthLimit
        // as 2*log(length(data))
        int depthLimit
                = (int)(2 * Math.floor(Math.log(n) /
                Math.log(2)));

        Introsort.sortDataUtil(0, n - 1, depthLimit, a);
    }

    public static void introSort(int[] arr, int n) {
//        for (int i = 0; i < n; i++) {
//            Introsort.dataAppend(arr[i], arr, n);
//        }
        long maxMemory = 0;
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        maxMemory = Math.max(maxMemory, totalMemory);
        Introsort.sortData(arr, n);

        System.out.println("maxMemory is  = " + maxMemory + " bits");
    }
}