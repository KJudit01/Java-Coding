import java.util.HashSet;
import java.util.Set;

public class Course {
    private String courseCode;
    private String courseName;
    private Professor professor;
    private Set<Enrollable> enrolledParticipants;

    public Course(String courseCode, String courseName, Professor professor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.professor = professor;
        this.enrolledParticipants = new HashSet<>();
    }


    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Set<Enrollable> getEnrolledParticipants() {
        return enrolledParticipants;
    }

    public void enrollParticipant(Enrollable enrollable){
        if(!enrolledParticipants.add(enrollable)){
            throw new IllegalArgumentException("Participant has already enrolled.");
        }
    }
}
