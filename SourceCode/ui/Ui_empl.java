package ui;

import Dao.DaoEmp;
import Dao.DaoPersoanl_detail;
import Dao.DaoSalary_detail;
import Dao.DaoUnion_detail;
import Logic.Logic_Emp;
import entity.Emp;
import entity.Personal_detail;
import entity.Salary_detail;
import entity.Union_detail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ui_empl {
    /**
     * ui for printing active and inactive emp
     */
    public static void get_all_Emp() {
       Scanner sc=new Scanner(System.in);
        int active=sc.nextInt();
        List<Emp> list=Logic_Emp.get_all_emp(active);
        for(Emp e:list)
        {
            System.out.println(e);
        }


    }

    /**
     * ui for adding emp
     */
    public static void addEmp() {

        Emp e = new Emp();
        Scanner sc = new Scanner(System.in);
        System.out.println("email: ");
        String email = sc.next();
        System.out.println("Post: ");
        String post = sc.next();
        System.out.println("Gender(M/F): ");
        char gender = sc.next().charAt(0);

        if (gender != 'M' && gender != 'F') {
            System.out.println("wrong format");
            return;
        }
        if (DaoEmp.get_max_id() != -1) {
            e.setEmail(email);
            e.setGender(gender);
            e.setPost(post);
            e.setId(DaoEmp.get_max_id());

            Salary_detail s = new Salary_detail();
            Union_detail u = new Union_detail();
            Personal_detail p = new Personal_detail(email);

            e.setSalary_detail(s);
            e.setPersonal_detail(p);
            e.setUnion_detail(u);

            Logic_Emp.add_emp(e);

        } else {
            System.out.println("some error occured");
        }


    }

    /**
     *Ui for updating personal detail
     */
    public static void update_personal_detail() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter email");
        String email = sc.next(), name, phone, address;

        Emp e = Logic_Emp.get_emp_by_email(email);

        Personal_detail p = DaoPersoanl_detail.get_by_id(e.getId());
        System.out.println("enter new name");
        name = sc.next();
        name = p.getName();

        System.out.println("enter new address");
        address = sc.next();

        System.out.println("enter new phoneno");
        phone = sc.next();

        p.setName(name);
        p.setPhoneno(phone);
        p.setAddress(address);
        e.setPersonal_detail(p);


        Logic_Emp.update_employee(e);
    }



}
