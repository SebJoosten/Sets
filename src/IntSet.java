import java.util.Arrays;

/**
 * A class to hold a set of data for practice
 */
public class IntSet {
    int[] array;

    /**
     * Constructor for this set
     * @param s is the size of the array in this set
     */
    public IntSet(int s){
        array = new int[s];
    }

    /**
     * Prints the current array in this set
     */
    public void print(){
        System.out.println(Arrays.toString(array));
    }

    /**
     * Checks to see if the set has data in it other-then 0
     * @return If set contains data
     */
    public boolean isEmpty(){
        // Another way of doing a for loop like for each
        for (int j : array) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

} // END IntSet class


