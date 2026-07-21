import java.util.*;

class StockSpan {

    public static int[] loadSpan(int[] arr){
        int n=arr.length;
        int[] span=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }

            span[i]=st.isEmpty()?i+1:i-st.peek();
            st.push(i);
        }
        return span;
    }
}
