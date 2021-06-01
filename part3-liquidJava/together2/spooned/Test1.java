

@repair.regen.specification.RefinementAlias("Nat(int x) {x >= 0}")
public class Test1 {
    /**
     * The sum of all numbers between 0 and n
     *
     * @param n
     * 		
     * @return a positive value that represents the sum of all numbers between 0 and n
     */
    @repair.regen.specification.Refinement("Nat(_) && _ >= n")
    public static int sum(int n) {
        if (n <= 1)
            return 1;
        else {
            int t1 = Test1.sum((n - 1));
            return n + t1;
        }
    }
}

