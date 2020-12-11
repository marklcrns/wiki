/**
 * Creates Concat class that has a concat function that concatenates two char
 * array parameters and store it in another char array.
 *
 * @author Mark Lucernas
 * Created on 12/07/2020.
 */
public class LucernasAssignment8 {

		public static void main(String[] args) {
				char[] string1 = { 'M', 'a', 'r', 'k' };
				char[] string2 = { 'L', 'u', 'c', 'e', 'r', 'n', 'a', 's' };
				char[] stringConcat = new char[string1.length + string2.length];

				concat(string1, string2, stringConcat);

				System.out.format("%s, %s, %s", new String(string1), new String(string2), new String(stringConcat));
		}

		static void concat(char[] string1, char[] string2, char[] stringConcat) {
				// Add all string1 values into stringConcat
				for (int i = 0; i < string1.length; i++) {
						stringConcat[i] = string1[i];
				}
				// Add all string2 values into stringConcat
				for (int i = 0; i < string2.length; i++) {
						stringConcat[i + string1.length] = string2[i];
				}
		}
}
