package day6;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sindex=0;
        for(int i=0; i<t.length();i++){
            if(s.length()>sindex && s.charAt(sindex)==t.charAt(i)){
                 sindex++;
            }
           

        }
      return sindex== s.length();  
    }
}
