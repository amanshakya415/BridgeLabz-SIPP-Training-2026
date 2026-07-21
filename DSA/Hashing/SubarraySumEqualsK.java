import java.util.*;

class SubarraySumEqualsK{
    public static int subarraySumEqualsK(int[] arr,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0,ans=0;
        for(int x:arr){
            sum+=x;
            ans+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}