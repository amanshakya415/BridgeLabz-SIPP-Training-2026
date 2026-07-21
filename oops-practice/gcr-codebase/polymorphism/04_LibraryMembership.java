
abstract class LibraryMember {

    String memberName;
    String memberId;

    LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    abstract int calculateFine(int days);

    void print() {
        System.out.println(memberName + " " + memberId);
    }
}

class StudentMember extends LibraryMember {

    StudentMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    int calculateFine(int days) {
        return days * 2;
    }
}

class FacultyMember extends LibraryMember {

    FacultyMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    int calculateFine(int days) {
        return days;
    }
}

class GuestMember extends LibraryMember {

    GuestMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    int calculateFine(int days) {
        return days * 5;
    }
}

public class Main4 {

    public static void main(String[] args) {
        LibraryMember[] members = {
            new StudentMember("A", "S1"),
            new FacultyMember("B", "F1"),
            new GuestMember("C", "G1")
        };

        String id = "F1";

        for (LibraryMember member : members) {
            member.print();
            System.out.println(member.calculateFine(4));

            if (member.memberId.equals(id)) {
                System.out.println("Found " + member.memberName);
            }
        }
    }
}
