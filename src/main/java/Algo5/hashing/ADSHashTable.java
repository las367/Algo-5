package Algo5.hashing;

import Algo5.hashing.hash.IHash;
import Algo5.hashing.probing.IProbing;

public class ADSHashTable {
    
    private int size;
    private IHash hashAlgorithm;
    private IProbing probingAlgorithm;
    private HashArray hashArray;

    private boolean debug = false;

    private static final String sExceptionNoSpaceFree = "No free space in hash table for key '%d'!";
    private static final String sMsgKeyInsertAt = "Key '%d' inserted at index '%d'";
    private static final String sMsgCollision = "Increment collision counter j++ -> %d : [index=%d, key=%d]";
    private static final String sMsgMarkedAsDeleted = "Key '%d' marked as deleted at index '%d'";
    private static final String sExceptionKeyNotFound = "Key '%d' not found in hash table";

    public ADSHashTable(int size, IHash hashAlgorithm, IProbing probingAlgorithm) {
        super();
        this.size = size;
        this.hashAlgorithm = hashAlgorithm;
        this.probingAlgorithm = probingAlgorithm;
        this.hashArray = new HashArray(size);
    }


    void insert (int key) throws Exception {

        //collision counter
        int j = 0,
            addr = 0,
            hashValue = hashAlgorithm.hash(key);

        do {

            addr = calculateIndex(hashValue, key, j);
            if ( hashArray.isInsertable(addr) || hashArray.isMarkAsDeleted(addr) ) {

                hashArray.set(addr, key);
                // debug( String.format( sMsgKeyInsertAt, key, addr ) );
                return;
            }

            j++;
            // debug( String.format(sMsgCollision, j, addr, hashArray.get(addr)) );

        } while ( j < size );
    
        throw new Exception( String.format( sExceptionNoSpaceFree, key ));
    }

    void remove (int key) throws Exception {

        int j = 0,
            addr = 0,
            hashValue = hashAlgorithm.hash(key);

        do {

            addr = calculateIndex(hashValue, key, j);
            if ( hashArray.isFree(addr) ) break;

            if ( hashArray.compareKeys(addr, key) ) {

                hashArray.remove(addr);
                // debug( String.format(sMsgMarkedAsDeleted, key, addr) );
                return;
            }

            j++;
            // debug( String.format(sMsgCollision, j, addr, hashArray.get(addr)) );

        } while ( j < size );

        throw new Exception( String.format(sExceptionKeyNotFound, key) );
    }

    int search (int key) throws Exception {
        
        int j = 0,
            addr = 0,
            hashValue = hashAlgorithm.hash(key);

        do {

            addr = calculateIndex(hashValue, key, j);
            if ( hashArray.isFree(addr) ) break;
            if ( hashArray.compareKeys(addr, key) ) return addr;

            j++;
            // debug( String.format(sMsgCollision, j, addr, hashArray.get(addr)) );

        } while ( j < size );
        
        throw new Exception(String.format(sExceptionKeyNotFound, key));
    }

    int get (int key) throws Exception {
        
            int index = search(key);
            return hashArray.get(index);
    }

    void clear () {
        this.hashArray.clear();
    }

    private int calculateIndex (int hashValue, int key, int j) {
        return Math.floorMod( hashValue - probingAlgorithm.probe(key, j), size );
    }

    @Override
    public String toString () {

        StringBuilder builder = new StringBuilder();

        builder.append(hashAlgorithm.toString());
        builder.append(" method with: ");

        builder.append(probingAlgorithm.toString());

        builder.append(" - HashTable: ");
        builder.append(hashArray);

        return builder.toString();
    }

    void debug (String s) {

        if ( debug ) {

            System.out.println(" " + s);
            System.out.flush();
        }
    }
    
}