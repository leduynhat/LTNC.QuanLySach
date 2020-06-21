/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author dell
 */
public class Bills {
    private int sum_bill;
    private String IssuesDate;
    private int sum_price;

    public void setIssuesDate(String IssuesDate) {
        this.IssuesDate = IssuesDate;
    }

    public void setSum_bill(int sum_bill) {
        this.sum_bill = sum_bill;
    }

    public void setSum_price(int sum_price) {
        this.sum_price = sum_price;
    }

    public String getIssuesDate() {
        return IssuesDate;
    }

    public int getSum_bill() {
        return sum_bill;
    }

    public int getSum_price() {
        return sum_price;
    }
}
