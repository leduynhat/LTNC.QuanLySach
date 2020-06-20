/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */

public class ThongKeImpl implements ThongKe{
    //đếm số tài khoản được tạo ra: SELECT COUNT(*) AS tong FROM `customer` WHERE Registerdate BETWEEN "2020-4-7 00:00:00"  AND "2020-7-7 00:00:00"
    
    /**
     * chọn một đoạn khách hàng nằm trong khoảng thời gian 
     * trả về một giá trị là int
     * tạo một vòng for chạy từng ngày một
     * SELECT COUNT(*) AS tong, Registerdate FROM `customer`
WHERE Registerdate LIKE "2020-4-7 00:00:00"
    * DELIMITER $$
    DROP PROCEDURE IF EXISTS getCustomers$$

    CREATE PROCEDURE getCustomers(
            IN startT TIMESTAMP,
        IN stopT TIMESTAMP
    )
    BEGIN
            DECLARE countT INT(1) DEFAULT 0;

        WHILE(startT <= stopT) DO
                    SELECT COUNT(*) AS tong, Registerdate FROM `customer`
                    WHERE Registerdate LIKE startT;
            SET countT =  countT + 1;
            TIMESTAMPADD(DAY, countT, startT);
        END WHILE;
    END; $$
    DELIMITER ;

     * @return 
     */
    //đếm số tiền thu được trong khoảng thời gian 
    @Override
    public List<Bills> getListByBills(String startTimestamp, String stopTimestamp) {
        Connection cons = model.dBConnect.getConnect();
        String sql = "SELECT COUNT(*) AS sum,  SUM(price) AS price, DATE(issuesDate) AS day  FROM `bill` WHERE issuesDate BETWEEN '"+ startTimestamp  +"' AND '" + stopTimestamp + "' GROUP BY DATE(issuesDate)";
        List<Bills> list = new ArrayList<>();
        try {
            PreparedStatement ps =  cons.prepareStatement(sql);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Bills bill = new Bills();
                bill.setIssuesDate(rs.getString("day"));
                bill.setSum_bill(rs.getInt("sum"));
                bill.setSum_price(rs.getInt("price"));
                System.out.println(bill.getIssuesDate() + " " + bill.getSum_bill() + " " + bill.getSum_price() );
                list.add(bill);
            }
            ps.close();
            cons.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customers> getListbyCustomer(String startTimestamp, String stopTimestamp) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection cons = model.dBConnect.getConnect();
        String sql = "SELECT COUNT(*) AS sum, DATE(Registerdate) AS day  FROM `customer` WHERE Registerdate BETWEEN '"+ startTimestamp +"' AND '"+ stopTimestamp+"' GROUP BY DATE(Registerdate)";
        List<Customers> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Customers customer = new Customers();
                customer.setRegisterdate(rs.getString("day"));
                customer.setSum_customoer(rs.getInt("sum"));
                list.add(customer);
            }
            ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param startTimestamp
     * @param stopTimestamp
     * @return
     */
    @Override
    public List<Book> getListByBooks(String startTimestamp, String stopTimestamp) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection cons = model.dBConnect.getConnect();
        String sql = "SELECT COUNT(*) AS sum, DATE(Registerdate) AS day  FROM `customer` WHERE Registerdate BETWEEN '"+ startTimestamp +"' AND '"+ stopTimestamp+"' GROUP BY DATE(Registerdate)";
        List<Book> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
//                Book book = new Book();
//                book.setRegisterdate(rs.getString("day"));
//                customer.setSum_customoer(rs.getInt("sum"));
//                list.add(book);
            }
            ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
