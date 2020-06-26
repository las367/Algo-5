package Algo5.hashing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import Algo5.hashing.hash.Hash;
import Algo5.hashing.probing.QuadraticProbing;

public class HashWithQuadraticProbingTest {

        // public ADSHashTable(int size, IHash hashAlgorithm, IProbing probingAlgorithm) ;
        int htSize = 13;
        ADSHashTable hashTable = new ADSHashTable( htSize, new Hash(htSize), new QuadraticProbing() );
        int indexOf0 = 0;
        int indexOf13 = 12;
        int indexOf26 = 1;
        
        @Test 
        public void TestInsert () throws Exception {

                hashTable.insert(0);

                assertEquals( "key 0 should be at index 0", indexOf0, hashTable.search(0) );
        }

        @Test
        public void TestInsertWithCollison () throws Exception {

                hashTable.insert(0);
                hashTable.insert(13);
                hashTable.insert(26);

                assertEquals("key 13 should be at index 12", indexOf13, hashTable.search(13));
                assertEquals("key 26 should be at index 1", indexOf26, hashTable.search(26));
        }

        @Test 
        public void TestGet () throws Exception {

                hashTable.insert(0);
                hashTable.insert(13);

                assertEquals("HT should return the expected element", 13, hashTable.get(13));
        }

        @Test 
        public void TestClear () throws Exception {
                
                hashTable.insert(0);
                hashTable.clear();

                boolean isCleared = false;
                try {
                        hashTable.search(0);
                } catch (Exception e) {
                        isCleared = true;
                }

                assertTrue("Hash table should be cleared", isCleared);
        }

        @Test 
        public void TestRemoveAndReinsert () throws Exception {

                hashTable.insert(0);
                hashTable.remove(0);

                boolean notFound = false;

                try {
                        hashTable.search(0);
                } catch (Exception e) {

                        notFound = true;
                }

                assertTrue("Key 0 should not be found", notFound);

                hashTable.insert(13); // reinsert
                assertEquals( "key 13 should now at index 0", indexOf0, hashTable.search(13) );
        }
}