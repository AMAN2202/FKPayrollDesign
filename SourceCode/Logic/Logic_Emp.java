package Logic;

import Dao.DaoEmp;
import Dao.DaoPersoanl_detail;
import Dao.DaoSalary_detail;
import Dao.DaoUnion_detail;
import entity.Emp;

import java.util.ArrayList;
import java.util.List;

public class Logic_Emp {
    /**
     *
     * @param e Employee e to be added
     */
    public  static  void add_emp(Emp e)
    {
        e.setId(DaoEmp.get_max_id());
        DaoEmp.add(e);
        DaoSalary_detail.add(e.getSalary_detail(), e.getId());
        DaoUnion_detail.add(e.getUnion_detail(), e.getId());
        DaoPersoanl_detail.add(e.getPersonal_detail(), e.getId());

    }

    /**
     *
     * @param active 0/1 0 for inactive
     * @return List<Emp>
     */
    public  static  List<Emp> get_all_emp(int active)
    {
        List<Emp> list = new ArrayList<>();
        try {
            list = DaoEmp.get_all(active);
            for (Emp e : list) {
                System.out.println(e);
            }
        } catch (Exception ex) {

        }
        return list;
    }

    /**
     *
     * @param e Employee whose detail is to be updated
     */
    public  static  void  update_employee(Emp e)
    {
        DaoPersoanl_detail.update(e.getPersonal_detail(),e.getId());
        DaoUnion_detail.update(e.getUnion_detail(),e.getId());
        DaoSalary_detail.update(e.getSalary_detail(),e.getId());
        DaoEmp.update(e);

    }

    /**
     *
     * @param email Email of employee whom you are searching
     * @return Emp
     */
    public  static Emp  get_emp_by_email(String email)
    {
       Emp e= DaoEmp.get_by_email(email);
       e.setPersonal_detail(DaoPersoanl_detail.get_by_id(e.getId()));
       e.setUnion_detail(DaoUnion_detail.get_by_id(e.getId()));
       e.setSalary_detail(DaoSalary_detail.get_by_id(e.getId()));

       return e;
    }

}
