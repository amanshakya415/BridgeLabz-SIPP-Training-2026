import java.util.*;

class NextGreaterElement {

    public static int[] nextBusierDay(int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        Arrays.fill(ans,-1);

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i]>arr[st.peek()]){
                ans[st.pop()]=arr[i];
            }
            st.push(i);
        }
        return ans;
    }
}
