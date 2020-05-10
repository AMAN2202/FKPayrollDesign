package Dao;

import entity.Personal_detail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Implement database crud operations for Persoanl_detail of Employee
 */
public class DaoPersoanl_detail {

    static final private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final private String DB_URL = "jdbc:mysql://localhost/db";
    static final private String USER_NAME = "aman";
    static final private String PASSWORD = "Lol@123456789@";
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;


    /**
     *
     * @param id employee id
     * @return Personal_detail object of an employee having that id
     */
    public static Personal_detail get_by_id(int id) {

        String sql = "SELECT *  FROM Personal_detail where id=" + id;
        List<Personal_detail> list = get_personal_detail(sql);
        assert (list.size() == 1);
        return list.get(0);
    }


    /**
     *
     * @param phoneno  phoneno of employee
     * @return  Personal_detail object of an employee having that phoneno
     */
    public static Personal_detail get_by_phoneno(String phoneno) {

        String sql = String.format("SELECT *  FROM Personal_detail where phoneno='%s'", phoneno);
        List<Personal_detail> list = get_personal_detail(sql);
        assert (list.size() == 1);
        return list.get(0);

    }


    public static List<Personal_detail> get_personal_detail(String sql) {
        List<Personal_detail> list = new ArrayList<>();
        try {
            // load driver and get connection
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
//                System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3) + "\t" + resultSet.getInt(4));
                list.add(new Personal_detail(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
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
     * @param p Personal_detail object that is to be stored
     * @param id employee id
     */
    public static void add(Personal_detail p, int id) {
        String sql = String.format("insert into Personal_detail(id,name,address,phoneno) values(%d,'%s','%s','%s')", id, p.getName(), p.getAddress(), p.getPhoneno());
//        System.out.println(sql);

        try {

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
     * @param id   id of employee to whose personal detail is to be deleted
     */

    public static void delete(int id) {
        String sql = String.format("delete from Personal_detail where id=%d", id);
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
     * @param p Personal_detail object
     * @param id id of Employee
     */
    public static void update(Personal_detail p, int id) {
        String sql = String.format("update Personal_detail  set name='%s', phoneno='%s',address='%s' where id=%d",p.getName(), p.getPhoneno(), p.getAddress(), id);
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


}
