package Project10_9;

public class Course {

  private String courseName;
  private String[] students = new String[100];
  private int numberOfStudents;

  /**
   * Creates a new Course object
   *
   * @param courseName The String name of the course
   */
  public Course(String courseName) {
    this.courseName = courseName;
  }

  /**
   * Adds a new student to the course
   *
   * @param student The name of the student to be added
   */
  public void addStudent(String student) {
    students[numberOfStudents] = student;
    numberOfStudents++;

    if (numberOfStudents == students.length) {
      String[] newStudents = new String[students.length * 2];

      for (int i = 0; i < students.length; i++) {
        newStudents[i] = students[i];
      }

      students = newStudents;
    }
  }

  /**
   * Returns the array of the names of the students in the course
   *
   * @return the array of the names of the students in the course
   */
  public String[] getStudents() {
    String[] studentsArray = new String[students.length];

    System.arraycopy(students, 0, studentsArray, 0, students.length);

    return studentsArray;
  }

  /**
   * Returns the number of students in the course
   *
   * @return the number of students in the course
   */
  public int getNumberOfStudents() {
    return numberOfStudents;
  }

  /**
   * Returns the String name of the course
   *
   * @return the String name of the course
   */
  public String getCourseName() {
    return courseName;
  }

  /**
   * Removes a student's name from the array of students
   *
   * @param student The name of the student to be dropped from the array of students
   */
  public void dropStudent(String student) {
    String[] tempArray = new String[numberOfStudents - 1];

    int incr = 0;
    for (int i = 0; i < numberOfStudents; i++) {
      if (!students[i].equals(student)) {
        tempArray[incr] = students[i];
        incr++;
      }
    }

    students = tempArray;
    numberOfStudents--;
  }

  /**
   * Clears the entire list of students
   */
  public void clear() {
    students = new String[100];
    numberOfStudents = 0;
  }
}
