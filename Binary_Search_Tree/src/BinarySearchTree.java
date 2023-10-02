public class BinarySearchTree {
    private NodeType root;

    public BinarySearchTree() {
        // tree = new NodeType(null);
    } // BST Constructor

    public void insert(ItemType key) {
        root = insertHelper(root, key);
    } // insert

    public NodeType insertHelper(NodeType tree, ItemType key) {
        NodeType keyNode = new NodeType(key);
        
        if (retrieve(key) == true) {
            System.out.println();
            System.out.print("The item already exists in the tree.");
            return tree;
        }
        if (tree == null) {
            tree = keyNode;
            return tree;
        } // creating tree value

        if (tree.info.getValue() > keyNode.info.getValue()) {
            tree.left = insertHelper(tree.left, key);
        }
        if (tree.info.getValue() < keyNode.info.getValue()) {
            tree.right = insertHelper(tree.right, key);
        }
        return tree;
    } // insertHelper

    public void inOrder() {
        inOrderHelper(root);
    } // inOrder call

    public void inOrderHelper(NodeType tree) {
        if (tree != null) {
            inOrderHelper(tree.left);
            System.out.print(tree.info.getValue() + " ");
            inOrderHelper(tree.right);
        }
    } // inOrderHelper

    public void delete(ItemType key) {
        root = deleteHelper(root, key);
    } // delete

    public NodeType deleteHelper(NodeType tree, ItemType key) {
        NodeType item = new NodeType(key);
        if (retrieve(key) == false) {
            System.out.print("The number is not present in the tree");
            System.out.println();
            return tree;
        }
        if (item.info.getValue() < tree.info.getValue()) {
            tree.left = deleteHelper(tree.left, key); 
        } // left 
        else if (item.info.getValue() > tree.info.getValue()) {
            tree.right = deleteHelper(tree.right, key);
        } // right
        else {
            if (tree.left == null && tree.right == null) {
                tree = null;
            } // leaf node case
            else if (tree.left != null && tree.right != null) {
                ItemType tree2 = findPred(tree.left);
                // System.out.println(tree2.getValue());
                tree.info = tree2;
                tree.left = deleteHelper(tree.left, tree2);   
            }
            else if (tree.left != null && tree.right == null){
                return tree.left;
            }
            else if (tree.left == null && tree.right != null) {
                return tree.right;  
            }
        } // other cases

        return tree;
    } // deleteHelper
    public ItemType findPred(NodeType tree) {
        while(tree.right != null) {
            tree = tree.right;
        }
        ItemType tree2 = new ItemType(tree.info.getValue());
        return tree2;
    } // findpred

    public boolean retrieve(ItemType item) {
        boolean found = retrieveHelper(root, item);
        return found;
    }
    public boolean retrieveHelper(NodeType tree, ItemType item) {
        NodeType target = new NodeType(item);
        if (tree == null){ 
            return false;
        }
        else if (tree.info.getValue() == target.info.getValue()) {
            return true;
        }
        else if (target.info.getValue() < tree.info.getValue()) {
            return retrieveHelper(tree.left, item);
        }
        else {
            return retrieveHelper(tree.right, item);
        }
    } // retrieve

    public int getNumLeafNodes() {
        int numleafs = getNumLeafNodesHelper(root);
        return numleafs;
    } // inOrder call
    public int getNumLeafNodesHelper(NodeType tree) {
        if (tree == null) {
            return 0;
        }
        if (tree.left == null && tree.right == null) {
            return 1;
        }
        else {
            int total = getNumLeafNodesHelper(tree.left) + getNumLeafNodesHelper(tree.right);
            return total;
        }
    } // getNumLeafNodes

    public void getSingleParent() {
        getSingleParentHelper(root);
    } // inOrder call
    public void getSingleParentHelper(NodeType tree) {
        if (tree == null) {
            return;
        }
        if ((tree.left == null && tree.right != null) 
            || (tree.left != null && tree.right == null)) {
            System.out.print(tree.info.getValue() + "  ");
        }
        else {
            getSingleParentHelper(tree.left);
            getSingleParentHelper(tree.right);
        }
    } // getNumLeafNodes     

    public NodeType findParentHelper(ItemType num) {
        return findParent(root, num);
    }
    public NodeType findParent(NodeType tree, ItemType num) {
        NodeType item = new NodeType(num);
        if (tree == null || (tree.info.getValue() == item.info.getValue())) {
            return null; // no parents, no tree and is root
        }
        NodeType parent = null;
        NodeType iter = tree;
        while (iter != null) {
            if (item.info.getValue() < iter.info.getValue()) {
                parent = iter;
                iter = iter.left;
            } else if (item.info.getValue() > iter.info.getValue()) {
                parent = iter;
                iter = iter.right;
            } else {
                //System.out.println(parent.info.getValue());
                return parent;
            }
        }
        //System.out.println(parent.info.getValue());
        return parent;
    } // findParents

    public void cousinPrinter(NodeType tree, ItemType num) {
        if (tree == null) {
            return;
        }
      
        NodeType up1 = findParent(tree, num);
        ItemType num2 = new ItemType(up1.info.getValue());
        NodeType up2 = findParent(tree, num2);
        int gparents = up2.info.getValue();
        /*
        System.out.println("checkpt");
        System.out.println(up2.info.getValue());
        System.out.println(num.getValue());
        */
        if (gparents == num.getValue()) {
            return;
        }
        if (gparents > num.getValue()) {
            if(up2.right != null) {
                if (up2.right.left != null) {
                    System.out.print(up2.right.left.info.getValue());
                }
                System.out.print(" ");
                if (up2.right.right != null) {
                    System.out.print(up2.right.right.info.getValue());
                }
            }
            // System.out.println("num on left");
        }
        if (gparents < num.getValue()) {
            if(up2.left != null) {
                if (up2.left.right != null) {
                    System.out.print(up2.left.right.info.getValue());
                }
                System.out.print(" ");
                if (up2.left.left != null) {
                    System.out.print(up2.left.left.info.getValue());
                }
            }
            //System.out.println("num on right");
        }
        System.out.println();
    } // cousin Printer

    public void getCousins(ItemType key) {
        cousinPrinter(root, key);
    } // getCousins


}
