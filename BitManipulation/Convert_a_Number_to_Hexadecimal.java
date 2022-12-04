package BitManipulation;

/**
 * 405. Convert a Number to Hexadecimal
 */

/**
Basic idea: each time we take a look at the last four digits of
            binary verion of the input, and maps that to a hex char
            shift the input to the right by 4 bits, do it again
            until input becomes 0.
*/


/**
 Converting a decimal number to a hex number is straightforward: we extract the lowest 4 bit(using n & 15),
 convert that extracted number to hex, and right shift the original number by 4 bits. When the remaining part is 0, the job is done.
 PO's program does exactly that.
 */

/**
 15 decimal is 1111 in binary. By anding (&) 1111 and the input number, you basically get the last 4 binary digits of the input number.

 e.g. input number is decimal 33. In binary 33 is 0010 0001. So, 0010 0001 & 0000 1111 = 0000 0001.
 See how we got only the last 4 digits of the input number? Hope this explains.
 */

/**
 15 replace 0x0F
 */

/**
 The while loop would be executed at most 32/4=8 times, so I think the time complexity is O(1), even it's 64 bit integer, still O(1).
 **/

/**
 What is the difference between >>> and >> operators in Java?

 '>>' is arithmetic shift right, >>> is logical shift right.

 In an arithmetic shift, the sign bit is extended to preserve the signedness of the number.

 For example: -2 represented in 8 bits would be 11111110 (because the most significant bit has negative weight).
 Shifting it right one bit using arithmetic shift would give you 11111111, or -1. Logical right shift, however, does not care that the value could possibly represent a signed number;
 it simply moves everything to the right and fills in from the left with 0s. Shifting our -2 right one bit using logical shift would give 01111111.

 '>>>' will always put a 0 in the left most bit, while >> will put a 1 or a 0 depending on what the sign of it is.
 */

public class Convert_a_Number_to_Hexadecimal {


    private final char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public String toHex(int num) {
        if(num == 0) return "0";
        StringBuilder result = new StringBuilder();
        while(num != 0){
            int n = num & 15;
            result.insert(0, map[n]);
            num = (num >>> 4);
        }
        return result.toString();
    }

    // Do { } while() is your friend. It eliminates the special case for 0
    public String toHex2(int num) {
        StringBuilder sb = new StringBuilder();
        do {
            int n = num & 15;
            n += n < 0xa ? '0' : 'a' - 10;
            sb.append((char)n);
        } while ((num >>>= 4) != 0);
        return sb.reverse().toString();
    }

}
