import java.util.*;

class DuplicateSessionToken {
    public static boolean hasDuplicateToken(String[] tokens){
        HashSet<String> seen=new HashSet<>();
        for(String token:tokens){
            if(!seen.add(token)) return true;
        }
        return false;
    }
}