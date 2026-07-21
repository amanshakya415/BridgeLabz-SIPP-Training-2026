import java.util.*;

class LongestConsecutiveRun{
    public static int longestConsecutiveRun(int[] ids){
        HashSet<Integer> set=new HashSet<>();
        for(int x:ids) set.add(x);
        int longest=0;
        for(int id:set){
            if(!set.contains(id-1)){
                int curr=id,len=1;
                while(set.contains(curr+1)){
                    curr++;
                    len++;
                }
                longest=Math.max(longest,len);
            }
        }
        return longest;
    }
}