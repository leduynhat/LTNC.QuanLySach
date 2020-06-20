/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author littl
 */
public class BillDetail {
    private int amount;
    private int BillId;
    private String BookId;
    
    public void setbookid(String ID) {
       this.BookId = BookId;
    }
    public void setamount(int a) {
        this.amount= a;
    }

    public void setBillId(int BillId) {
        this.BillId = BillId;
    }
    
    public int getAmount() {
        return amount;
    }

    public int getBillId() {
        return BillId;
    }

    public String getBookId() {
        return BookId;
    }
    
    
}
