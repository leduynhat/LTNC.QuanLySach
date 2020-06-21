/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
/**
 *
 * @author dell
 */
public interface Report {
    public List<Bills> getListByBills(String startTimestamp, String stopTimestamp);
    
    public List<Book> getListByBooks(String startTimestamp, String stopTimestamp);
    
    public List<Customers> getListbyCustomer(String startTimestamp, String stopTimestamp);
    
}
