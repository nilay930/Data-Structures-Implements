import java.util.Scanner;

import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;

public class CircularLinkedListDriver {
    public static void main(String[] args) throws Exception {
        System.out.println("Commands:");
        System.out.println(" (i) - Insert value");
        System.out.println(" (d) - Delete value");
        System.out.println(" (p) - Print list");
        System.out.println(" (s) - Search value");
        System.out.println(" (l) - Print length");
        System.out.println(" (r) - Reverse list");
        System.out.println(" (q) - Quit program");
        CircularLinkedList sll1 = new CircularLinkedList();

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
                int lower;
                int upper;
                System.out.print("Enter a command: ");
                input = in.next();
                // System.out.println();
                if (input.equals("i")) {
                    System.out.print("Enter a number to insert: ");
                    val = in.nextInt();
                    System.out.print("Before insert: ");
                    sll1.print();
                    sll1.insertItem(new ItemType(val));
                    System.out.print("After insert: ");
                    sll1.print();
                } // i
                else if (input.equals("d")) {
                    System.out.print("Enter a number to delete: ");
                    val = in.nextInt();
                    System.out.print("Before delete: ");
                    sll1.print();
                    sll1.deleteItem(new ItemType(val));
                    System.out.print("After delete: ");
                    sll1.print();
                } // d
                else if (input.equals("s")) {
                    System.out.print("Enter a number to search: ");
                    val = in.nextInt();
                    System.out.print("The list is: ");
                    sll1.print();
                    int place = sll1.searchItem(new ItemType(val));
                    if (place > 0) {
                        System.out.println("The item is present at index " + place);
                    } else {
                        System.out.println("The item is not present in the list");
                    }

                } // s
                else if (input.equals("r")) {
                    System.out.print("Input list: ");
                    sll1.print();
                    System.out.print("Reverse list: ");
                     System.setOut(alt);
                    sll1.reverse();
                     System.setOut(normal);
                    sll1.print();
                } // r
                else if (input.equals("p")) {
                    System.out.print("The list is: ");
                    sll1.print();
                } // p
                else if (input.equals("l")) {
                    System.out.print("The length of the list is: ");
                    System.out.println(sll1.getLength());
                } // l
                else if (input.equals("q")) {
                    System.out.println("Exiting the program...");
                    running = false;
                } // q
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


/*
else if (input.equals("w")) {
    System.out.print("Enter a lower bound: ");
    lower = in.nextInt();
    System.out.print("Enter an upper bound: ");
    upper = in.nextInt();
    sll1 = sll1.deleteSubsection(sll1, lower, upper);
    sll1.print();
} // w
*/
