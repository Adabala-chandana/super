package day4;

class ZeroFilledSubArray {
	public long zeroFilledSubarray(int[] nums) {
		long previousCount = 0;
		long totalCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				previousCount = previousCount + 1;
				totalCount = totalCount + previousCount;
			} else {
				previousCount = 0;
			}

		}
		return totalCount;

	}
}
