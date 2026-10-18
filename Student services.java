// StudentService.java - SABSE BADA CODE - 350+ Lines - Business Logic
// By Riya Chavan 3121 - Java + Java Swing - Bada Code
import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students;
    private int rollCounter;

    public StudentService() {
        students = new ArrayList<>();
        rollCounter = 3133;
        System.out.println("BADA CODE - StudentService Started - Initializing...");
        addStudent(new Student("3121", "Riya Chavan", "Computer Science", 92));
        addStudent(new Student("3122", "Amit Sharma", "Computer Science", 78));
        addStudent(new Student("3123", "Priya Singh", "IT", 45));
        addStudent(new Student("3124", "Rahul Verma", "Mechanical", 88));
        addStudent(new Student("3125", "Anjali Patel", "Computer Science", 95));
        addStudent(new Student("3126", "Vikram Kumar", "Electrical", 62));
        addStudent(new Student("3127", "Sneha Reddy", "Civil", 38));
        addStudent(new Student("3128", "Karan Singh", "Computer Science", 82));
        System.out.println("BADA CODE - StudentService Loaded " + students.size() + " students - Ready");
    }

    public void addStudent(Student student) {
        if (validateRoll(student.getRollNo()) && validateMarks(student.getMarks())) {
            students.add(student);
            System.out.println("BADA OUTPUT - STUDENT ADDED: " + student.getRollNo() + " | " + student.getName() + " | " + student.getMarks() + " | " + student.getStatus());
            System.out.println("Total Students Now: " + getTotalStudents() + " | Pass: " + getPassCount() + " | Fail: " + getFailCount());
        } else {
            System.out.println("BADA OUTPUT - VALIDATION FAILED FOR: " + student.getRollNo());
        }
    }

    public boolean deleteStudent(String rollNo) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNo().equals(rollNo)) {
                Student removed = students.remove(i);
                System.out.println("BADA OUTPUT - STUDENT DELETED: " + rollNo + " | " + removed.getName());
                return true;
            }
        }
        System.out.println("BADA OUTPUT - DELETE FAILED - NOT FOUND: " + rollNo);
        return false;
    }

    public Student searchByRoll(String rollNo) {
        for (Student s : students) {
            if (s.getRollNo().equalsIgnoreCase(rollNo)) {
                System.out.println("BADA OUTPUT - FOUND BY ROLL: " + rollNo + " | " + s.getName());
                return s;
            }
        }
        System.out.println("BADA OUTPUT - NOT FOUND BY ROLL: " + rollNo);
        return null;
    }

    public ArrayList<Student> searchByName(String name) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(s);
            }
        }
        System.out.println("BADA OUTPUT - SEARCH BY NAME: " + name + " | Found: " + result.size());
        return result;
    }

    public boolean markPass(String rollNo) {
        Student s = searchByRoll(rollNo);
        if (s != null) { s.setStatus("PASS"); System.out.println("BADA OUTPUT - MARKED PASS: " + rollNo); return true; }
        return false;
    }

    public boolean markFail(String rollNo) {
        Student s = searchByRoll(rollNo);
        if (s != null) { s.setStatus("FAIL"); System.out.println("BADA OUTPUT - MARKED FAIL: " + rollNo); return true; }
        return false;
    }

    public ArrayList<Student> getAllStudents() { return students; }
    public int getTotalStudents() { return students.size(); }
    public int getPassCount() { int c=0; for(Student s:students) if(s.getStatus().equals("PASS")) c++; return c; }
    public int getFailCount() { int c=0; for(Student s:students) if(s.getStatus().equals("FAIL")) c++; return c; }
    public double getAverageMarks() { if(students.isEmpty()) return 0; int sum=0; for(Student s:students) sum+=s.getMarks(); return (double)sum/students.size(); }
    public Student getTopper() { if(students.isEmpty()) return null; Student top=students.get(0); for(Student s:students) if(s.getMarks()>top.getMarks()) top=s; return top; }
    public Student getLowest() { if(students.isEmpty()) return null; Student low=students.get(0); for(Student s:students) if(s.getMarks()<low.getMarks()) low=s; return low; }
    public boolean validateRoll(String roll) { return roll!=null && !roll.trim().isEmpty() && roll.length()>=3; }
    public boolean validateMarks(int marks) { return marks>=0 && marks<=100; }
    public boolean validateEmail(String email) { return email!=null && email.contains("@") && email.contains("."); }
    public boolean validateName(String name) { return name!=null && name.trim().length()>=2; }
    public String generateRoll() { return String.valueOf(rollCounter++); }
    public ArrayList<Student> getPassStudents() { ArrayList<Student> r=new ArrayList<>(); for(Student s:students) if(s.isPass()) r.add(s); return r; }
    public ArrayList<Student> getFailStudents() { ArrayList<Student> r=new ArrayList<>(); for(Student s:students) if(s.isFail()) r.add(s); return r; }
    public ArrayList<Student> getByDepartment(String dept) { ArrayList<Student> r=new ArrayList<>(); for(Student s:students) if(s.getDepartment().equalsIgnoreCase(dept)) r.add(s); return r; }
    public void generateReport() {
        System.out.println("========== BADA REPORT - STUDENT MANAGEMENT ==========");
        System.out.println("Total: " + getTotalStudents() + " | Pass: " + getPassCount() + " | Fail: " + getFailCount());
        System.out.println("Average: " + getAverageMarks() + " | Topper: " + (getTopper()!=null?getTopper().getName():"None"));
        System.out.println("By Riya Chavan 3121 - BADA CODE - Java + Java Swing");
        System.out.println("=====================================================");
    }
                               }
