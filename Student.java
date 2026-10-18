// Student.java - BADA CODE - 150+ Lines - Model Class - OOP Concepts
// By Riya Chavan 3121 - Student Management - Java + Java Swing
import java.util.Date;

public class Student {
    private String rollNo;
    private String name;
    private String department;
    private String semester;
    private String email;
    private String phone;
    private int marks;
    private String status;
    private String grade;
    private String admissionDate;
    private int attendance;
    private String address;
    private String gender;
    private Date dob;
    private String fatherName;
    private String motherName;
    private double fees;
    private String feesStatus;
    private String bloodGroup;
    private String category;

    public Student() {
        this.rollNo = "";
        this.name = "";
        this.department = "Computer Science";
        this.semester = "Sem 6";
        this.email = "";
        this.marks = 0;
        this.status = "PASS";
        this.grade = "A";
        this.admissionDate = new Date().toString();
        this.attendance = 85;
        this.feesStatus = "Paid";
    }

    public Student(String rollNo, String name, String department, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.department = department;
        this.marks = marks;
        this.semester = "Sem 6";
        this.status = marks >= 50 ? "PASS" : "FAIL";
        this.grade = calculateGrade();
        this.email = name.toLowerCase().replace(" ", "") + "@college.com";
        this.admissionDate = new Date().toString();
        this.attendance = 75 + (int)(Math.random() * 20);
        this.feesStatus = "Paid";
        this.phone = "9876543210";
        this.address = "Mumbai";
        this.gender = "Other";
        this.fatherName = "Father of " + name;
        this.motherName = "Mother of " + name;
        this.fees = 50000.0;
        this.bloodGroup = "O+";
        this.category = "General";
        System.out.println("BADA CODE - Student Object Created: " + rollNo + " | " + name + " | " + marks + " | " + status);
    }

    public String getRollNo() { return rollNo; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks = marks; this.status = marks >= 50 ? "PASS" : "FAIL"; this.grade = calculateGrade(); }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public String getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(String admissionDate) { this.admissionDate = admissionDate; }
    public int getAttendance() { return attendance; }
    public void setAttendance(int attendance) { this.attendance = attendance; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }
    public String getMotherName() { return motherName; }
    public void setMotherName(String motherName) { this.motherName = motherName; }
    public double getFees() { return fees; }
    public void setFees(double fees) { this.fees = fees; }
    public String getFeesStatus() { return feesStatus; }
    public void setFeesStatus(String feesStatus) { this.feesStatus = feesStatus; }
    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String calculateGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B+";
        else if (marks >= 60) return "B";
        else if (marks >= 50) return "C";
        else return "F";
    }

    public boolean isPass() { return marks >= 50; }
    public boolean isFail() { return marks < 50; }
    public boolean isDistinction() { return marks >= 75; }
    public boolean isFirstClass() { return marks >= 60 && marks < 75; }

    @Override
    public String toString() {
        return "Student{" + "rollNo='" + rollNo + '\'' + ", name='" + name + '\'' + ", dept='" + department + '\'' + ", sem='" + semester + '\'' + ", marks=" + marks + ", status='" + status + '\'' + ", grade='" + grade + '\'' + ", email='" + email + '\'' + ", attendance=" + attendance + ", feesStatus='" + feesStatus + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return rollNo.equals(student.rollNo);
    }

    @Override
    public int hashCode() { return rollNo.hashCode(); }
}
