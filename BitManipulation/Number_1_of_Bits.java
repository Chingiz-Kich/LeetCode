/**
 * 191. Number of 1 Bits
 *
 * As we need to count number of 1 bits...
 * Ex: 13 --> 000000000001011 --> 1011
 *
 * -----------------------------------------------------------------------
 *
 * SOLUTION 1:
 * An Integer in Java has 32 bits, e.g. 00101000011110010100001000011010
 * To count the 1s in the Integer representation we put the input 'int n' in bitwise operator AND with 1 --> n & 1
 * (that is represented as 00000000000000000000000000000001, and if this operation result is 1,
 * that means that the last bit of the input integer is 1. Thus we add it to the 1s count.
 *
 * Ex: 0000000000001011 & 000000000000001 ---> 1011 & 1
 *
 * -----------------------------------------------------------------------
 *
 * SOLUTION 2:
 * In the binary representation, the least significant 1-bit  in n always correspond to a 0 bit in n-1.
 * Therefore, anding the two numbers n and n-1 always flips significant 1-bit in n to 0, and keeps all other bits the same.
 *
 * Ex: 1011 & 1010 (sum = 1) -->  1010 &  1001 (sum = 2) --> 1000 & 0111 (sum = 3) --> 0000
 *
 */


SOLUTION 1:
public static int hammingWeight(int n) {
    int ones = 0;
    while(n!=0) {
        int cheZa = n & 1;
        ones = ones + cheZa;
        n = n>>>1;
    }
    return ones;
}


SOLUTION 2:
public int hammingWeight(int n) {
    int sum = 0;
    while (n != 0) {
        n &= (n - 1);
        sum++;
    }
    return sum;
}