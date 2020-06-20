/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Bills;
import Model.Customers;
import Model.ThongKe;
import Model.ThongKeImpl;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.sql.Timestamp;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author dell
 */
public class ReportController {
    private ThongKe thongKe = null;
    
    public ReportController(){
        this.thongKe = new ThongKeImpl();
    }
    public void setDataToChart2(JPanel jPanel, String startTimestamp, String stopTimestamp){
        List<Bills> listItem = thongKe.getListByBills(startTimestamp, stopTimestamp);
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if(listItem != null){
            for(Bills item : listItem){
                dataset.addValue(item.getSum_bill(),"Bills", item.getIssuesDate());
            }
        }
        JFreeChart barChart = ChartFactory.createBarChart(
                "Chart of new bills".toUpperCase(),
                "Day",
                "Bill",
                dataset,
                PlotOrientation.VERTICAL,false,true,false
        );
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jPanel.getMinimumSize()));
        
        jPanel.removeAll();
        jPanel.setLayout(new CardLayout());
        jPanel.add(chartPanel);
        jPanel.validate();
        jPanel.repaint();
    }
    public void setDataToChart1(JPanel jPanel, String startTimestamp, String stopTimestamp){
        List<Bills> listItem = thongKe.getListByBills(startTimestamp, stopTimestamp);
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if(listItem != null){
            for(Bills item : listItem){
                dataset.addValue(item.getSum_price(),"VND", item.getIssuesDate());
            }
        }
        JFreeChart barChart = ChartFactory.createBarChart(
                "Chart of income".toUpperCase(),
                "Day",
                "VND",
                dataset,
                PlotOrientation.VERTICAL,false,true,false
        );
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jPanel.getMinimumSize()));
        
        jPanel.removeAll();
        jPanel.setLayout(new CardLayout());
        jPanel.add(chartPanel);
        jPanel.validate();
        jPanel.repaint();
    }
    public void setDataToChart3(JPanel jPanel, String startTimestamp, String stopTimestamp){
        List<Customers> listItem = thongKe.getListbyCustomer(startTimestamp, stopTimestamp);
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if(listItem != null){
            for(Customers item : listItem){
                dataset.addValue(item.getSum_customoer(),"Bills", item.getRegisterdate());
            }
        }
        JFreeChart barChart = ChartFactory.createBarChart(
                "Chart of customers register".toUpperCase(),
                "Day",
                "Account",
                dataset,
                PlotOrientation.VERTICAL,false,true,false
        );
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jPanel.getMinimumSize()));
        
        jPanel.removeAll();
        jPanel.setLayout(new CardLayout());
        jPanel.add(chartPanel);
        jPanel.validate();
        jPanel.repaint();
    }
    public void setDataToChart4(JPanel jPanel, String startTimestamp, String stopTimestamp){
        List<Bills> listItem = thongKe.getListByBills(startTimestamp, stopTimestamp);
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if(listItem != null){
            for(Bills item : listItem){
                dataset.addValue(item.getSum_bill(),"Bills", item.getIssuesDate());
            }
        }
        JFreeChart barChart = ChartFactory.createBarChart(
                "Chart of new bills".toUpperCase(),
                "Day",
                "Amount",
                dataset,
                PlotOrientation.VERTICAL,false,true,false
        );
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jPanel.getMinimumSize()));
//        chartPanel
        
        jPanel.removeAll();
        jPanel.setLayout(new CardLayout());
        jPanel.add(chartPanel);
        jPanel.validate();
        jPanel.repaint();
    }
}
