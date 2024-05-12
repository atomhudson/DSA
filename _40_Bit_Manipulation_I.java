public class _40_Bit_Manipulation_I {
    public static void main(String[] args) {
        System.out.println(25 >> 1);
        System.out.println(2 ^ 3);
    }
}
// BitWise Operator

//1. AND
//      a   |   b   | a & b
//----------|-------|--------
//      0   |   0   |   0
//      0   |   1   |   0
//      1   |   0   |   0
//      1   |   1   |   1
// when you AND 1 with any number, digit remain same

//ex:       1   1   0   0   1   0   1   0   0
//        & 1   1   1   1   1   1   1   1   1
//       ----------------------------------------
//          1   1   0   0   1   0   1   0   0
//       ----------------------------------------


//2. OR (|)
//      a   |   b   | a OR b
//----------|-------|--------
//      0   |   0   |   0
//      0   |   1   |   1
//      1   |   0   |   1
//      1   |   1   |   1
//  Anyone is true, then it is true

//3. XOR (^) ( if and only if)
//      a   |   b   | a ^ b
//----------|-------|--------
//      0   |   0   |   0
//      0   |   1   |   1
//      1   |   0   |   1
//      1   |   1   |   0
//  Only have to be true only.
// a ^ a = 0
// a ^ 0 = 0
// a ^ 1 = complement of a

// 4. Complement ( ~ )
//               a =  1  0  1   1   0
// complement of a =  0  1  0   0   1

//  5.Left Shift Operator ( << )
//  (10)base10 = (1010)base2    10 << 1
//  Step 1: Computer convert 10 into binary 1010 << 1 = 1 0 1 0 0 = (20)base10.
//  It the shift the binary digit by one position toward left.
//  Basically: a << 1 = 2a.
//  General Point: a << b = a * (2^b);

// 6.Right Shift Operator ( >> )
//    0011001 >> 1 = 001100
//         25 >> 1 = 12
// General: a >> b = a / (2^b);


// Number Systems

//  1. Decimal ---> 0,1,2,3,4......,9        Base 10.

//  2. Binary ----> 0 & 1                    Base 2.
//        (10)base2 = (1010)base2
//         (7)base2 = (111)base2

//  3. Octal -----> 0,1,2,3,4........,7      Base 8.
//          0,1,2,3,4,5,6,7,  8, 9,  10, 11, 12, 13, 14, 15, 16 ( Base 10 )
//          0,1,2,3,4,5,6,7, 10, 11, 12, 13, 14, 15, 16, 17, 20 ( Base 8 )
//          (8)base10 = (10)base8
//          (9)base10 = (11)base8

// 4.  Hexadecimal ----> 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F      Base 16.
//          (10)base10 = (A)base16

//  Conversion
// 1.   Decimal to Base b.
//      Q. Convert (17)base10 to Base2.
//   Soln: Keep dividing by base, take remainders write in opposite.
//          2|17       1
//          2|8        0
//          2|4        0
//          2|2        0
//                     1
//      (17)base10 = (10001)base2.

// 2.   Base b to Decimal.
//      Multiply & add the power of base with digits.
//      Q: Convert any base(b) to Decimal.
//          (10001)base2 = ( ? ) base 10.
//   Soln:  1 * 2^4  +  0 * 2^3  +  0 * 2^2  +  0 * 2^1  +  1 * 2^0
//          1 * 16   +    0      +    0      +    0      +  1 * 1
//              16   +    0      +    0      +    0      +    1
//                       (10001)base2 = (17)base10.




