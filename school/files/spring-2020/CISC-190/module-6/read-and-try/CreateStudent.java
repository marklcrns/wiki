/*
 * Filename: CreateStudent.java
 *
 * Created by: Mark Lucernas
 *
 * Date: 2020-04-20
 */

public class CreateStudent
{
  public static void main(String[] args) {
    String studentName = "Mark Lucernas";
    int studentId = 187;
    double[] studentGradesArray = {98, 101, 99};
    Student mark = new Student(studentName, studentId, studentGradesArray);

    System.out.println(mark.getStudentName());
    System.out.println(mark.getStudentId());
    System.out.println(mark.getStudentGrades());
    System.out.println("Average: " + mark.getAverageGrade());
  }
}
