package dat102.stud.hvl.no;

public class Oppg2 {
	public static void insertionSort(Integer[] a) {
	    int n = a.length;
	    for (int i = 1; i < n; i++) {
	        int key = a[i];
	        int j = i - 1;

	        while (j >= 0 && a[j] > key) {
	            a[j + 1] = a[j];
	            j--;
	        }
	        a[j + 1] = key;
	    }
	}
	
	public static void selectionSort(Integer[] a) {
	    int n = a.length;
	    for (int i = 0; i < n - 1; i++) {
	        int minIndex = i;
	        for (int j = i + 1; j < n; j++) {
	            if (a[j] < a[minIndex]) {
	                minIndex = j;
	            }
	        }
	        int temp = a[minIndex];
	        a[minIndex] = a[i];
	        a[i] = temp;
	    }
	}
	public static void quickSort(Integer[] a, int low, int high) {
	    if (low < high) {
	        int pi = partition(a, low, high);
	        quickSort(a, low, pi - 1);
	        quickSort(a, pi + 1, high);
	    }
	}

	private static int partition(Integer[] a, int low, int high) {
	    int pivot = a[high];
	    int i = low - 1;
	    for (int j = low; j <= high -1; j++) {
	        if (a[j] < pivot) {
	            i++;
	            int temp = a[i];
	            a[i] = a[j];
	            a[j] = temp;
	        }
	    }
	    int temp = a[i + 1];
	    a[i + 1] = a[high];
	    a[high] = temp;
	    return i + 1;
	}
	public static void mergeSort(Integer[] a, int left, int right) {
	    if (left < right) {
	        int mid = left + (right - left) / 2;
	        mergeSort(a, left, mid);
	        mergeSort(a, mid + 1, right);
	        merge(a, left, mid, right);
	    }
	}

	private static void merge(Integer[] a, int left, int mid, int right) {
	    int n1 = mid - left + 1;
	    int n2 = right - mid;

	    Integer[] L = new Integer[n1];
	    Integer[] R = new Integer[n2];

	    System.arraycopy(a, left, L, 0, n1);
	    System.arraycopy(a, mid + 1, R, 0, n2);

	    int i = 0, j = 0, k = left;
	    while (i < n1 && j < n2) {
	        if (L[i] <= R[j]) {
	            a[k] = L[i];
	            i++;
	        } else {
	            a[k] = R[j];
	            j++;
	        }
	        k++;
	    }

	    while (i < n1) {
	        a[k] = L[i];
	        i++;
	        k++;
	    }

	    while (j < n2) {
	        a[k] = R[j];
	        j++;
	        k++;
	    }
	}
	
	public static void main (String[]args) {
		
		int n = 36000;
		
        Integer[] tab = new Integer[n];

        for (int i = 0; i < n; i++) {
            tab[i] = 1;
        }
        
		
		long start = System.nanoTime();
		quickSort(tab, 0, tab.length - 1);
		long end = System.nanoTime();
		System.out.println((end-start)/1e6);
		
	}

}
