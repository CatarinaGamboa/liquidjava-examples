package together2;


/**
 * The sum of all numbers between 0 and n
 *
 * @param n
 * 		
 * @return a positive value that represents the sum of all numbers between 0 and n
 */
/* Uncomment Below */
// @Refinement("Nat(_) && _ >= n")
// public static int sum(int n) {
// if(n <= 1)
// return 0;
// else {
// int t1 = sum(n-1);
// return n + t1;
// }
// }
@repair.regen.specification.RefinementAlias("Nat(int x) {x >= 0}")
public class Test1 {}

