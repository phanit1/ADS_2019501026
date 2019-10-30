final class Solution {
	private Solution() { }
	public static String isMatching(final String str) {
		String[] brackets = new String[str.length()];
		brackets = str.split("");
		String[] stack = new String[str.length()];
		int size = 0;
		for (String eachBracket : brackets) {
			if (eachBracket.equals("[")
			|| eachBracket.equals("(") || eachBracket.equals("{")) {
				stack[size++] = eachBracket;
			} else if (size > 0) {
				String recentBracket = stack[size - 1];
				if (recentBracket.equals("[")
				&& eachBracket.equals("]")) {
					size--;
				} else if (recentBracket.equals("(")
				&& eachBracket.equals(")")) {
					size--;
				} else if (recentBracket.equals("{")
				&& eachBracket.equals("}")) {
					size--;
				}
			}
		}
		if (size == 0) {
			return "YES";
		} else {
			return "NO";
		}
	}
}
