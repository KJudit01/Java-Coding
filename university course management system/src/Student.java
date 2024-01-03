public class Student implements Enrollable {
    private String name;
    private String studentId;
    private String major;

    public Student(String name, String studentId, String major) {
        this.name = name;
        this.studentId = studentId;
        this.major = major;
    }

    @Override
    public String toString() {
        return String.format("+------------------------+\n" +
                             "| Name:       %-10s |\n" +
                             "| StudentID:  %-10s |\n" +
                             "| Major:      %-10s |\n" +
                             "+-----------------------------+", name,studentId,major);
    }
}
