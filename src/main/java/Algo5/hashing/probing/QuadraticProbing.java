package Algo5.hashing.probing;

public class QuadraticProbing implements IProbing {

	@Override
	public int probe (int key, int j) {
                
                return (int) Math.pow( (int) Math.ceil( (double) j / 2 ), 2 ) * (int) Math.pow(-1, j + 1);
	}
        
        @Override
        public String toString () {
                return "Quadratic Probing";
        }
}