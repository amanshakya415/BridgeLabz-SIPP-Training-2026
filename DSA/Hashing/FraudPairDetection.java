import java.util.*;

class FraudPairDetection{
    public static int[] findFraudPair(int[] amounts,int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<amounts.length;i++){
            int comp=target-amounts[i];
            if(map.containsKey(comp))
                return new int[]{map.get(comp),i};
            map.put(amounts[i],i);
        }
        return new int[]{-1,-1};
    }
}