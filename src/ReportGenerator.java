import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReportGenerator {
    private List<StudentGrade> studentGrades;

    public ReportGenerator(List<StudentGrade> studentGrades) {
        this.studentGrades = studentGrades;
    }

    public void generateReport() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("files/grade-reports.out"));

        StudentGrade maxGradeStudent = getMaxGrade();
        writer.println("Highest grade: " + maxGradeStudent.getName() + " " + maxGradeStudent.getGrade());

        int averageGrade = getAverageGrade();
        writer.println("Average grade: " + averageGrade);

        StudentGrade minGradeStudent = getWorstGrade();
        writer.println("Lowest grade: " + minGradeStudent.getName() + " " + minGradeStudent.getGrade());

        System.out.println("Report generated");

        writer.close();
    }

    private StudentGrade getMaxGrade() {
        StudentGrade maxGrade = null;
        for (StudentGrade grade : studentGrades) {
            if (maxGrade == null || grade.getGrade() > maxGrade.getGrade()) {
                maxGrade = grade;
            }
        }
        return maxGrade;
    }

    private int getAverageGrade() {
        int sum = 0;
        for (StudentGrade grade : studentGrades) {
            sum += grade.getGrade();
        }
        return studentGrades.isEmpty() ? 0 : sum / studentGrades.size();
    }

    private StudentGrade getWorstGrade() {
        StudentGrade worstGrade = null;
        for (StudentGrade grade : studentGrades) {
            if (worstGrade == null || grade.getGrade() < worstGrade.getGrade()) {
                worstGrade = grade;
            }
        }
        return worstGrade;
    }
}

