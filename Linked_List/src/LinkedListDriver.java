import java.util.Scanner;

import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;

public class LinkedListDriver {
    public static void main(String[] args) throws Exception {
        System.out.println("Commands:");
        System.out.println(" (i) - Insert value");
        System.out.println(" (d) - Delete value");
        System.out.println(" (s) - Search value");
        System.out.println(" (a) - Delete alternate nodes");
        System.out.println(" (m) - Merge lists");
        System.out.println(" (p) - Print list");
        System.out.println(" (l) - Print length");
        System.out.println(" (q) - Quit program");
        SortedLinkedList sll1 = new SortedLinkedList();

        String filename = args[0];

        Scanner filein = new Scanner(new File(filename));
        while (filein.hasNextInt()) {
            int filenum;
            filenum = filein.nextInt();
            sll1.insertItem(new ItemType(filenum));
        }
        PrintStream normal = System.out;
        PrintStream alt = new PrintStream(new OutputStream() {
            public void write(int x){
            }
        });
        boolean running = true;
        Scanner in = new Scanner(System.in);
        while (running == true) {
            try {
                String input;
                int val;
                System.out.print("Enter a command: ");
                input = in.next();
                // System.out.println();
                if (input.equals("i")) {
                    System.out.print("Enter a number to insert: ");
                    val = in.nextInt();
                    System.out.print("Original list: ");
                    sll1.printer();
                    sll1.insertItem(new ItemType(val));
                    System.out.print("New list: ");
                    sll1.printer();
                } // i
                else if (input.equals("d")) {
                    System.out.print("Enter a number to delete: ");
                    val = in.nextInt();
                    System.out.print("Original list: ");
                    sll1.printer();
                    sll1.deleteItem(new ItemType(val));
                    System.out.print("New list: ");
                    sll1.printer();
                } // d
                else if (input.equals("s")) {
                    System.out.print("Enter a number to search: ");
                    val = in.nextInt();
                    int place = sll1.searchItem(new ItemType(val));
                    System.out.println("The item is present at index " + place);
                } // s
                else if (input.equals("a")) {
                    System.out.print("Original list: ");
                    sll1.printer();
                    sll1.deleteAlt();
                    System.out.print("New list: ");
                    sll1.printer();
                } // a
                else if (input.equals("p")) {
                    System.out.print("The list is: ");
                    sll1.printer();
                } // p
                else if (input.equals("l")) {
                    System.out.print("The length of the list is: ");
                    System.out.println(sll1.getLength());
                } // l
                else if (input.equals("q")) {
                    System.out.println("Exiting the program...");
                    running = false;
                } // q
                else if (input.equals("m")) {
                    System.out.print("Enter the length of the new list: ");
                    SortedLinkedList sll2 = new SortedLinkedList();
                    int list_val;
                    val = in.nextInt();
                    System.out.print("Enter the numbers: ");
                    for (int i = 0; i < val; i++) {
                        list_val = in.nextInt();
                        sll2.insertItem(new ItemType(list_val));
                    } // for inputting
                    System.out.print("The list one: ");
                    sll1.printer();
                    System.out.print("The list two: ");
                    sll2.printer();
                    System.setOut(alt);
                    sll1.mergeList(sll1, sll2);
                    System.setOut(normal);
                    System.out.print("Merged list: ");
                    sll1.printer();
                } // m
                else {
                    System.out.println("Invalid command try again");
                }
            } catch (InputMismatchException ime) {
                System.err.println("Input a number!");
            }
        } // while
        in.close();
    }
}
