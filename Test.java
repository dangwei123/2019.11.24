如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。

例如，以下数列为等差数列:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
以下数列不是等差数列。

1, 1, 2, 5, 7
 

数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数
且满足 0<=P<Q<N 。

如果满足以下条件，则称子数组(P, Q)为等差数组：

元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。

函数要返回数组 A 中所有为等差数组的子数组个数。

示例:

A = [1, 2, 3, 4]

返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/arithmetic-slices
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
方法一：
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3){
            return 0;
        }
        int num=0;
        int count=1;
        int l=0;
        for(int i=1;i<A.length;i++){
           if(i==1&&A[i]-A[i-1]==A[i+1]-A[i]){
                count++;
            }else if(i!=1&&i!=A.length-1){
                if(count>=2&&A[i]-A[i-1]==A[i-1]-A[i-2]){
                     count++;
                }else if(count==1&&A[i]-A[i-1]==A[i+1]-A[i]){
                    count++;
                }else{
                    l=i;
                    count=1;
                }
            }else if(i==A.length-1&&A[i]-A[i-1]==A[i-1]-A[i-2]){
                count++;
            }else{
                l=i;
                count=1;
            }
            if(count>=3){
                num+=i-l-1;
            }
        }
        return num;
    }
}

方法二：
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3){
            return 0;
        }
        int num=0;
        int count=0;
        for(int i=2;i<A.length;i++){
            if(A[i-1]-A[i]==A[i-2]-A[i-1]){
                num+=(++count);
            }else{
                count=0;
            }
        }
        return num;
    }
}

森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相
同的颜色。我们将这些回答放在 answers 数组里。

返回森林中兔子的最少数量。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rabbits-in-forest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int res=0;
        for(int i=0;i<answers.length;i++){
            res+=answers[i]+1;
            int k=answers[i];
            int m=k;
            i++;
            while(i<answers.length&&answers[i]==m&&k>0){
                i++;
                k--;
            }
            i--;
        }
        return res;
    }
}

