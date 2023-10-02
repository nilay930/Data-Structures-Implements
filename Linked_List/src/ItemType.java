public class ItemType {
    private int value;

    public ItemType(int num) {
        this.value = num;
    }

    /*
     * Compares the value of item with the current object's value and
     * return -1 if value of the current object is less than value in item ,
     * 0 if equal and 1 if greater.
     */
    public int compareTo(ItemType item) {
        if (value < item.getValue()) {
            return -1;
        }
        if (value > item.getValue()) {
            return 1;
        }
        else {
            return 0;
        }
        //int compareTemp = item.getValue;
        //      return value.compareTo(compareTemp);

    } // compareTo
    /*
     * Returns the value instance variable
     */
    public int getValue() {
        return value;
    } // getValue

    /*
     * Initializes the data member by variable number
     */
    public void intialize(int num) {
        this.value = num;
    } // initialize

}
