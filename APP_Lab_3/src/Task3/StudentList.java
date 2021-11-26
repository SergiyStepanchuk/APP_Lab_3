package Task3;

import java.util.*;
import java.util.stream.Collectors;

public class StudentList
{
    private Set<Subject> subjects;
    private Map<String, Student> students;

    public StudentList(Set<Subject> subjects, Student[] students)
    {
        this.subjects = subjects;
        this.students = new HashMap<String, Student>();
        for (var student : students)
            this.students.put(student.getId(), student);
    }

    public List<Student> getStudents()
    {
        return students.values().stream().collect(Collectors.toList());
    }

    public void addSubject(Subject subject)
    {
        subjects.add(subject);
    }

    public void addSubjectWithMarks(Subject subject, Map<String, Integer> marks)
    {
        addSubject(subject);
        for (var mark : marks.entrySet())
            students.get(mark.getKey()).addMark(new Mark(mark.getValue(), subject));
    }

    public Student getStudentById(String id)
    {
        return students.get(id);
    }

    @Override
    public String toString() {
        return students.values().stream().map(Student::toString).collect(Collectors.joining("\n"));
    }

    public Student getBestStudent()
    {
        var arr = new ArrayList<Student>(students.values());
        arr.sort(Comparator.comparingDouble(Student::getAvarageMark).reversed());
        return arr.get(0);
    }

    public Map<String, Integer> getStudentsMarksBySubject(Subject subject)
    {
        var resMap = new HashMap<String, Integer>();
        for (var student: students.entrySet())
            resMap.put(student.getKey(), student.getValue().getMarkBySubject(subject).getValue());
        return resMap;
    }

    public String studentsMarksBySubjectToString(Map<String, Integer> marks)
    {
        return marks.entrySet().stream().map(entry -> {
           var student = students.get(entry.getKey());
           return student.getName() + " " + student.getSurname() + " " + student.getLastname() + ": " + entry.getValue();
        }).collect(Collectors.joining("\n"));
    }

    public void removeBadStudents()
    {
        var std = getStudents();
        for (var student: std)
            if (student.getAvarageMark() < 3)
                students.remove(student.getId());
    }

    public String getAllSurnames()
    {
        return students.values().stream().map(Student::getSurname).collect(Collectors.joining("-"));
    }
}
