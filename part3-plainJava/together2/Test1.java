public class Test1 {
    /**
    * Computes the fibonacci of index n
    * @param n The index of the required fibonacci number
    * @return The fibonacci nth number. The fibonacci sequence follows the formula Fn = Fn-1 + Fn-2 and has the starting values of F0 = 1 and F1 = 1 
    */
    /*Uncomment Below*/
    public static int fibonacci(int n){
        if(n <= 0)
            return 0;
        else
            return n * fibonacci(n-1);
    }

}
