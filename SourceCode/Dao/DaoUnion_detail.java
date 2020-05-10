package Dao;

import entity.Union_detail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Crud method for Union_detail
 */
public class DaoUnion_detail {

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
     * @return Union detail op employee
     */
    public static Union_detail get_by_id(int id) {

        String sql = "SELECT *  FROM Union_detail where id=" + id;
        List<Union_detail> list = get_Union_detail(sql);
        assert (list.size() == 1);
        return list.get(0);
    }

    /**
     * Don't use
     * helper method
     *
     */
    public static List<Union_detail> get_Union_detail(String sql) {
        List<Union_detail> list = new ArrayList<>();
        try {
            // load driver and get connection
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
//                System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3) + "\t" + resultSet.getInt(4));
                ArrayList<Integer> l = new ArrayList<>();
                l.add(resultSet.getInt(3));
                l.add(resultSet.getInt(4));

                list.add(new Union_detail(resultSet.getBoolean(2), l));
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
     * @param p Union_detail of employee that is to be added
     * @param id Employee id
     */
    public static void add(Union_detail p, int id) {
        String sql = String.format("insert into Union_detail values(%d,%b,%d,%d)", id, p.isUnion_member(), p.getCharges().get(0), p.getCharges().get(1));
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

    /**
     *
     * @param id Employee id whose uinon detail is to be deleted
     */
    public static void delete(int id) {
        String sql = String.format("delete from Union_detail where id=%d", id);
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

    /**
     *
     * @param p Union_detail of employee to be updated
     * @param id id of employee
     */
    public static void update(Union_detail p, int id) {
        delete(id);
        add(p, id);
    }


}
