/**
 * Class that describes a student.
 *
 * @author Mark Lucernas
 */
public class Student extends Object
{
  ////////////////////////////// fields //////////////////////////////
  private String studentName;
  private int studentId;
  private double[] gradeArray;

  ////////////////////////////// constructors //////////////////////////////
  /**
   * No-argument constructor
   */
  public Student() {}

  /**
   * Constructor that takes a student name and creates the Student
   * @param studentName the name of the student
   */
  public Student(String name)
  {
    this.studentName = name;
  }

  /**
   * Constructor that takes a student name and student's grades in array, and
   * creates the Student
   * @param studentName the name of the student
   * @param gradeArr the grades of the student in array
   */
  public Student(String name, double[] gradesArr)
  {
    this.studentName = name;
    this.gradeArray = gradesArr;
  }

  /**
   * Constructor that takes the student's name, ID number and grades, then
   * creates the Student
   * @param studentName the name of the student
   * @param id the student's ID number
   * @param gradeArr the grades of the student in array
   */
  public Student(String name, int id, double[] gradesArr)
  {
    this.studentName = name;
    this.studentId = id;
    this.gradeArray = gradesArr;
  }

  ////////////////////////////// methods //////////////////////////////
  /**
   * Method that returns the average grade of the student
   * @return the grade of the student
   */
  public double getAverageGrade()
  {
    double average = 0.0;

    /**
     * if grades of the student has not been set, return 0.0,
     * otherwise, return the average
     */
    if (this.gradeArray != null && this.gradeArray.length > 0)
    {
      double sum = 0.0;
      for (int i = 0; i < this.gradeArray.length; i++)
      {
        sum = sum + this.gradeArray[i];
      }
      average = sum / this.gradeArray.length;
    }
    return average;
  }

  /**
   * Method that returns the name of the student
   */
  public String getStudentName()
  {
    return "Student object named: " + this.studentName;
  }

  /**
   * Method that returns the student id of the student
   */
  public String getStudentId()
  {
    return "Student object ID: " + this.studentId;
  }

  /**
   * Method that returns the student's grades in String format
   */
  public String getStudentGrades()
  {
    String grades = "";
    /**
     * if grade array is empty or null, return blank string,
     * else, return grades
     */
    if (this.gradeArray.length != 0 || this.gradeArray != null)
    {
      grades = this.studentName + " grades are: ";

      for (int i = 0; i < this.gradeArray.length; i++)
      {
        grades += this.gradeArray[i];
        // append comma and space ", " in between grades except last
        if (i != this.gradeArray.length - 1)
        {
          grades += ", ";
        }
      }
    }

    return grades;
  }

  /**
   * Modifier method that sets the name of the student
   * @param newName the student's new name.
   * @return returns false if student's name has been set,
   * otherwise, set name and return true.
   */
  public boolean setName(String newName)
  {
    boolean result = false;
    if (this.studentName == null)
    {
      this.studentName = newName;
      result = true;
    }
    return result;
  }

  /**
   * Modifier method that sets the student id of the student
   * @param newId the student's new name.
   * @return returns false if student's id has been set,
   * otherwise, set student id and return true.
   */
  public boolean setStudentId(int newId)
  {
    boolean result = false;
    if (this.studentId < 0)
    {
      this.studentId = newId;
      result = true;
    }
    return result;
  }

  /**
   * Modifier method that updates the student's grade
   * @param index the index from the array to be modified
   * @param newGrade the grade that will replace the value at index
   * @return the updated grades
   */
  public boolean setGrade(int index, double newGrade)
  {
    // return false if newGrade is invalid, else set the grade
    if (newGrade < 0 || this.gradeArray == null)
      return false;
    else
    {
      this.gradeArray[index] = newGrade;
      return true;
    }
  }

  /**
   * Modifier method that sets the whole grades array of the student
   * @param gradesArr
   * @return returns false if grades of the student has not be set yet,
   * otherwise, return true.
   */
  public boolean setGradeArray(double[] gradesArr)
  {
    /**
     * return false if grades has not been set yet, else, set
     * the new grades array
     */
    if (this.gradeArray != null)
    {
      return false;
    }
    else
    {
      this.gradeArray = gradesArr;
      return true;
    }
  }
}
