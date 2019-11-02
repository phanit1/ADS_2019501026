/**.
 * This is used to match the same type of paranthesis by using stack operations.
 * @author Phaneendhar
 */
import java.util.*;
final class Solution {
	/**
	 * This is used to perform operations of stack and to find the matching of paranthesis.
	 * @param str , str is the string of paranthesis which is the main input
	 * @return yes if the brackets match or no if brackets donot match
	 */
	public static String isMatching(String str) {
		char[] brackets = str.toCharArray();
		int length = brackets.length;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < length; i++) {
			/**.
			 * if brackets are { or ( or [ then it pushes into stack
			 */
			if (brackets[i] == '(' || brackets[i] == '[' || brackets[i] == '{') {
				stack.push(brackets[i]);
			}
			/**.
			 * if brackets are } or ) or ] then it pops from stack
			 */
			if (brackets[i] == ')' || brackets[i] == ']' || brackets[i] == '}') {
				if(stack.empty() == true) {
					return "NO";
				}
				stack.pop();
			}
		}
		if (stack.empty() == true) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
}
		
	