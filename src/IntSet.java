import java.util.Arrays;
import java.util.Random;

/**
 * A class to hold a set of data for practice
 */
public class IntSet {
    int[] array;
    Random rand = new Random();

    //***** constructors *****

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

    //***** Methods *****

    /**
     * if this is empty return input, if input empty return this
     * if both are populated look for doubles and merge them in to a new set
     * @param setB The set you want to union with this
     * @return The set that is either A - the input - a combination of the 2
     */
    public IntSet union(IntSet setB){
        // if they are both empty return a new instance
        if (setB.isEmpty() && isEmpty()) {
            return new IntSet(1);
        }
        // if this is empty return B and return A if B is empty
        if (isEmpty()) { return setB; }
        if (setB.isEmpty()) { return this;}
        // Otherwise make a new set and merge them

        // Make an array to mark doubles and compare B
        boolean[] doubles = new boolean[array.length];
        for( int i = 0 ; i < array.length ; i++){
            if(setB.hasElement(array[i])){
               doubles[i] = true;
            }
        }

        // count the doubles
        int doubleCount = 0;
        for(boolean d : doubles){
            if(d){doubleCount++;}
        }

        // Make a new array of length this + setB - doubles and track index
        int newSize = array.length + setB.array.length - doubleCount;
        int[] newArray = new int[newSize];
        int arrayIndex = 0;

        // for all non double in this set copy to new array and incriment index of new
        for(int i = 0 ; i < doubles.length ; i++){
            if(!doubles[i] && array[i] != 0){
                newArray[arrayIndex] =  array[i];
                arrayIndex++;
            }
        }

        // For all in set b just copy them
        for(int i : setB.array){
            newArray[arrayIndex] = i;
            arrayIndex++;
        }

        // return the new IntSet with the new array in it
        return new IntSet(newArray);
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


