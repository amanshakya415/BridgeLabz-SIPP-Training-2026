import java.util.*;

class BalancedBrackets {

    public static boolean isValidConfig(String s){
        Stack<Character> st=new Stack<>();

        for(char ch:s.toCharArray()){
            if(ch=='('||ch=='{'||ch=='['){
                st.push(ch);
            }else{
                if(st.isEmpty()) return false;
                char open=st.pop();

                if((ch==')'&&open!='(')||
                   (ch=='}'&&open!='{')||
                   (ch==']'&&open!='['))
                    return false;
            }
        }
        return st.isEmpty();
    }
}
