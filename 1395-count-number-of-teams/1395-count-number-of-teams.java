class Solution {
    public int numTeams(int[] rating) {
        int res = 0 ;
        for(int j = 0 ;j<rating.length;j++){
            int bigger_left = 0 , bigger_right = 0;
            int smaller_left = 0 , smaller_right = 0;
            for(int i = j-1;i>=0;i--){
                if(rating[i]<rating[j]){
                    smaller_left++;
                }else{
                    bigger_left++;
                }
            }
            for(int k = j+1;k<rating.length;k++){
                if(rating[k]>rating[j]){
                    bigger_right++;
                }else{
                    smaller_right++;
                }
            }
                    res +=smaller_left*bigger_right + bigger_left* smaller_right;

        }
        return res;
    }
}