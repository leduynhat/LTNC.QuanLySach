/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien;

import Model.Bills;
import View.Interface;
import View.LoginOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuanLyThuVien {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Interface v = new Interface(10);
//        v.setVisible(true);
        LoginOption.getInstance().setVisible(true);
//
//        Connection cons = model.dBConnect.getConnect();
//        String startString = "2002-1-1";
//        String stopString = "2020-12-12";
//        String sql = "SELECT COUNT(*) AS sum,  SUM(price) AS price, DATE(issuesDate) AS day  FROM `bill` WHERE issuesDate BETWEEN '"+ startString  +"' AND '" + stopString + "' GROUP BY DATE(issuesDate)";
//        List<Bills> list = new ArrayList<>();
//        try {
//            System.out.println("quanlythuvien.QuanLyThuVien.main()");
//            PreparedStatement ps =  cons.prepareStatement(sql);
////            ps.setString(1, "2002-1-1");
////            ps.setString(2, "2020-7-20");
//            System.out.println(ps);
//            ResultSet rs = ps.executeQuery();
////            ResultSetMetaData rsmd = rs.getMetaData();
////            System.out.println(rs.toString());
////            System.out.println(rsmd.getColumnCount());
//            while(rs.next()){
//                Bills bill = new Bills();
//                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
////                bill.setExporeDate(rs.getString("day"));
//                bill.setSum_bill(rs.getInt("sum"));
//                bill.setSum_price(rs.getInt("price"));
//                System.out.println(bill.getSum_bill() + " " + bill.getSum_price());
//                list.add(bill);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
    }
    
}
