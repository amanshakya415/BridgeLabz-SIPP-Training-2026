
import java.util.*;

public class EmployeeAttendanceRanking {

    static class Emp {

        int id, att;

        Emp(int id, int att) {
            this.id = id;
            this.att = att;
        }
    }

    static int[] topK(int[] ids, int[] att, int k) {
        Emp[] a = new Emp[ids.length];
        for (int i = 0; i < ids.length; i++) {
            a[i] = new Emp(ids[i], att[i]);
        }
        Arrays.sort(a, (x, y) -> {
            if (y.att != x.att) {
                return y.att - x.att;
            }
            return x.id - y.id;
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = a[i].id;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ids = {101, 102, 103, 104, 105};
        int[] att = {92, 85, 98, 92, 80};
        System.out.println(Arrays.toString(topK(ids, att, 3)));
    }
}
