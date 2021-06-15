

public class Method {
    /**
     * Returns a value within the range
     *
     * @param a
     * 		The minimum border
     * @param b
     * 		The maximum border, greater than a
     * @return A value in the interval [a, b] (including the border values)
     */
    public static int inRange(int a, int b) {
        return a + 1;
    }

    public static void main(java.lang.String[] args) {
        Method.inRange(10, 11);// Correct

        Method.inRange(10, 9);// Error

    }
}

