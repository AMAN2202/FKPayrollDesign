package entity;

/**
 * Employee
 */
public class Emp {

    private int id;
    private String email;
    private boolean active;
    private char gender;
    private String post;

    public Personal_detail getPersonal_detail() {
        return personal_detail;
    }

    public void setPersonal_detail(Personal_detail personal_detail) {
        this.personal_detail = personal_detail;
    }

    public Salary_detail getSalary_detail() {
        return salary_detail;
    }

    public void setSalary_detail(Salary_detail salary_detail) {
        this.salary_detail = salary_detail;
    }

    public Union_detail getUnion_detail() {
        return union_detail;
    }

    public void setUnion_detail(Union_detail union_detail) {
        this.union_detail = union_detail;
    }

    private Personal_detail personal_detail;
    private Salary_detail salary_detail;
    private  Union_detail union_detail;


    public Emp() {
        this.active = true;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "email='" + email + '\'' +
                ", active=" + active +
                ", gender=" + gender +
                ", post='" + post + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}