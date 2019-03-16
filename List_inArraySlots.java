/**
  Implement a list of diverse types, including
  integers, double-precision floating point numbers,
  and Strings.
 */

public class List_inArraySlots {
    private Object[] list = new Object[5];
    private static final int INITIAL_CAPACITY = 10;
    private int filledElements;
    /**
      Construct an empty list with a small initial capacity.
     */

    public List_inArraySlots() {
         list = new Object[5];
         filledElements = 0;
    }


    /**
      @return the number of elements in this list
     */
     public int size() {
           return filledElements;
     }


     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
     public String toString() {
       String output = "[";
       for (int i = 0; i < filledElements; i++) {
           output += list[i] + ",";
        }
        return output + "]";
     }



    /**
      Appends @value to the end of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( Object input){
        // expand when at max
        if (filledElements == list.length) expand();
        
        // create new instance using param and add 
        list[filledElements] = input;

        // update size
        filledElements++;

        return true;
     }


    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data.
     */
      private void expand() {
          System.out.println( "expand... (for debugging)");
          Object[] storage = list; //store old list
          list = new Object[2 * filledElements]; //create new list
          for(int i = 0; i < filledElements; i++){ //repopulate with old values
            list[i] = storage[i];
          }
      }
      public Object get(int index){
          return list[index];
      }
}
