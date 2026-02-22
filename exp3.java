import java.util.Scanner;

public class Exepriment3 {

    // Linear Search
    static int linearSearch(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    // Binary Search 
    static int binarySearch(int arr[], int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // Bubble Sort
    static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Insertion Sort
    static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Selection Sort
    static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }


    // add after learning practical
    // 🔹 Merge Sort
    static void mergeSort(int arr[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    static void merge(int arr[], int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[low + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = low;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
    }

    // 🔹 Quick Sort
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    // Display Array
    static void display(int arr[]) {
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Bubble Sort");
            System.out.println("4. Insertion Sort");
            System.out.println("5. Selection Sort");
            System.out.println("6.Merge Sort");
            System.out.println("7.Quick Sort");
            System.out.println("8.Display");
            System.out.println("0. Exit");


            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key to search: ");
                    int key1 = sc.nextInt();
                    int res1 = linearSearch(arr, key1);
                    if (res1 == -1)
                        System.out.println("Element not found");
                    else
                        System.out.println("Element found at index " + res1);
                    break;

                case 2:
                    bubbleSort(arr); // sort before binary search
                    System.out.print("Enter key to search: ");
                    int key2 = sc.nextInt();
                    int res2 = binarySearch(arr, key2);
                    if (res2 == -1)
                        System.out.println("Element not found");
                    else
                        System.out.println("Element found at index " + res2);
                    break;

                case 3:
                    bubbleSort(arr);
                    System.out.println("Array after Bubble Sort:");
                    display(arr);
                    break;

                case 4:
                    insertionSort(arr);
                    System.out.println("Array after Insertion Sort:");
                    display(arr);
                    break;

                case 5:
                    selectionSort(arr);
                    System.out.println("Array after Selection Sort:");
                    display(arr);
                    break;

                case 6:
                    mergeSort(arr, 0, arr.length - 1);
                    display(arr);
                    break;
                case 7:
                    quickSort(arr, 0, arr.length - 1);
                    display(arr);
                    break;
                case 8:
                    display(arr);
                    break;

                case 0:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}
