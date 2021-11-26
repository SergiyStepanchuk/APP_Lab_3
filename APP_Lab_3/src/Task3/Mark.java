package Task3;

public class Mark
{
    private int value;
    private Subject subject;

    public Mark(int value, Subject subject)
    {
        this.value = value;
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Mark)) return false;

        Mark mark = (Mark) o;

        return subject != null ? subject.equals(mark.subject) : mark.subject == null;
    }

    @Override
    public int hashCode()
    {
        return subject != null ? subject.hashCode() : 0;
    }

    @Override
    public String toString() {
        return subject + ": " + value;
    }

    public int getValue() {
        return value;
    }

    public String getSubjectName()
    {
        return subject.getName();
    }
}
