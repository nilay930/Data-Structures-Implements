import java.util.Scanner;
import java.io.File;
import java.util.InputMismatchException;

public class BinarySearchTreeDriver {
    public static void main(String[] args) throws Exception {

        System.out.println("Commands:");
        System.out.println(" (i) - Insert item");
        System.out.println(" (d) - Delete item");
        System.out.println(" (p) - Print tree");
        System.out.println(" (r) - Retrieve item");
        System.out.println(" (l) - Count leaf nodes");
        System.out.println(" (s) - Find single parents");
        System.out.println(" (c) - Find cousins");
        System.out.println(" (q) - Quit program");

        BinarySearchTree bst = new BinarySearchTree();

        String filename = args[0];
        //String filename = "input.txt";

        Scanner filein = new Scanner(new File(filename));
        while (filein.hasNextInt()) {
            int filenum;
         filenum = filein.nextInt();
         bst.insert(new ItemType(filenum));
        }

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
                    System.out.print("In order: ");
                    bst.inOrder();
                    bst.insert(new ItemType(val));
                    System.out.println();
                    System.out.print("In order: ");
                    bst.inOrder();
                    System.out.println();
                } // i
                else if (input.equals("p")) {
                    System.out.print("In-order: ");
                    bst.inOrder();
                    System.out.println();
                }
                else if (input.equals("d")) {
                    try {
                    System.out.print("In order: ");
                    bst.inOrder();
                    System.out.println();
                    System.out.print("Enter a number to delete: ");
                    val = in.nextInt();
                    bst.delete(new ItemType(val));
                    System.out.print("In order: ");
                    bst.inOrder();
                    System.out.println();
                    } catch (NullPointerException e) {
                        System.out.println("The number is not present in the tree");
                    }
                } // d
                else if (input.equals("r")) {
                    System.out.print("Enter a number to search: ");
                    val = in.nextInt();
                    System.out.print("In order: ");
                    bst.inOrder();
                    System.out.println();
                    if (bst.retrieve(new ItemType(val))== true) {
                        System.out.println("Item is present in the tree.");
                    } else {
                        System.out.println("Item is not present in the tree.");
                    }
                } // r
                else if (input.equals("l")) {
                    System.out.println("The number of leaf nodes are: " + bst.getNumLeafNodes());
                } // l
                else if (input.equals("s")) {
                    System.out.print("Single Parents: ");
                    bst.getSingleParent();
                    System.out.println();
                }
                else if (input.equals("c")) {
                    try {
                    System.out.print("Enter a number to find cousins of: ");
                    val = in.nextInt();
                    System.out.println(val + " cousins: ");
                    bst.getCousins(new ItemType(val));
                } catch (NullPointerException e) {
                    }
                }
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
