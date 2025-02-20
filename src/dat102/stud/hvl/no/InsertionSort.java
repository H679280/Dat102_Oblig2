package dat102.stud.hvl.no;

import java.util.Random;
import java.util.Arrays;

public class InsertionSort {

	// Metode for å måle tiden til en sorteringsmetode
	public static long measureSortTime(Integer[] array, Runnable sortMethod) {
		Integer[] copy = Arrays.copyOf(array, array.length);
		long startTime = System.nanoTime();
		sortMethod.run();
		long endTime = System.nanoTime();
		return (endTime - startTime) / 1_000_000; // Konverterer til millisekunder
	}

	// Insertion Sort med optimalisering
	public static void optimizedInsertionSort(Integer[] array) {
		int n = array.length;
		// Finn minste element og sett det først
		int minIndex = 0;
		for (int i = 1; i < n; i++) {
			if (array[i] < array[minIndex]) {
				minIndex = i;
			}
		}
		int temp = array[minIndex];
		array[minIndex] = array[0];
		array[0] = temp;

		// Standard Insertion Sort med innsetting av to elementer
		for (int i = 1; i < n; i++) {
			int key = array[i];
			int j = i - 1;
			while (array[j] > key) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}

	// Oppgave c
	public static void selectionSort(Integer[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}

// Genererer en tabell med tilfeldige heltall
	public static Integer[] generateRandomArray(int size, int bound) {
		Random rand = new Random();
		Integer[] array = new Integer[size];
		for (int i = 0; i < size; i++) {
			array[i] = rand.nextInt(bound);
		}
		return array;
	}

	public static void main(String[] args) {
		int n = 32000; // Størrelse på array
		Integer[] array = generateRandomArray(n, 100000);

		long time = measureSortTime(array, () -> optimizedInsertionSort(array));
		System.out.println("Optimalisert Insertion Sort tok: " + time + " ms");
	}
}
