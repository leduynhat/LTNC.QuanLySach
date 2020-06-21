/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class ReportImp implements Report{

    /**
     *
     * @param startTimestamp
     * @param stopTimestamp
     * @return
     */
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
