package Task3;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Student
{
    private Set<Mark> marks;

    private String id;
    private String name,
            surname,
            lastname;

    private char classChar;
    private int numberOfClass;

    public Student(String id, String name, String surname, String lastname, char classChar, int numberOfClass, Set<Mark> marks)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.classChar = classChar;
        this.numberOfClass = numberOfClass;
        this.marks = marks;
    }

    public Student(String id, String name, String surname, String lastname, char classChar, int numberOfClass)
    {
        this(id, name, surname, lastname, classChar, numberOfClass, new HashSet<Mark>());
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastname() {
        return lastname;
    }

    public char getClassChar() {
        return classChar;
    }

    public int getNumberOfClass() {
        return numberOfClass;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + lastname + "\n\t" +
                marks.stream().map(Mark::toString).collect(Collectors.joining("\n\t")) +
                "\n\tAvarage: " + getAvarageMark();
    }

    public void addMark(Mark mark)
    {
        marks.add(mark);
    }

    public double getAvarageMark()
    {
        return marks.stream().mapToInt(mark -> mark.getValue()).average().getAsDouble();
    }

    public Mark getMarkBySubject(Subject subject)
    {
        return marks.stream().filter(mark -> subject.equals(mark.getSubjectName())).findFirst().get();
    }

    public static void sortByPIB(List<Student> students)
    {
        students.sort(Comparator.comparing(val -> val.getName() + " " + val.getSurname() + " " + val.getLastname(), String::compareTo));
    }
}
