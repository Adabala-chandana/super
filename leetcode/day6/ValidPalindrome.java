package day6;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int i = 0;
		int n = s.length() - 1;
		while (i < n) {
			if (s.charAt(i) == s.charAt(n)) {
				i++;
				n--;
			} else
				return false;

		}
		return true;

	}
}
