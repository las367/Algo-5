package Algo5.hashing;

public class HashArray {
    
    private class Item {

        int key = Integer.MIN_VALUE;
        boolean markAsDeleted = false;

        public Item (int key) {

            super();
            this.key = key;
        }
    }

    private Item[] hashArray;
    private int size;


    public HashArray (int size) {
        super();
        this.size = size;
        this.hashArray = new Item[size];
    }

    public boolean isMarkAsDeleted (int index) {
        return hashArray[index].markAsDeleted;
    }

    public boolean compareKeys (int index, int key) {
        return hashArray[index].key == key;
    }

    public boolean isInsertable (int index) {

        return hashArray[index] == null;
    }

    public boolean isFree (int index) {

        return hashArray[index] == null; 
    }

    public int get (int index) {

        return hashArray[index].key;
    }

    public void set (int index, int key) {

        hashArray[index] = new Item(key);
    }

    public void remove (int index) {

        hashArray[index].key = Integer.MIN_VALUE;
        hashArray[index].markAsDeleted = true;
    }

    public void clear() {

        this.hashArray = new Item[size];
    }


    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("[");
        for ( Item item : hashArray ) {
            if ( item == null ) builder.append("** ");
            else builder.append(item.markAsDeleted ? "## " : item.key + " ");
        }
        builder.append("]");

        return builder.toString();
    }

}