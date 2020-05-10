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