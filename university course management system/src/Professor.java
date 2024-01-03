public class Professor {
    private String name;
    private String faculty;
    private int yearsOfExperience;

    public Professor(String name, String faculty, int yearsOfExperience) {
        this.name = name;
        this.faculty = faculty;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("+-----------------------------------+\n" +
                             "| Name:                       %-10s |\n" +
                             "| Faculty:                    %-10s |\n" +
                             "| Years of Experience:        %-10d |\n" +
                             "+----------------------------------------+",
                                name,faculty,yearsOfExperience);
    }
}
