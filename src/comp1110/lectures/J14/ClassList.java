package comp1110.lectures.J14;

import comp1110.lectures.O02.COMP1110Student;

import java.util.*;

public class ClassList {
    public static void main(String[] args) {
        COMP1110Student studentArray[] = {
                new COMP1110Student("Mary", 19, "u2345678", 4, 15, 5, 4, 4, 70),
                new COMP1110Student("Josh", 40, "u6678901", 5, 17, 4, 5, 4, 69),
                new COMP1110Student("Bob", 20, "u3456789", 3, 16, 4, 5, 5, 75),
                new COMP1110Student("Ting", 21, "u4567890", 4, 14, 4, 4, 5, 90),
                new COMP1110Student("Vijay", 18, "u5678901", 5, 17, 4, 5, 4, 69),
        };

        //List<COMP1110Student> studentList = new ArrayList<>(Arrays.asList(studentArray));
        List<COMP1110Student> studentList = new ArrayList<>();
        studentList.addAll(Arrays.asList(studentArray));
        /*
        for (var student : studentArray) {
            studentList.add(student);
        }
         */

        var newArray = studentList.toArray(new COMP1110Student[studentList.size()]);
        System.out.println("Are studentArray and newArray the same? " + (studentArray == newArray));
        System.out.println("Do studentArray and newArray refer to the same objects? " + Arrays.equals(studentArray, newArray));

        COMP1110Student thirdStudent = studentList.get(2);
        studentList.add(3, new COMP1110Student("Jasleen", 18, "u1234571", 5, 17, 4, 5, 4, 69));
        //studentList.remove(5);

        System.out.println("Elements of studentList:");
        for (var student : studentList) {
            System.out.println(student);
        }

        Set<COMP1110Student> studentSet = new HashSet<>();
        studentSet.add(studentList.get(0));
        boolean added = studentSet.add(studentList.get(1));
        System.out.println("Added Josh? " + added);
        added = studentSet.add(studentList.get(1));
        System.out.println("Added Josh? " + added);

        System.out.println("Elements of studentSet:");
        for (var student : studentSet) {
            System.out.println(student);
        }

        boolean isBobInSet = studentSet.contains(studentList.get(2));
        System.out.println("Is Bob in set? " + isBobInSet);

        Map<String, COMP1110Student> uidMap = new HashMap<>();
        for (var student : studentArray) {
            uidMap.put(student.getUid(), student);
        }

        uidMap.remove("u6678901");
        uidMap.put("u2345678", new COMP1110Student("Mary", 20, "u2345678", 5, 15, 5, 4, 4, 75));

        System.out.println("Keys in uidMap:");
        for (var uid : uidMap.keySet()) {
            System.out.println(uid);
        }

        System.out.println("Values in uidMap:");
        for (var student : uidMap.values()) {
            System.out.println(student);
        }

        //Collections.sort(studentList, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        Collections.sort(studentList);
        System.out.println("Sorted studentList:");
        for (var student : studentList) {
            System.out.println(student);
        }
    }
}
