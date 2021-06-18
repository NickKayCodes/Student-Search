import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

/**
 * StudentSearch Final Project
 * This is where the main method is held
 * along with the menu and its corresponding methods
 * to add, remove, search, and list student objects
 * from the binary search tree.
 * 
 * @author Nick Kayyarath
 * @version 12/1/20
 */
public class StudentSearch 
{
    static BinarySearchTree students; // initalize binary search tree
    static ArrayList<Object> studList; // initalize ArrayList

    /**
     * this is the main method for the student search program
     * 
     */
    public static void main(String[] args) throws Exception 
    {
        Scanner in = new Scanner(System.in);
        students = new BinarySearchTree();
        studList = new ArrayList<>();
        int selection = 0;
        boolean finished = false;
        System.out.println("*** Initializing Student Search ***\n");

        // add 5 students to Arraylist & BST
        addFiveStudents(studList, students);

        do 
        {

            clearScreen();
            students.print();
            menu();
            System.out.print("Please make a selction: ");
            try 
            {
                selection = Integer.parseInt(in.nextLine());
                switch (selection) 
                {
                    case 1: // add students
                        addStudent(in, students, studList);
                        break;
                    case 2: // search students
                        searchStudent(in, students);
                        break;
                    case 3: // rm students
                        rmStudent(in, students);
                        break;
                    case 4: // list major
                        listMajor(in, studList, students);
                        break;
                    case 0: // terminate
                        System.out.println("*** Student Search Program Terminated ***");
                        return;
                    default:
                        System.out.println("Invalid input, please try again.");
                }
            } 
            catch (Exception e) 
            {
                System.out.println("Your selection must to be an integer 0-4");
                pause();
            }
        } while (!finished);

    }

    /**
     * this is the menu method for Student Search
     */
    public static void menu() 
    {
        System.out.print("1. Add a Student\n" + "2. Search for a Student\n" + "3. Remove a Student.\n"
                + "4. List by Major\n" + "0. Quit\n");
    }

    /**
     * This method alows user to search for a student in the BST
     * 
     * @param in       reference to scanner
     * @param students reference to BinarySearchTree students
     * @throws IOException
     */
    public static void searchStudent(Scanner in, BinarySearchTree students) throws IOException 
    {
        try 
        {
            System.out.println("*** Student Search ***");
            System.out.print("Student ID number: ");
            int idNum = Integer.parseInt(in.nextLine());
            Student student = new Student(idNum);
            if (students.find(student) == null) 
            {
                System.out.printf("Student ID: %d" + " not found\n", idNum);
                pause();
            } 
            else 
            {
                System.out.print(students.find(student));
                pause();
            }
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            pause();
        }
    }

    /**
     * This method adds student objects to the BST Takes scanner in,
     * BinarySearchTree students, and ArrayList studList
     * 
     * @param in       reference to scanner
     * @param students reference to BST students
     * @param studList reference to ArrayList studList
     * @throws IOException
     */
    public static void addStudent(Scanner in, BinarySearchTree students, ArrayList<Object> studList)
            throws IOException 
    {
        try 
        {
            System.out.println("*** Add Student ***");
            System.out.print("Please enter student ID number: ");
            int studentId = Integer.parseInt(in.nextLine());

            System.out.print("Please enter student name: ");
            String name = in.nextLine();

            System.out.print("Please enter student major: ");
            String major = in.nextLine().trim();

            for (Object stud : studList) 
            {
                if (((Student) stud).getId() == studentId) 
                {
                    System.out.println("Duplicate student ID: " + studentId + "\nPlease enter a valid ID number.");
                    pause();
                    break;
                } 
                else 
                {
                    Student s = new Student(studentId, name, major);
                    students.add(s); // add to bst
                    studList.add(s); // add to student list
                    System.out.println("*** Student added ***");
                    pause();
                    break;
                }
            }
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            pause();
        }
    }

    /**
     * this method removes a student object from the BinarySearchTree
     * 
     * @param in       reference to scanner
     * @param students reference to BinarySearchTree students
     * @param studList reference to ArrayList studList
     * @throws IOException
     */
    public static void rmStudent(Scanner in, BinarySearchTree students) throws IOException 
    {
        try 
        {
            System.out.println("*** Remove Student ***");
            System.out.println("Student ID to be removed: ");
            int id = Integer.parseInt(in.nextLine());

            Student s = new Student(id);
            if (students.find(s) == null) 
            {
                System.out.println("Student does not exist");
            } 
            else 
            {
                System.out.println(students.find(s) + "Removed");
                students.remove(s);
            }
            pause();
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            pause();
        }
    }

    /**
     * This method lists students by major
     * 
     * @param in       scanner reference
     * @param students reference to BinarySearchTree students
     * @throws IOException
     */
    public static void listMajor(Scanner in, ArrayList<Object> studList, BinarySearchTree students) throws IOException {
        try 
        {
            System.out.println("*** List students by major ***");
            System.out.println("Please enter 3 character major: ");
            String major = in.nextLine().toUpperCase().trim();
            for (Object stud : students.getList()) 
            {
                // checks if major from Student is equal to input major
                if (((Student) stud).getMajor().equals(major)) 
                {
                    System.out.println(stud.toString());
                }
                else 
                {
                    System.out.println("There are no students with the major: " + major);
                    break;
                }

            }
            pause();
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            pause();
        }
    }

    /**
     * this method adds students to the BST and arraylist
     * 
     * @param studList reference to ArrayList studList
     * @param students reference to BinarySearchTree students
     */
    public static void addFiveStudents(ArrayList<Object> studList, BinarySearchTree students) 
    {
        Student s1 = new Student(123, "Sally Foster", "ENG");
        Student s2 = new Student(10, "Mark Smith", "WEB");
        Student s3 = new Student(44, "Joe Williams", "CNC");
        Student s4 = new Student(132, "Mary Moore", "WEB");
        Student s5 = new Student(144, "Stewart Jones", "GEN");
        // add to student list
        studList.add(s1);
        studList.add(s2);
        studList.add(s3);
        studList.add(s4);
        studList.add(s5);
        // add to BST
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
    }

    /**
     * This function pauses processing until the user enters any key
     * 
     * @throw IOException - if read error occurs
     */
    public static void pause() throws IOException 
    {
        System.out.print("Press Enter key to continue: ");
        char c = (char) System.in.read();
    }

    /**
     * This method clears the screen when called
     */
    public static void clearScreen() 
    {
        System.out.print("\f");
    }
}