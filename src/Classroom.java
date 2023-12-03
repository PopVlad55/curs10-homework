import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private List<StudentGrade> studentGrades;

    public Classroom(List<StudentGrade> studentGrades) {
        this.studentGrades = studentGrades;
    }

    public List<Integer> getGradesForDiscipline(String discipline) {
        List<Integer> grades = new ArrayList<>();
        for (StudentGrade grade : studentGrades) {
            if (grade.getDiscipline().equals(discipline)) {
                grades.add(grade.getGrade());
            }
        }
        return grades;
    }

    public List<Integer> getGradesForStudent(String student) {
        List<Integer> grades = new ArrayList<>();
        for (StudentGrade grade : studentGrades) {
            if (grade.getName().equals(student)) {
                grades.add(grade.getGrade());
            }
        }
        return grades;
    }

    public StudentGrade getMaxGrade(String discipline) {
        StudentGrade maxGrade = null;
        for (StudentGrade grade : studentGrades) {
            if (grade.getDiscipline().equals(discipline) &&
                    (maxGrade == null || grade.getGrade() > maxGrade.getGrade())) {
                maxGrade = grade;
            }
        }
        return maxGrade;
    }

    public StudentGrade getMaxGrade() {
        StudentGrade maxGrade = null;
        for (StudentGrade grade : studentGrades) {
            if (maxGrade == null || grade.getGrade() > maxGrade.getGrade()) {
                maxGrade = grade;
            }
        }
        return maxGrade;
    }

    public int getAverageGrade(String discipline) {
        int sum = 0;
        int count = 0;
        for (StudentGrade grade : studentGrades) {
            if (grade.getDiscipline().equals(discipline)) {
                sum += grade.getGrade();
                count++;
            }
        }
        return count > 0 ? sum / count : 0;
    }

    public StudentGrade getWorstGrade(String discipline) {
        StudentGrade worstGrade = null;
        for (StudentGrade grade : studentGrades) {
            if (grade.getDiscipline().equals(discipline) &&
                    (worstGrade == null || grade.getGrade() < worstGrade.getGrade())) {
                worstGrade = grade;
            }
        }
        return worstGrade;
    }
}
