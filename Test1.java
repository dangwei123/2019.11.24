在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
你从其中的一个加油站出发，开始时油箱为空。

如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/gas-station
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
方法一：
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N=gas.length;
        if(N==1&&gas[0]>=cost[0]){
            return 0;
        }
        for(int i=0;i<N;i++){
            if(gas[i]>=cost[i]){
                int j=(i+1)%N;
                int sum=gas[i]-cost[i];
                while(j!=i&&sum>=0){
                    sum+=gas[j]-cost[j];
                    j=(j+1)%N;
                    if(j==i&&sum>=0){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}

方法二：
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        int sum=0;
        int tmp=0;
        for(int i=0;i<gas.length;i++){
            sum+=gas[i]-cost[i];
            tmp+=gas[i]-cost[i];
            if(tmp<0){
                tmp=0;
                start=i+1;
            }
        }
        return sum>=0?start:-1;
    }
}

给定一个从1 到 n 排序的整数列表。
首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表
开头。
我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
返回长度为 n 的列表中，最后剩下的数字

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/elimination-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int lastRemaining(int n) {
        return fun(n);
    }
    private int fun(int n){
        if(n==1){
            return 1;
        }if(n==2){
            return 2;
        }if(n%2==1){
            return fun(n-1);
        }  
        return 2*(n/2+1-fun(n/2));
    }
}

