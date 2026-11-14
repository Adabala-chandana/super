package day11;

public class BitwiseAndOfNumberRange {
    public int rangeBitwiseAnd(int left, int right) {
        int bitwiseAnd=0;
        while(left != right){
            left =left >> 1;
            right=right >> 1;
            bitwiseAnd++;
        }
        return right << bitwiseAnd;       
    }
}
