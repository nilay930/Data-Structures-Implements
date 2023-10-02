import java.util.Scanner;
import java.io.File;
import java.util.Random;

public class SortDriver {
    public static void main(String[] args) throws Exception {


        String filename = args[0];

        // String filename = "ordered.txt";
        // String filename = "random.txt";
        // String filename = "reverse.txt";


      
        Sorting rahh = new Sorting();

        int toSort[] = new int[10000];
        int position = 0;
        Scanner filein = new Scanner(new File(filename));
        while (filein.hasNextInt()) {
            int num = filein.nextInt();
            toSort[position] = num;
            position++;
        }

      
        
        System.out.println("Java SortDriver " + filename);

        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-fp (q) quick-sort-rp (r)");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the algorithm: ");
        String input;
        input = in .next();

       // For experiment one, sorting the code based off the input file
        if (input.equals("s")) {
            rahh.selectionSort(toSort);
            for (int i = 0; i < toSort.length; i++){
                System.out.print(toSort[i] + " ");
            }
            System.out.println();
            System.out.print("#Selection-sort comparisons: ");
            rahh.getComparisons();
        }
        if (input.equals("m")) {
            rahh.mergeSort(toSort, 0, toSort.length - 1);
            for (int i = 0; i < toSort.length; i++){
                System.out.print(toSort[i] + " ");
            }
            System.out.println();
            System.out.print("#Merge-sort comparisons: ");
            rahh.getComparisons();
        }
        if (input.equals("h")) {
            rahh.heapSort(toSort);
            for (int i = 0; i < toSort.length; i++){
                System.out.print(toSort[i] + " ");
            }
            System.out.println();
            System.out.print("#Heap-sort comparisons: ");
            rahh.getComparisons();
        }
        if (input.equals("q")) {
            rahh.quickSortFP(0, toSort.length - 1, toSort);
            for (int i = 0; i < toSort.length; i++){
                System.out.print(toSort[i] + " ");
            }
            System.out.println();
            System.out.print("#Quick-sort-fp comparisons: ");
            rahh.getComparisons();
        }
        if (input.equals("r")) {
            rahh.quickSortRP(0, toSort.length - 1, toSort);
            for (int i = 0; i < toSort.length; i++){
                System.out.print(toSort[i] + " ");
            }
            System.out.println();
            System.out.print("#Quick-sort-rp comparisons: ");
            rahh.getComparisons();
        }
        /*
        for (int i = 0; i < 30; i++) {
            System.out.print(toSort[i] + " ");
        }
        */
        /*
        for (int i = toSort.length; i > toSort.length-100; i--){
            System.out.print(toSort[i-1] + " ");
        }
        */

      // for experiment 2
        System.out.println("Experiment 2 Testing: ");
        int array_len;
        System.out.print("Input length (integer) of array to sort: ");
        array_len = in .nextInt();
        System.out.println();

        int trials;
        System.out.print("How many trials (integer) should be ran : ");
        trials = in .nextInt();
        System.out.println();

        int testing_len = array_len; // length of array
        int testing_run = trials; // times test executed

        String algo;
        System.out.println("Which sorting algorithm?");
        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-fp (q) quick-sort-rp (r)");
        algo = in.next();

    // double for loop set up to allow for average calculation. Similar set up as experiment one
        if (algo.equals("s")) {
            double[] avg_ss = new double[testing_run]; // times test will be ran
            for (int i = 0; i < avg_ss.length; i++) {
                int[] toSort2 = new int[testing_len];
                Random rand = new Random();
                for (int j = 0; j < toSort2.length; j++) {
                    toSort2[j] = rand.nextInt(testing_len);
                }
                Sorting brr = new Sorting();
                /*
                System.out.println();
                for (int r = 0; r < 10; r++) {
                    System.out.print(toSort2[r] + " ");
                }
                System.out.println();
                */
                brr.selectionSort(toSort2);
                for (int r = 0; r < toSort2.length; r++) {
                    System.out.print(toSort2[r] + " ");
                }
                System.out.println();
                avg_ss[i] = brr.getComparisons2();

            }
            double sum_ss = 0;
            for (int i = 0; i < avg_ss.length; i++) {
                sum_ss = sum_ss + avg_ss[i];
            }
            System.out.println("Avg for selection sort is " + sum_ss / avg_ss.length);
        }

        if (algo.equals("m")) {
            double[] avg_ms = new double[testing_run]; // times test will be ran
            for (int i = 0; i < avg_ms.length; i++) {
                int[] toSort2 = new int[testing_len];
                Random rand = new Random();
                for (int j = 0; j < toSort2.length; j++) {
                    toSort2[j] = rand.nextInt(testing_len);
                }
                Sorting brr = new Sorting();
                /*
                System.out.println();
                for (int r = 0; r < 10; r++) {
                    System.out.print(toSort2[r] + " ");
                }
                System.out.println();
                */
                brr.mergeSort(toSort2, 0, toSort2.length - 1);
                for (int r = 0; r < toSort2.length; r++) {
                    System.out.print(toSort2[r] + " ");
                }
                System.out.println();
                avg_ms[i] = brr.getComparisons2();

            }
            double sum_ms = 0;
            for (int i = 0; i < avg_ms.length; i++) {
                sum_ms = sum_ms + avg_ms[i];
            }
            System.out.println("Avg for merge sort is " + sum_ms / avg_ms.length);

        }

        if (algo.equals("h")) {
            double[] avg_hs = new double[testing_run]; // times test will be ran
            for (int i = 0; i < avg_hs.length; i++) {
                int[] toSort2 = new int[testing_len];
                Random rand = new Random();
                for (int j = 0; j < toSort2.length; j++) {
                    toSort2[j] = rand.nextInt(testing_len);
                }
                Sorting brr = new Sorting();
                /*
                System.out.println();
                for (int r = 0; r < 10; r++) {
                    System.out.print(toSort2[r] + " ");
                }
                System.out.println();
                */
                brr.heapSort(toSort2);
                for (int r = 0; r < toSort2.length; r++) {
                    System.out.print(toSort2[r] + " ");
                }
                System.out.println();
                avg_hs[i] = brr.getComparisons2();
            }
            double sum_hs = 0;
            for (int i = 0; i < avg_hs.length; i++) {
                sum_hs = sum_hs + avg_hs[i];
            }
            System.out.println("Avg for heap sort is " + sum_hs / avg_hs.length);

        }
        if (algo.equals("q")) {
            double[] avg_qsfp = new double[testing_run]; // times test will be ran
            for (int i = 0; i < avg_qsfp.length; i++) {
                int[] toSort2 = new int[testing_len];
                Random rand = new Random();
                for (int j = 0; j < toSort2.length; j++) {
                    toSort2[j] = rand.nextInt(testing_len);
                }
                Sorting brr = new Sorting();
                /*
                System.out.println();
                for (int r = 0; r < 10; r++) {
                    System.out.print(toSort2[r] + " ");
                }
                System.out.println();
                */
                brr.quickSortFP(0, toSort2.length -1, toSort2);
                for (int r = 0; r < toSort2.length; r++) {
                    System.out.print(toSort2[r] + " ");
                }
                System.out.println();
                avg_qsfp[i] = brr.getComparisons2();
            }
            double sum_qsfp = 0;
            for (int i = 0; i < avg_qsfp.length; i++) {
                sum_qsfp = sum_qsfp + avg_qsfp[i];
            }
            System.out.println("Avg for quick sort FP is " + sum_qsfp / avg_qsfp.length);

        }

        if (algo.equals("r")) {
            double[] avg_qsrp = new double[testing_run]; // times test will be ran
            for (int i = 0; i < avg_qsrp.length; i++) {
                int[] toSort2 = new int[testing_len];
                Random rand = new Random();
                for (int j = 0; j < toSort2.length; j++) {
                    toSort2[j] = rand.nextInt(testing_len);
                }
                Sorting brr = new Sorting();
                /*
                System.out.println();
                for (int r = 0; r < 10; r++) {
                    System.out.print(toSort2[r] + " ");
                }
                System.out.println();
                */
                brr.quickSortRP(0, toSort2.length - 1, toSort2);
                for (int r = 0; r < toSort2.length; r++) {
                    System.out.print(toSort2[r] + " ");
                }
                System.out.println();
                avg_qsrp[i] = brr.getComparisons2();
            }
            double sum_qsrp = 0;
            for (int i = 0; i < avg_qsrp.length; i++) {
                sum_qsrp = sum_qsrp + avg_qsrp[i];
            }
            System.out.println("Avg for quick sort RP is " + sum_qsrp / avg_qsrp.length); in .close();

        }

        if (algo.equals("s") || algo.equals("m") || algo.equals("h")
            || algo.equals("q") || algo.equals("r")) {
                //System.out.println("Print sorted output? y/n");
        }
        //System.out.println("Array length is " + testing_len + ". Avg calculated with " + testing_run + " runs.");

    } // main
} // SortDriver
