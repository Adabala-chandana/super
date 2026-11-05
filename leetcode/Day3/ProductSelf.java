package day3;

class ProductSelf {
    public int[] productExceptSelf(int[] nums) {
       int n=nums.length;
       int product[] = new int[n];
       int left=1;
       int right =1;
       for(int i=0;i<nums.length;i++){
           product[i]=left;
           left = left * nums[i];
       }
        for(int j=n-1;j>0;j--){
           product[j]=product[j]* right;
           right = right * nums[j];
       }
       return product;     
   }
    public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int[] nums2 = { -1, 1, 0, -3, 3 };
		ProductSelf p = new ProductSelf();
		int answer[] = p.productExceptSelf(nums);
		for (int num : answer) {
			System.out.print(num + " ");
		}
		int answer1[] = p.productExceptSelf(nums2);
		for (int num : answer1) {
			System.out.print(num + " ");
		}
	}

	
}

