class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while(numBottles >= numExchange){
            int rem = numBottles%numExchange;
            numBottles = numBottles/numExchange;
            ans = ans + numBottles;
            numBottles = numBottles + rem;
        }
        return ans;
    }
}