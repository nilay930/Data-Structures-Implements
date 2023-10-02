public class CircularLinkedList {
    private NodeType head;

    public CircularLinkedList() {
        // head = new NodeType(null);
    }

    public void insertItem(ItemType item) {
        NodeType nodeToAdd = new NodeType(item);
        if (head == null) { // creating a cLL
            nodeToAdd.next = nodeToAdd;
            head = nodeToAdd;
            return;
        }
        // Insert at beginning case
        if (item.getValue() <= head.next.info.getValue()) {
            // System.out.println("insert beginning case");
            // Tests for dupe
            if (item.getValue() == head.next.info.getValue()) {
                System.out.println("Item already exists");
                return;
            }
            // Add node to beginning
            nodeToAdd.next = head.next;
            head.next = nodeToAdd;
            return;
        }
        NodeType cn = head;
        if (cn.info.getValue() <= item.getValue()) {
            if (cn.info.getValue() == item.getValue()) {
                System.out.println("Item already exists");
                return;
            }
            // System.out.println("adding node at end");
            // Add node to end
            nodeToAdd.next = head.next;
            head.next = nodeToAdd;
            head = nodeToAdd;
            return;
        }
        // Insert in middle
        while (cn.next != head && cn.next.info.getValue() <= item.getValue()) {
            // System.out.println("while loop");
            // System.out.println("inserting in middle");
            if (cn.next.info.getValue() == item.getValue()) {
                System.out.println("Item already exists");
                return; // iterates through rest of LL, kicks out same case
            }
            cn = cn.next;
        }
        nodeToAdd.next = cn.next; // inserting
        cn.next = nodeToAdd;
    } // insertItem

    public void print() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }
        NodeType cn = head.next;
        while (cn != head) {
            System.out.print(cn.info.getValue() + " ");
            cn = cn.next;
        }
        System.out.print(cn.info.getValue());
        System.out.println();
/*
         * System.out.println(head.next.info.getValue());
         * System.out.println(head.next.next.info.getValue());
         * System.out.println(head.info.getValue());
         */
    }

    public void deleteItem(ItemType item) {
        if (head == null) {
            System.out.println("You cannot delete from an empty list");
            return;
        }
        if (head.info.getValue() == item.getValue()) { // delete last cases
            // System.out.println("first if");
            if (head.next == head) {
                head = null;
                return;
            }
            NodeType predloc = head.next; // holds the 2nd to last node
            while (predloc.next != head) {
                predloc = predloc.next;
            }
            predloc.next = head.next; // assigning 2nd to last node to first node for circle
            head = predloc; // reassigning head pointer
            return;
        }
        NodeType currentNode = head;
        while (currentNode.next != head && currentNode.next.info.getValue() < item.getValue()) {
            // System.out.println("inside while");
            currentNode = currentNode.next;

        }
        if (currentNode.next != null && currentNode.next.info.getValue() == item.getValue()) {
            currentNode.next = currentNode.next.next;
            // System.out.println("inside 2nd if");
            return;
        } else {
            System.out.println("The item is not present in the list");
        }
    } // delete2

    public int getLength() {
        if (head == null) {
            return -1;
        }
        int counter = 1;
        NodeType cn = head.next;
        while (cn != head) {
            counter++;
            cn = cn.next;
        }
        return counter;
    } // getLength

    public int searchItem(ItemType item) {
        int counter = 1;
        NodeType cn = head.next;
        if (head == null) {
            System.out.print("List empty");
        }
        while (cn != head) {
            if (cn.info.getValue() == item.getValue()) {
                return counter;
            }
            counter++;
            cn = cn.next;
        }
        if (cn.info.getValue() == item.getValue()) {
            return counter;
        }
        // System.out.println("Item not found");
        return -1;
    } // searchItem

    public void reverse() {
        if (head == null) {
            // System.out.println("The list is empty!");
            return;
        }
        if (head == head.next) {
            return;
        }
        NodeType cn = head.next;
        NodeType prev = head.next;
        NodeType next = cn.next;
        while (cn != head) {
            prev = cn;
            cn = next;
            next = cn.next;
            cn.next = prev;
            /*
            System.out.println("prev: " + prev.info.getValue());
            System.out.println("next: " + next.info.getValue());
            System.out.println("curr: " + cn.info.getValue());
            System.out.println("head: " + head.info.getValue());
            System.out.println("head: " + head.next.info.getValue());
            System.out.println();
            */
        }
        next.next = head;
        head = next;
    } // reverse

    /*
     * public CircularLinkedList deleteSubsection(CircularLinkedList list1, int low,
     * int upp) {
     * NodeType cn = head.next;
     * while (cn != head) {
     * if (cn.info.getValue() <= low || cn.info.getValue() >= upp) {
     * System.out.println("inside delete conditional");
     * list1.deleteItem(new ItemType(cn.info.getValue()));
     * }
     * cn = cn.next;
     * }
     * if (cn.info.getValue() == head.info.getValue()) {
     * System.out.print("asdasd");
     * }
     * return list1;
     * }
     */
}
