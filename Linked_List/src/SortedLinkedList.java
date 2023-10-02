public class SortedLinkedList {
    private NodeType head;

    public SortedLinkedList() {
        // head = new NodeType(null);
    }

    public void insertItem(ItemType item) {
        NodeType nodeToAdd = new NodeType(item);
        if (head == null) {
            // System.out.println("create node");
            head = nodeToAdd; // makes the first node in LL
            return;
        }
        if (head.info.getValue() == item.getValue()) {
            System.out.println("Item already exists"); // handles head case repeat
            return;
        }
        if (item.getValue() < head.info.getValue()) {
            // System.out.println("new head");
            nodeToAdd.next = head; // new start node
            head = nodeToAdd;
            return;
        }
        NodeType currentNode = head;
        if (currentNode.next != null && currentNode.next.info.getValue() == item.getValue()) {
            System.out.println("Item already exists");
            return; // handles same case and kicks out
        }
        while (currentNode.next != null && currentNode.next.info.getValue() <= item.getValue()) {
            // System.out.println("while loop");
            if (currentNode.next.info.getValue() == item.getValue()) {
                return; // iterates through rest of LL, kicks out same case
            }
            currentNode = currentNode.next;
        }
        nodeToAdd.next = currentNode.next; // inserting
        currentNode.next = nodeToAdd;
    } // insertItem

    public void deleteItem(ItemType item) {
        if (head == null) {
            System.out.println("You cannot delete from an empty list");
            return;
        } else if (head.info.getValue() == item.getValue()) {
            // System.out.println("delete first value");
            head = head.next; // special case for deleting first value
            return;
        }
        NodeType currentNode = head;
        while (currentNode.next != null && currentNode.next.info.getValue() < item.getValue()) {
            // System.out.println("Node val: " + currentNode.next.info.getValue() + "<" +
            // item.getValue());
            currentNode = currentNode.next;
        }
        if (currentNode.next != null && currentNode.next.info.getValue() == item.getValue()) {
            // System.out.println("Node final: " + currentNode.next.info.getValue());
            currentNode.next = currentNode.next.next;
            return;
        } else {
            System.out.println("Item not found");
        }
    } // delete2

    public int getLength() {
        int counter = 0;
        NodeType currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.next;
            counter++;
        }
        return counter;
    } // getLength

    public int searchItem(ItemType item) {
        int counter = 1;
        NodeType currentNode = head;
        //
        while (currentNode != null) {
            // System.out.print("Find:" + currentNode.info.getValue() + " " +
            // item.getValue());
            if (currentNode.info.getValue() == item.getValue()) {
                // System.out.println("FOUND U");
                return counter;
            }
            counter++;
            currentNode = currentNode.next;
        }
        System.out.println("Item not found");
        return -1;
    } // search2

    public void printer() {
        NodeType currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.info.getValue() + " ");
            currentNode = currentNode.next;
        }
        System.out.println("");
    } // insertItem

    public void deleteAlt() {
        NodeType cn = head;
        if (cn == null) {
            System.out.println("List is empty");
            return;
        } else if (cn.next == null) {
            return;
        } else if (cn.next.next == null) {
            cn.next = null;
        } else {
            while (cn != null && cn.next != null) {
                cn.next = cn.next.next;
                cn = cn.next;
            }
        }
    } // delete alt

    public SortedLinkedList mergeList(SortedLinkedList list1, SortedLinkedList list2) {
        NodeType cn2 = list2.head;
        while (cn2 != null) {

            list1.insertItem(new ItemType(cn2.info.getValue()));
            cn2 = cn2.next;
        }
        return list1;
    } // mergeList

}
