package Dao;

import entity.Salary_detail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoSalary_detail {
    static final private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final private String DB_URL = "jdbc:mysql://localhost/db";
    static final private String USER_NAME = "aman";
    static final private String PASSWORD = "Lol@123456789@";
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;


    public static Salary_detail get_by_id(int id) {

        String sql = "SELECT *  FROM Salary_detail where id=" + id;
        List<Salary_detail> list = get_Salary_detail(sql);
        assert (list.size() == 1);
        return list.get(0);
    }


    public static List<Salary_detail> get_Salary_detail(String sql) {
        List<Salary_detail> list = new ArrayList<>();
        try {
            // load driver and get connection
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
//                System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3) + "\t" + resultSet.getInt(4));
                list.add(new Salary_detail(resultSet.getDouble(1), resultSet.getDouble(2), resultSet.getDouble(3), resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8)));
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


    public static void add(Salary_detail s, int id) {
        String sql = String.format("insert into Salary_detail values(%.2f,%.2f,%.2f,%.2f,%.2f,'%s','%s',%d,%d)", s.getFixed_salary(), s.getSales_commission(), s.getHour_rate(), s.getSalary_holded(), s.getDue(), s.getAccount_number(), s.getPostal_address(), s.getDefault_payment_mode(), id);
        System.out.println(sql);

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

    public static void delete(int id) {
        String sql = String.format("delete from Salary_detail where id=%d", id);
        System.out.println(sql);

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

    public static void update(Salary_detail p, int id) {
        delete(id);
        add(p, id);
    }
}
