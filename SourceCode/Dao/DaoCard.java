package Dao;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import entity.Card;
import entity.Card;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * implements database crud operation for card i.e Sales_card and Work_card
 */
public class DaoCard {


    static final private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final private String DB_URL = "jdbc:mysql://localhost/db";
    static final private String USER_NAME = "aman";
    static final private String PASSWORD = "Lol@123456789@";
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;

    /**
     *
     * @param id  Employee id for which you want active cards that haven't been processed
     * @param card_type  0 or 1 0 means Work_card and 1 means Saels_card
     * @return List<Card> that have't been used for payement i.e they are active
     */
    public static List<Card> get_by_id(int id,int card_type) {
        String card;
        switch (card_type){
            case 0: card="Work_card";
                        break;
            case 1 : default: card="Sales_card";
                        break;
        }

        String sql = String.format("SELECT *  FROM %s where  id=%d and processed=0",card,id);
       return get_Cards(sql);
   
    }

    /**
     *
     * @param sql sql query that is to be exected on Work_card or Sales_card
     * @return List<card> in accordance with query
     *
     */
    public static List<Card> get_Cards(String sql) {
        List<Card> list = new ArrayList<>();
        try {
            // load driver and get connection
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
//                System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3) + "\t" + resultSet.getInt(4));
                list.add(new Card(resultSet.getDouble(2), resultSet.getString(1)));
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
     * @param p Card that is to be added
     * @param id  employee id
     * @param card_type 0/1 Work_card/Sales_card
     * @throws ParseException if date can't be parsed
     */
    public static void add(Card p, int id,int card_type) throws ParseException {
        String card;
        String h_or_amount;
        switch (card_type){
            case 0: card="Work_card";
                    h_or_amount="hour";
                break;
            case 1 : default: card="Sales_card";
                h_or_amount="amount";
                break;
        }
        System.out.println(h_or_amount);
        Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(p.getDate());
        java.sql.Date dd= new java.sql.Date(utilDate.getTime());
        String sql = String.format("insert into %s(id,%s,date,processed) values(%d,'%.2f','%s',%d)",card,h_or_amount,id,p.getValue(),dd,0);
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




}
