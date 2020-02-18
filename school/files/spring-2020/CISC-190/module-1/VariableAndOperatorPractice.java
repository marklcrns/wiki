/*
 * Filname: VariableAndOperatorPractice.java
 *
 * Author: Mark Lucernas
 *
 * Date: 2020-02-17
 *
 * Time spent: 01:00:00
 *
 */

public class VariableAndOperatorPractice
{
	public static void main(String[] args) {
		// Step 1
    int firstNumber = 5;
    int secondNumber = 2;

    // Step 2
    int intQuotient = firstNumber / secondNumber;
    System.out.println("S2 INT: Division.                                  | first / second = " + intQuotient);

    // Step 3
    double  doubleQuotient = firstNumber / secondNumber;
    System.out.println("S3 DOUBLE: Division.                               | first / second = " + doubleQuotient);

    // Step 4
    doubleQuotient = (double) firstNumber / secondNumber;
    System.out.println("S4 DOUBLE: Division. First number double casting.  | (double) first / second = " + doubleQuotient);

    // Step 5
    doubleQuotient = (double) (firstNumber / secondNumber);
    System.out.println("S5 DOUBLE: Division. Double casting after result.  | (double) (first / second) = " + doubleQuotient);

    // Step 6
    /*
     * Step 2, although the expected quotient of the two number has a remainder,
     * it only gave the whole number because the type set to the variable was
     * 'int' or integer which is only for whole numbers. Therefore rounding the
     * number as the result, '2'. In contrast, Step 5 gave the same result '2.0'
     * but with a floating point. This happened because the two numbers declared
     * was originally declared as integers. Having to force the division before
     * being casted to double, will result to an integer quotient before
     * converted into a floating point number. Thus, a rounded floating point
     * number.
     *
     * Furthermore, Step 3 has the same effect as Step 5. Executing the result
     * of the two integers and storing it into a 'double' floating point number,
     * is the same as casting a double to an integer result before storing into
     * double variable.
     *
     * Finally, Step 4 produced the correct result because one of the two
     * numbers in the division is a 'double'. Regardless whether the other
     * number was an integer, it will always treat both numbers as floats.
     */
  } }
