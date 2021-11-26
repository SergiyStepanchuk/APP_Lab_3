package Task3;

public class Subject
{
    private String name;

    public Subject(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject) && !(o instanceof String)) return false;

        return name.equals(o instanceof String ? o : ((Subject)o).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
