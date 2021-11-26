package Task3;

import java.util.*;

public class Task3
{
    public static void main(final String[] args) {
        final var sb_phythics = new Subject("Фізика");
        final var sb_english = new Subject("Англійська мова");
        final var sb_math = new Subject("Математика");

        final Set<Subject> subjects = new HashSet<Subject>(Arrays.asList(
                sb_phythics,
                sb_english,
                sb_math
        ));

        var studentList = new StudentList(subjects, new Student[] {
                new Student("AAAAAA", "Serhii", "Stepanchuk", "Tarasovych", 'A', 11, new HashSet<Mark>(Arrays.asList(
                        new Mark(4, sb_phythics),
                        new Mark(4, sb_english),
                        new Mark(4, sb_math)
                ))),
                new Student("BBBBBB","Maria", "Gryziak", "Lybomirivna", 'B', 10, new HashSet<Mark>(Arrays.asList(
                        new Mark(1, sb_phythics),
                        new Mark(1, sb_english),
                        new Mark(1, sb_math)
                ))),
                new Student("CCCCCC","Andrii", "Sobor", "Vasylivych", 'B', 11, new HashSet<Mark>(Arrays.asList(
                        new Mark(5, sb_phythics),
                        new Mark(5, sb_english),
                        new Mark(5, sb_math)
                )))
        });

        System.out.println(studentList);

        final var studentSimples = StudentSimple.fromStudent(studentList.getStudents());

        System.out.println("-----------REMOVED BAD STUDENTS-----------");
        studentList.removeBadStudents();
        System.out.println(studentList);

        System.out.println("-----------ALL ENGLISH MARKS-----------");
        System.out.println(studentList.studentsMarksBySubjectToString(studentList.getStudentsMarksBySubject(sb_english)));

        System.out.println("-----------NOT SORTED-----------");
        var students = studentList.getStudents();
        students.forEach(System.out::println);
        System.out.println("-----------SORTED-----------");
        Student.sortByPIB(students);
        students.forEach(System.out::println);
        System.out.println("-----------BEST STUDENT-----------");
        System.out.println(studentList.getBestStudent());
        System.out.println("-----------SURNAMES-----------");
        System.out.println(studentList.getAllSurnames());
    }
}