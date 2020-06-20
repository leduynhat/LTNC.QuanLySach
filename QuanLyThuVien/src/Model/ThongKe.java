/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import Model.Bills;
import Model.Customers;
import java.sql.Timestamp;

/**
 *
 * @author dell
 */
public interface ThongKe {
    public List<Bills> getListByBills(String startTimestamp, String stopTimestamp);
    
    public List<Book> getListByBooks(String startTimestamp, String stopTimestamp);
    
    public List<Customers> getListbyCustomer(String startTimestamp, String stopTimestamp);
    
}
