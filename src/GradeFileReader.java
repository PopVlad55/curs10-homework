import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GradeFileReader {

    public List<StudentGrade> readGradesFromFile(String filePath) throws IOException {
        List<StudentGrade> studentGrades = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");
            String name = parts[0].trim();
            String discipline = parts[1].trim();
            int grade = Integer.parseInt(parts[2].trim());

            StudentGrade studentGrade = new StudentGrade(name, discipline, grade);
            studentGrades.add(studentGrade);
        }

        reader.close();

        return studentGrades;
    }
}
