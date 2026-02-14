package com.template;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String fileName = "numeros.txt";
        generateNumbers(fileName, 3000);

        int[] intervals = {10, 100, 500, 1000, 1500, 2000, 2500, 3000};

        System.out.println("Algoritmo,N,Escenario,Tiempo(ms)");

        for (int n : intervals) {
            Integer[] data = readNumbers(fileName, n);
            
            runMeasuredSorts(data.clone(), n, "Promedio");

            Integer[] ordenado = data.clone();
            Sorts.quickSort(ordenado, 0, ordenado.length - 1); 
            runMeasuredSorts(ordenado, n, "Mejor");
        }
    }

    private static void runMeasuredSorts(Integer[] arr, int n, String escenario) {
        measure("GnomeSort", n, escenario, () -> Sorts.gnomeSort(arr.clone()));
        measure("MergeSort", n, escenario, () -> Sorts.mergeSort(arr.clone()));
        measure("QuickSort", n, escenario, () -> Sorts.quickSort(arr.clone(), 0, n - 1));
        measure("RadixSort", n, escenario, () -> Sorts.radixSort(arr.clone()));
        measure("BubbleSort", n, escenario, () -> Sorts.bubbleSort(arr.clone()));
    }

    private static void measure(String nombre, int n, String escenario, Runnable sortAlgorithm) {
        long startTime = System.nanoTime();
        sortAlgorithm.run();
        long endTime = System.nanoTime();
        
        double duration = (endTime - startTime) / 1_000_000.0;
        System.out.println(nombre + "," + n + "," + escenario + "," + duration);
    }

    private static void generateNumbers(String fileName, int count) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            Random rand = new Random();
            for (int i = 0; i < count; i++) {
                out.println(rand.nextInt(10000));
            }
        } catch (Exception e) {}
    }

    private static Integer[] readNumbers(String fileName, int n) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            return lines.stream().limit(n).map(Integer::parseInt).toArray(Integer[]::new);
        } catch (Exception e) {
            return new Integer[0];
        }
    }
}