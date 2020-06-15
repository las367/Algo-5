package Algo5.hashing;

public class HashInvoker {

        private static final String sMsgRemoveKey = "Remove key '%d' from hash table";
        private static final String sMsgSearchForKey = "Search for key '%d' in the hash table";
        private static final String sMsgSearchKeyFound = "Key found at index '%d'";
        
        static void insert (ADSHashTable table, int key) {

                try {

                       table.insert(key);
                       print( table.toString() );

                } catch (Exception ex) {
                        flush(ex);
                }
        }

        static void search (ADSHashTable table, int key) {

                try {

                        print( String.format(sMsgSearchForKey, key) );
                        print( String.format(sMsgSearchKeyFound, table.search(key)) );

                } catch (Exception ex) {
                        flush(ex);
                }
        }

        static void remove(ADSHashTable table, int key) {

                try {
                        print(String.format(sMsgRemoveKey, key));
                        table.remove(key);
                        print(table.toString());

                } catch (Exception ex) {
                        flush(ex);
                }
        }

        private static void flush (Exception ex) {

                System.out.flush();
                System.err.println(ex.getMessage());
                System.err.flush();
        }

        private static void print (String str) {

                System.out.println(str);
                System.out.flush();
        }
}