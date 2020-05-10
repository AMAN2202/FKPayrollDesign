package entity;

public class Emp {
    private static int lastid = 0;
    private int id;
    Personal_detail Personal_detail;
    Union_detail Union_detail;
    Salary_detail Salary_detail;






    public Emp() {

    }

    public Emp(Personal_detail Personal_detail, Union_detail Union_detail, Salary_detail Salary_detail) {
        this.id=lastid+1;
        this.Personal_detail = Personal_detail;
        this.Union_detail = Union_detail;
        this.Salary_detail = Salary_detail;
    }


    public Personal_detail getPersonal_detail() {
        return Personal_detail;
    }

    public void setPersonal_detail(Personal_detail Personal_detail) {
        this.Personal_detail = Personal_detail;
    }

    public Union_detail getUnion_detail() {
        return Union_detail;
    }

    public void setUnion_detail(Union_detail Union_detail) {
        this.Union_detail = Union_detail;
    }

    public Salary_detail getSalary_detail() {
        return Salary_detail;
    }

    public void setSalary_detail(Salary_detail Salary_detail) {
        this.Salary_detail = Salary_detail;
    }
}