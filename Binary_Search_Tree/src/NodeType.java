public class NodeType {
    public ItemType info;
    public NodeType left;
    public NodeType right;

    public NodeType(ItemType item){
        this.info = item;
        this.left = null;
        this.right = null;
    }

}
