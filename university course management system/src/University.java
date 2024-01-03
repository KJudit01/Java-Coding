import java.util.ArrayList;
import java.util.List;

public class University {
    private static University instance;
    private List<Course> courses;
    private List<Professor> professors;
    private List<Enrollable> participants;

    private University() {
        courses = new ArrayList<>();
        professors = new ArrayList<>();
        participants = new ArrayList<>();
    }

    public static synchronized University getInstance() {
        if (instance == null) {
            instance = new University();
        }
        return instance;
    }

    public void offerCourse(Course course) {
        for (Course existingCourse : courses) {
            if (existingCourse.getCourseCode().equals(course.getCourseCode())) {
                new DuplicateCourseException("Course already exists.");
            }
        }
        courses.add(course);
    }

    public void hireProfessor(Professor professor) {
        for (Professor existingProfessor : professors) {
            if (existingProfessor.getName().equals(professor.getName())) {
                new DuplicateProfessorException("Professor has already been hired.");
            }
        }
        professors.add(professor);
    }

    public void admitEnrollable(Enrollable enrollable) {
        for (Enrollable existingEnrollable : participants) {
            if (existingEnrollable.equals(enrollable)) {
                new DuplicateParticipantException("Participant has already been admitted.");
            }
        }
        participants.add(enrollable);
    }

    public List<Enrollable> getParticipantsOfCourse(Course course) {
        for (Course existingCourse : courses) {
            if (existingCourse.getCourseCode().equals(course.getCourseCode())) {
                return new ArrayList<>(existingCourse.getEnrolledParticipants());
            }
        }
        return (List<Enrollable>) new CourseNotFoundException("Course is not found.");
    }

    public List<Course> getCourseByProfessor(Professor professor) {
        List<Course> coursesByProfessor = new ArrayList<>();
        for (Course course : courses) {
            if (course.getProfessor().equals(professor)) {
                coursesByProfessor.add(course);
            }
        }
        return coursesByProfessor;
    }
}
