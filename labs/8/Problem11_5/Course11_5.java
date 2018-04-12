/*
 * note: please don't break my code or move around the paths. It is neat and
 * tidy and I'd prefer it stays that way
 */
 
// JA: No test class?

package Problem11_5;

import java.util.ArrayList;

public class Course11_5 {

  private String courseName;
  private ArrayList<String> students = new ArrayList<String>();

  /**
   * Creates a new course object with the name var1
   */
  public Course11_5(String var1) {
    this.courseName = var1;
  }

  /**
   * Adds a student to the Course
   *
   * @param var1 The student's name to be added
   */
  public void addStudent(String var1) {
    students.add(var1);
  }

  /**
   * Gets an array that contains the names of all the students
   *
   * @return The array of the students names
   */
  public String[] getStudents() {
    return (String[]) students.toArray();
  }

  /**
   * Gets the number of students in the Course
   */
  public int getNumberOfStudents() {
    return students.size();
  }

  /**
   * Gets the name of the course
   * @return The course's name
   */
  public String getCourseName() {
    return this.courseName;
  }

  /**
   * Removes the student var1 from the course
   * @param var1 The name of the student to be removed
   */
  public void dropStudent(String var1) {
    students.remove(var1);
  }

  /**
   * Removes all students from the course
   */
  public void clear() {
    students.clear();
  }
}
