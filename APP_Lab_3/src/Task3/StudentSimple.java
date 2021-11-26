package Task3;

import java.util.List;
import java.util.stream.Collectors;

public class StudentSimple {
    private String id;
    private String name;
    private String surname;
    private String lastname;

    public StudentSimple() {
    }

    public StudentSimple(final Student student) {
        this.name = student.getName();
        this.surname = student.getSurname();
        this.lastname = student.getLastname();
        this.id = student.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurName() {
        return surname;
    }

    public void setSurname(final String surName) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) { this.id = id; }

    @Override
    public String toString() {
        return name + " " + surname + " " + lastname;
    }

    public static List<StudentSimple> fromStudent(final List<Student> students) {
        return students.stream()
                       .map(StudentSimple::new)
                       .collect(Collectors.toList());
    }
}
