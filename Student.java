
/**
 * Student Class of the student search program
 * This is where the information for each student objects are held
 * It also implements the Comparable interface
 *
 * @author Nick Kayyarath
 * @version 12/1/20
 */
public class Student implements Comparable<Student> 
{
    // initialize studentId, studentName, and studentMajor
    private int studentId;
    private String studentName, studentMajor;

    /**
     * Default constructor that creates an empty student with default blank values
     */
    public Student() 
    {
        studentId = 0;
        studentName = "";
        studentMajor = "";
    }

    /**
     * Special constructor with student id
     * 
     * @param studentId id number a student
     */
    public Student(int studentId) 
    {

        this.studentId = studentId;
        studentName = "";
        studentMajor = "";
    }

    /**
     * Parameteriized constructor that calls the setters to
     * set student ID, name and major
     * @param studentId id number of student
     * @param studentName name of student
     * @param studentMajor major of student
     */
    public Student(int studentId, String studentName, String studentMajor) 
    {

        setId(studentId);
        setName(studentName);
        setMajor(studentMajor);

    }

    /**
     * This method gets student ID
     * 
     * @return Student ID
     */
    public int getId() 
    {
        return studentId;
    }

    /***
     * this method sets student id
     * 
     * @param studentId
     */
    public void setId(int studentId) 
    {
        String strId = String.valueOf(studentId);
        if (studentId < 0 ) 
        {
            throw new IllegalArgumentException("Student ID cannot be less than zero.");
        } 
        else if(strId == null || strId.trim().isBlank())
        {
            throw new IllegalArgumentException("Student id cannot be blank.");
        }
        else 
        {
            this.studentId = studentId;
        }

    }

    /**
     * this method gets a student's name
     * 
     * @return student name
     */
    public String getName() 
    {
        return studentName;
    }

    /**
     * this method sets a students name
     * 
     * @param studentName
     */
    public void setName(String studentName) 
    {
        if (isEmpty(studentName)) 
        {
            throw new IllegalArgumentException("Student name cannot be blank.");
        } 
        else 
        {
            this.studentName = studentName;
        }

    }

    /**
     * this method gets a student major
     * 
     * @return student 3 character major
     */
    public String getMajor() 
    {
        return studentMajor;
    }

    /**
     * This method sets a student's major
     * 
     * @param studentMajor
     */
    public void setMajor(String studentMajor) 
    {
        if (studentMajor.length() != 3) 
        {
            throw new IllegalArgumentException("Student Major cannot be longer or shorter than 3 characters.");
        } 
        else 
        {
            this.studentMajor = studentMajor.toUpperCase();
        }

    }

    /**
     *  toString formats the printing of the student's info.
     */
    @Override
    public String toString() 
    {
        return (String.format("#%d\t %-20s\t %-10s\n", this.studentId, this.studentName, this.studentMajor));
    }

    /**
     *  This compareTo method overrides the compareTo method
     *  in the binary search tree
     * 
     */
    @Override
    public int compareTo(Student stud) 
    {
        Student s = (Student) stud;
        return studentId - s.studentId;
    }
    /**
     * This method checks if the string in studentName is empty or is blank
     * 
     */
    public boolean isEmpty(String studentName)
    {
        return (studentName.isEmpty() || studentName.trim().isBlank());
    }

}