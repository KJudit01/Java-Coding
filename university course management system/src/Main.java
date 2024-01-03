import java.util.List;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        try {
            University university = University.getInstance();
            Professor professor1 = new Professor("Dr. Smith", "Computer Science", 10);
            Professor professor2 = new Professor("Dr. Jones", "Chemical Engineering", 12);
            university.hireProfessor(professor1);
            university.hireProfessor(professor2);
            Course course1 = new Course("ICT-101", "Introduction to Computer Science", professor1);
            Course course2 = new Course("OCH-201", "Organic Chemistry", professor2);
            System.out.println("The professors at the university are: ");
            System.out.println(professor1);
            System.out.println(professor2);
            university.offerCourse(course1);
            university.offerCourse(course2);
            Student student1 = new Student("Alice", "12345678", "Computer Science");
            Student student2 = new Student("Bob", "87654321", "Chemistry");
            Student student3 = new Student("Kate","12387645","English");
            university.admitEnrollable(student1);
            university.admitEnrollable(student2);
            course1.enrollParticipant(student1);
            course2.enrollParticipant(student2);
            System.out.println("Participants in " + course1.getCourseCode() + " classroom, in the class of " + course1.getCourseName() + " with " + course1.getProfessor().getName() + ":");
            for (Enrollable participant : university.getParticipantsOfCourse(course1)) {
                System.out.println(participant);
            }
            System.out.println("Participants in " + course2.getCourseCode() + " classroom, in the class of " + course2.getCourseName() + " with " + course2.getProfessor().getName() + ":");
            for (Enrollable participant : university.getParticipantsOfCourse(course2)) {
                System.out.println(participant);
            }
            List<Course> coursesByProfessor1 = university.getCourseByProfessor(professor1);
            System.out.println("Courses taught by " + professor1.getName() + ":");
            for (Course course : coursesByProfessor1) {
                System.out.println(course.getCourseName() + " (" + course.getCourseCode() + ")");
            }
            List<Course> coursesByProfessor2 = university.getCourseByProfessor(professor1);
            System.out.println("Courses taught by " + professor2.getName() + ":");
            for (Course course : coursesByProfessor2) {
                System.out.println(course.getCourseName() + " (" + course.getCourseCode() + ")");
            }
            try {
                course1.enrollParticipant(student1);
                System.out.println("This student was enrolled successfully again.");
            } catch (IllegalArgumentException e) {
                System.out.println("Cannot enroll the same student twice: " + e.getMessage());
            }
            try {
                course1.enrollParticipant(student3);
                System.out.println("This student was enrolled successfully.");
            } catch (IllegalArgumentException e) {
                System.out.println("Cannot enroll the same student twice: " + e.getMessage());
            }
            Researcher researcher1 = new Researcher("Peter", "ICT",20);
            Researcher researcher2 = new Researcher("Pamela","Sociology", 10);
            System.out.println("The researchers are: ");
            System.out.println(researcher1);
            System.out.println(researcher2);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
