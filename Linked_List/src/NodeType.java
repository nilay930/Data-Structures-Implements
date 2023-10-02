public class NodeType {

    ItemType info;
    NodeType next;

    public NodeType(ItemType item){
        this.info = item;
        this.next = null;
    }
}
