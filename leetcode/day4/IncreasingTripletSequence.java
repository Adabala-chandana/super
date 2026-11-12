package day4;

public class IncreasingTripletSequence {
		   public boolean increasingTriplet(int[] nums) {
				int first = Integer.MAX_VALUE;
					int second = Integer.MAX_VALUE;
					boolean triplet = false;
					for (int n = 0; n < nums.length; n++) {
		            if (nums[n] <= first) {
		                first = nums[n];
		            }
		            else if (nums[n] <= second) {
		                second = nums[n];
		            }
		            else {
		            	triplet= true;
		                return triplet;
		            }
		        }

		        return triplet;
			}

	public static void main(String[] args) {
		int[] nums = {0,4,2,1,0,-1,-3};
		IncreasingTripletSequence p = new IncreasingTripletSequence();
		boolean tripletPresent = p.increasingTriplet(nums);
		System.out.print(tripletPresent  + " ");
	}
}
