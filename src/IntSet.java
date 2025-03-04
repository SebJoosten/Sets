import java.util.Arrays;
import java.util.Random;

/**
 * A class to hold a set of data for practice
 */
public class IntSet {
    int[] array;
    Random rand = new Random();

    /**
     * Constructor for this set
     * Populates the array with random numbers for testing
     * @param inArray An array of integers to initialise this set
     */
    public IntSet(int [] inArray){
        array = inArray;
    }

    /**
     * A constructor to add a random array set for practice ARRAY
     * @param s is the length of the array set in this instance
     */
    public IntSet(int s){
        array = new int[s];
        for( int i = 0 ; i < array.length ; i++){
            array[i] = rand.nextInt(1 , 10);
        }
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

    /**
     * This checks if the input element is contained with in the set
     * @param i the element you want to look for
     * @return true if element contained otherwise false
     */
    public boolean hasElement(int i){
        for (int j :array){
            if (j == i){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the element is in the array
     * @param i The element you want for in this instance
     * @return True if added and false if already contained
     */
    public boolean addElement(int i){
        if (hasElement(i)) {
            return false; // If the element already exists
        } else {
            // resize and add element to end
            int[] newArray = Arrays.copyOf(array, array.length + 1);
            newArray[array.length] = i;
            array = newArray;
            System.out.println("Added " + i + " to set");
            return true;
        }
    }

    /**
     * This removes a given element from this IntSet instance
     * @param i The element you want to look for in this instance
     * @return returns true if element was removed, false if not contained
     */
    public boolean removeElement(int i){
        if(hasElement(i)){
            for(int j = 0; j < array.length; j++){  // Find the element top removes location
                if(array[j] == i) {
                    for(int k = j; k < array.length - 1; k++){  // Shift remaining elements over by 1
                        array[k] = array[k+1];
                    }
                    array[array.length - 1] = 0;    // Replace end element with 0
                    break;
                }
            }
            return true;
        }
        return false;
    }


} // END IntSet class


