package org.example.exercice_tp;

import java.time.LocalDate;
import java.util.ArrayList;

public class Invoice {

    private int lines = 10;
    private long invoiceNum;
    private Customer customer;
    private LocalDate date;

    private ArrayList<Line> quantity;

    public Invoice(int lines, long invoiceNum, Customer customer, LocalDate date) {
        this.lines = lines;
        this.invoiceNum = invoiceNum;
        this.customer = customer;
        this.date = date;
        this.quantity = new ArrayList<>();
    }

    public Invoice(long invoiceNum, Customer customer, LocalDate date) {
        this.invoiceNum = invoiceNum;
        this.customer = customer;
        this.date = date;
        this.quantity = new ArrayList<>();
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public long getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(long invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ArrayList<Line> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<Line> quantity) {
        this.quantity = quantity;
    }

    public Line addLine(String ref, int quantity){
        Line line = new Line(ref, quantity);
        this.quantity.add(line);
        return line;
    }

    public double getTotal(){
        double sum = 0;
        for(Line line : quantity) {
            sum += line.getTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        String lines = "";
        for(Line line : quantity) {
            lines += " --- " + line.displayLine() + "\n";
        }

        return "Invoice for "+ customer.getName() +" : \n" +
               " * Invoice Num : " + invoiceNum + " \n" +
               " * Date : " + date + " \n" +
               " * Purchases : \n" +
                lines + " \n" +
                " * Total : " + getTotal() + "€";
    }
}
