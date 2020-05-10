package entity;

/**
 * Personal detail of employee such as name adress ...
 */
public class Personal_detail {

    private String name;
    private String address;
    private String phoneno;

    public Personal_detail(String name, String address, String phoneno) {
        this.name = name;
        this.address = address;
        this.phoneno = phoneno;
    }

    @Override
    public String toString() {
        return "Personal_detail{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneno='" + phoneno + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
}