package dat102.stud.hvl.no;

import java.util.Random;

public class SorteringsTest {
	public static void main(String[] args) {
        int n = 36000; // Startverdi for test
        Random random = new Random();
        Integer[] tabell = new Integer[n];

        // Fyller den med tilfeldige tall
        for (int i = 0; i < n; i++) {
            tabell[i] = random.nextInt(100000);
        }

        Integer[] klonet;
        long insertion = 0;
        long selection = 0; 
        long quick = 0; 
        long merge = 0;
        
        
        //kloner sånn at man får den samme tabellen og ikke sortert. 
        for (int i = 0; i<10; i++) {
        	klonet = tabell.clone();
            long start = System.nanoTime();
            Oppg2.insertionSort(klonet);
            long slutt = System.nanoTime();
            insertion += slutt - start;

            klonet = tabell.clone();
            start = System.nanoTime();
            Oppg2.selectionSort(klonet);
            slutt = System.nanoTime();
            selection+=slutt-start;

            klonet = tabell.clone();
            start = System.nanoTime();
            Oppg2.quickSort(klonet, 0, klonet.length - 1);
            slutt = System.nanoTime();
            quick+=slutt-start;

            klonet = tabell.clone();
            start = System.nanoTime();
            Oppg2.mergeSort(klonet, 0, klonet.length - 1);
            slutt = System.nanoTime();
            merge+=slutt-start;
        }
        System.out.printf("Gjennomsnitt Insertion Sort: %.3f ms\n", insertion / (10.0 * 1e6));
        System.out.printf("Gjennomsnitt Selection Sort: %.3f ms\n", selection / (10.0 * 1e6));
        System.out.printf("Gjennomsnitt Quick Sort: %.3f ms\n", quick / (10.0 * 1e6));
        System.out.printf("Gjennomsnitt Merge Sort: %.3f ms\n", merge / (10.0 * 1e6));


        
       
    }

}
