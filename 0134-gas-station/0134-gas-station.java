class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int balance = 0;
        int start = 0;
        int defiency = 0;
        for (int i = 0; i < n; i++) {
            balance += gas[i] - cost[i];
            if(balance < 0) {
                defiency += balance;
                start = i + 1;
                balance = 0;
            }
        }
        if(defiency + balance >= 0) {
            return start;
        } else {
            return -1;
        }
    }
}