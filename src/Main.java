import java.util.Arrays;

/**
    * This is a quick demonstration of basic set handling for JAVA
    * Attempt 1
    * <p>
    * Main class that calls the set functions
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("This is a sets test");

        IntSet set = new IntSet(5);
        set.print();

        isEmpty(set);

        hasElement(set, 1);

        boolean temp = set.addElement(9);

        set.print();
    }



    /**
     * Looks through the intSet instance for the element
     * @param set The intSet instance you want to look through
     * @param i The element your looking for
     */
    public static void hasElement(IntSet set, int i){
        if (set.hasElement(i)) {
            System.out.println("Set contains " + i);
        }
        else {
            System.out.println("Set does not contain " + i);
        }
    }

    /**
     * Prints out whether the input IntSet Set contains data or not
     * @param set The IntSet instance you wish to check
     */
    public static void isEmpty(IntSet set){
        if (set.isEmpty()) {
            System.out.println("Set is empty");
        }
        else {
            System.out.println("Set is not empty");
        }
    }


} // END Main
