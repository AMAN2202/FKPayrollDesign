package entity;

/**
 * Salaray details of an employee ...
 */
public class Salary_detail {

    private  double fixed_salary=100d;
    private  double sales_commission;
    private  double hour_rate=500d;

    private  double salary_holded;
    private  double due=0d;
    private String account_number;
    private String  postal_address;
    private  int default_payment_mode=0;

    @Override
    public String toString() {
        return "Salary_detail{" +
                "fixed_salary=" + fixed_salary +
                ", sales_commission=" + sales_commission +
                ", hour_rate=" + hour_rate +
                ", salary_holded=" + salary_holded +
                ", due=" + due +
                ", account_number='" + account_number + '\'' +
                ", postal_address='" + postal_address + '\'' +
                ", default_payment_mode=" + default_payment_mode +
                '}';
    }

    public Salary_detail(double fixed_salary, double sales_commission, double hour_rate, double salary_holded, double due, String account_number, String postal_address, int default_payment_mode) {
        this.fixed_salary = fixed_salary;
        this.sales_commission = sales_commission;
        this.hour_rate = hour_rate;
        this.salary_holded = salary_holded;
        this.due = due;
        this.account_number = account_number;
        this.postal_address = postal_address;
        this.default_payment_mode = default_payment_mode;
    }
    public  Salary_detail()
    {

    }


    public double getFixed_salary() {
        return fixed_salary;
    }

    public void setFixed_salary(double fixed_salary) {
        this.fixed_salary = fixed_salary;
    }

    public double getSales_commission() {
        return sales_commission;
    }

    public void setSales_commission(double sales_commission) {
        this.sales_commission = sales_commission;
    }

    public double getHour_rate() {
        return hour_rate;
    }

    public void setHour_rate(double hour_rate) {
        this.hour_rate = hour_rate;
    }

    public double getDue() {
        return due;
    }

    public void setDue(double due) {
        this.due = due;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getPostal_address() {
        return postal_address;
    }

    public void setPostal_address(String postal_address) {
        this.postal_address = postal_address;
    }

    public int getDefault_payment_mode() {
        return default_payment_mode;
    }

    public void setDefault_payment_mode(int default_payment_mode) {
        this.default_payment_mode = default_payment_mode;
    }

    public double getSalary_holded() {
        return salary_holded;
    }

    public void setSalary_holded(double salary_holded) {
        this.salary_holded = salary_holded;
    }
}
