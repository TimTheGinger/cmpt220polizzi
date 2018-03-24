package Project10_9;

public class CourseTester {

  public static void main(String[] args) {
    Course test = new Course("ims");

    test.addStudent("Jim");
    test.addStudent("Gim");
    test.addStudent("Tim");

    printStudents(test);

    test.dropStudent("Gim");

    printStudents(test);
  }

  private static void printStudents(Course course) {
    String[] students = course.getStudents();
    for (int i = 0; i < course.getNumberOfStudents(); i++) {
      System.out.print(students[i] + " ");
    }
    System.out.println();
  }
}
