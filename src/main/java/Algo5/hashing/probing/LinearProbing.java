package Algo5.hashing.probing;

public class LinearProbing implements IProbing {

    @Override
    public int probe (int key, int j) {
        return j;
    }
    
    @Override
    public String toString () {
        return "Linear Probing";
    }
}