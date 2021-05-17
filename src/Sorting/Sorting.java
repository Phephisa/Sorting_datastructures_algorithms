package Sorting;

public class Sorting {

    public static void main(String[] args) {
        //declare array
        int s[] = {5,2,7,1,9,0,4,3};
        //calling the methods
        bubbleSort(s);
        System.out.println("After Bubblesort");
        printArray(s);
        insertionSort(s);
        System.out.println("After Insertionsort");
        printArray(s);
        Sorting sort = new Sorting();
        mergeSort(s, 0, s.length-1);
        System.out.println("After Mergesort");
        printArray(s);
        quickSort(s, 0, s.length-1);
        System.out.println("After Quicksort");
        printArray(s);
    }
    /* Prints the array */
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void bubbleSort(int arr[])
    {

        //declare length of array
        int n = arr.length;
        //sorting loop
        for(int i=0;i<n-1;i++)
            for(int j=0;j<n-i-1;j++)
                //condition if term greater than term in front of it
            if (arr[j]>arr[j+1])
            {
                //swapping the two terms
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
     //printing the array
    };
    public static void insertionSort(int arr[])
    {

        //declaring array size
        int n = arr.length;
        for (int i=0; i<n; i++)
        {
            int key = arr[i]; //current element
            int j = i-1; //previous element

            //moving item greater than key ahead 1 position
            while(j>=0 && arr[j] <key)
            {
                arr[j+1] = arr[j];
                j= j-1;
            }
            //changing key to element on next position
            arr[j+1]=key;
        }

    };
    /*
    //merging function
    public static void merge(int arr[], int first, int mid, int last)
    {
        int l = mid - first +1;
        int r = last -mid;

        int la[] = new int[l]; //left array
        int ra[] = new int[r]; //right array

        for(int i=0; i<l; i++)
            la[i] = arr[first+1];

        for(int j=0; j<r; j++)
            ra[j] = arr[mid + 1 +j];

        int i=0,j=0;
        int k = first;
        while(i<l && j<r)
        {
            if(la[i]<=ra[j])
            {
                arr[k] = la[i];
                i++;
            }
            else
            {
                arr[k] = ra[j];
                j++;
            }
            k++;
        }
        while(i<l)
        {
            arr[k] = la[i];
            i++;
            k++;
        }
        while(j<r)
        {
            arr[k] = ra[j];
            j++;
            k++;
        }

    }
    public static void mergeSort(int arr[], int first, int last)
    {
        if(first<last)
        {   //getting midpoint
            int mid = first +(last -1)/2;
            //Sorting first and second halves
            mergeSort(arr, first, mid);
            mergeSort(arr, mid+1, last);
            merge(arr,first,mid,last);
            return;
        }
    }; */
    //function to swap two elements
    public static void swap(int[]arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    };
    public static int partition(int[]arr, int low, int high)
    {
        //the pivot
        int pivot = arr[high];
        int i = (low-1); ///index of smallest elelemnt

        for(int j = low; j<=high-1;j++)
        {
            if(arr[j]<pivot)
            {   //increment of index and swapping elelemnts
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return (i+1);
    };
    public static void quickSort(int arr[], int low , int high)
    {
        if(low<high)
        {   //partitioning index
            int pi = partition(arr, low,high);

            //sorting elelemtns separately
            quickSort(arr, low, pi -1);
            quickSort(arr, pi + 1, high);
        }
    };

    public static void mergeSort(int[] array, int low, int high) {
        if (high <= low) return;

        int mid = (low+high)/2;
        mergeSort(array, low, mid);
        mergeSort(array, mid+1, high);
        merge(array, low, mid, high);
    }
    public static void merge(int[] array, int low, int mid, int high) {
        // Creating temporary subarrays
        int leftArray[] = new int[mid - low + 1];
        int rightArray[] = new int[high - mid];

        // Copying our subarrays into temporaries
        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = array[low + i];
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = array[mid + i + 1];

        // Iterators containing current index of temp subarrays
        int leftIndex = 0;
        int rightIndex = 0;

        // Copying from leftArray and rightArray back into array
        for (int i = low; i < high + 1; i++) {
            // If there are still uncopied elements in R and L, copy minimum of the two
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                // If all elements have been copied from rightArray, copy rest of leftArray
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                // If all elements have been copied from leftArray, copy rest of rightArray
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}
