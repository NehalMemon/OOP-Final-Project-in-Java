package model;

public class Student {
    private String SeatNo;
    private String name;
    private String email;
    private String phone;
    private String department;
    private int semester;

    public Student() {
    }

    public Student(String SeatNo, String name, String email, String phone, String department, int semester) {
        this.SeatNo = SeatNo;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.semester = semester;
    }

    // Getters and Setters
    public String getSeatNo() {
        return this.SeatNo;
    }

    public void setSeatNo(String SeatNo) {
        this.SeatNo = SeatNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
