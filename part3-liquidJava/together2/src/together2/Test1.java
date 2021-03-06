package together2;

import repair.regen.specification.Refinement;
import repair.regen.specification.RefinementAlias;

@RefinementAlias("Nat(int x) {x >= 0}")
public class Test1 {
	
    /**
    * The sum of all numbers between 0 and n
    * @param n
    * @return a positive value that represents the sum of all numbers between 0 and n, or 0 if n is negative 
    */
    /* Uncomment Below */
    // @Refinement("Nat(_) && _ >= n")
    // public static int sum(int n) {
    //     if(n <= 1)
    //         return 0;
    //     else {
    //         int t1 = sum(n-1);
    //         return n + t1;
    //     }
    // }

}
