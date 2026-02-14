package com.template;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final String FILENAME = "numeros.txt";

    public static void main(String[] args) {
        System.out.println("Iniciando evaluación ");

        int[] intervals = {10, 100, 500, 1000, 1200, 1600, 1800, 2000, 3000};

        for (int size : intervals) {
            System.out.println("Evaluando con " + size + " números:");

            generateNumbersFile(FILENAME, size);

            Integer[] arrGnome = readNumbersFile(FILENAME, size);
            Sorts.gnomeSort(arrGnome);
            Sorts.gnomeSort(arrGnome);

            Integer[] arrMerge = readNumbersFile(FILENAME, size);
            Sorts.mergeSort(arrMerge);
            Sorts.mergeSort(arrMerge);

            Integer[] arrQuick = readNumbersFile(FILENAME, size);
            Sorts.quickSort(arrQuick, 0, arrQuick.length - 1);
            Sorts.quickSort(arrQuick, 0, arrQuick.length - 1); 

            Integer[] arrRadix = readNumbersFile(FILENAME, size);
            Sorts.radixSort(arrRadix); 
            Sorts.radixSort(arrRadix); 

            Integer[] arrBubble = readNumbersFile(FILENAME, size);
            Sorts.bubbleSort(arrBubble);
            Sorts.bubbleSort(arrBubble);
        }

        System.out.println("Ejecución finalizada. Revisa los resultados en tu Profiler.");
    }

    private static void generateNumbersFile(String filename, int count) {
        try (FileWriter writer = new FileWriter(filename)) {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                writer.write(random.nextInt(10000) + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al generar archivo: " + e.getMessage());
        }
    }

    private static Integer[] readNumbersFile(String filename, int count) {
        Integer[] array = new Integer[count];
        try (Scanner scanner = new Scanner(new File(filename))) {
            int i = 0;
            while (scanner.hasNextInt() && i < count) {
                array[i++] = scanner.nextInt();
            }
        } catch (IOException e) {
            System.err.println("Error al leer archivo: " + e.getMessage());
        }
        return array;
    }
}