package Dao;

import entity.Emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * implements crud operation for Emp
 */
public class DaoEmp {
    static final private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final private String DB_URL = "jdbc:mysql://localhost/db";
    static final private String USER_NAME = "aman";
    static final private String PASSWORD = "Lol@123456789@";
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;


    /**
     *
     * @param id id of Employee
     * @return Emp employee having that id
     */
    public static Emp get_by_id(int id) {

        String sql = "SELECT *  FROM Emp where id=" + id;
        List<Emp> list = get_Emp(sql);
        assert (list.size() == 1);
        return list.get(0);
    }



    /**
     *
     * @param email String email id of Employee
     * @return  Emp employee having that email
     */
    public static Emp get_by_email(String email) {

        String sql = String.format("SELECT *  FROM Emp where email='%s'",email);
        List<Emp> list = get_Emp(sql);
        assert (list.size() == 1);
//        System.out.println(list.size());
//        System.out.println(email);
        return list.get(0);
    }


    /**
     *
     * @return ArrayList<Emp>  all employee from database
     * @param active
     */

    public static List<Emp> get_all(int active) {

        String sql = "SELECT *  FROM Emp";
        List<Emp> list = get_Emp(sql);
        return list;
    }


    /**
     *
     * @param sql String sql query to be exected and must execute on Emp table
     * @return  employee from database by executing sql
     */
    public static List<Emp> get_Emp(String sql) {
        List<Emp> list = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {

                Emp e = new Emp();
                e.setId(resultSet.getInt(1));
                e.setEmail(resultSet.getString(2));
                e.setActive(resultSet.getBoolean(3));
                e.setPost(resultSet.getString(4));
                e.setGender(resultSet.getString(5).charAt(0));
                list.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {

            }
            return list;
        }

    }



    /**
     *
     * @return  returns the (maximum id in Emp table)+1 or -1 if it faails
     */
    public static int get_max_id() {
        int id2 = 0;
        try {
            // load driver and get connection
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();


            resultSet = statement.executeQuery("select max(id) from Emp");
            if (resultSet.next()) {
                id2 = resultSet.getInt(1);
            }

            return id2 + 1;


        } catch (Exception ex) {
            return -1;


        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {

            }
            return id2 + 1;

        }

    }



    /**
     *
     * @param s  Emp to be added in database
     */
    public static void add(Emp s) {

        String sql = String.format("insert into Emp values(%d,'%s',%b,'%s','%c')", s.getId(), s.getEmail(), s.isActive(), s.getPost(), s.getGender());
//        System.out.println(sql);

        try {
            // load driver and get connection
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {

            }

        }


    }




    /**
     *
     * @param s  Emp to be deleted from database
     *        only he is updated as inactive in database
     */
    public static void delete(Emp s) {
        s.setActive(false);
        update(s);
    }



    /**
     *
     * @param p  Emp to be upadated in database
     */
    public static void update(Emp p) {
        String sql = String.format("update Emp set active=%b,post='%s',email='%s' where id=%d", p.isActive(), p.getPost(), p.getId(), p.getEmail());
//        System.out.println(sql);

        try {
            // load driver and get connection
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {

            }

        }

    }



    /**
     * @param active 0/1 0 for inactive employee
     * @return ArrayList<Emp> all active employee from database
     */
    public List<Emp> getall(int active) {
        String sql = String.format("select * from Emp where active=%d");
        return get_Emp(sql);
    }
}


