import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "files/grades.txt";

        List<StudentGrade> studentGrades = new GradeFileReader().readGradesFromFile(filePath);

        if (studentGrades != null) {
            Classroom classroom = new Classroom(studentGrades);

            System.out.println("Grades for Mathematics: " + classroom.getGradesForDiscipline("Mathematics"));
            System.out.println("Grades for Amilia Hilaria: " + classroom.getGradesForStudent("Amilia Hilaria"));
            System.out.println("Max grade for Computer Science: " + classroom.getMaxGrade("Computer Science"));
            System.out.println("Max grade overall: " + classroom.getMaxGrade());
            System.out.println("Average grade for Physics: " + classroom.getAverageGrade("Physics"));
            System.out.println("Worst grade for Computer Science: " + classroom.getWorstGrade("Computer Science"));

            ReportGenerator reportGenerator = new ReportGenerator(studentGrades);
            reportGenerator.generateReport();

        }
    }

}
