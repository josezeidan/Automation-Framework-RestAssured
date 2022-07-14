package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Expense {


    private String name;
    private double amount;
    private String expenseDateTime = "07/11/2021 00:00:00";
    private String expenseType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer otherExpenseNameId;

    public Expense(){

    }

    public Expense(String name, double amount, String expenseDateTime, String expenseType, Integer otherExpenseNameId){
        setName(name);
        setAmount(amount);
        setExpenseDateTime(expenseDateTime);
        setExpenseType(expenseType);
        setOtherExpenseNameId(otherExpenseNameId);

    }
    public Expense(String name, double amount, String expenseDateTime, String expenseType){
        setName(name);
        setAmount(amount);
        setExpenseDateTime(expenseDateTime);
        setExpenseType(expenseType);

    }

    public String getName() {
        return name;
    }

    public Expense setName(String name) {
        this.name = name;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public Expense setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public String getExpenseDateTime() {
        return expenseDateTime;
    }

    public Expense setExpenseDateTime(String expenseDateTime) {
        this.expenseDateTime = expenseDateTime;
        return this;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public Expense setExpenseType(String expenseType) {
        this.expenseType = expenseType;
        return this;
    }

    public Integer getOtherExpenseNameId() {
        return otherExpenseNameId;
    }

    public Expense setOtherExpenseNameId(Integer otherExpenseNameId) {
        this.otherExpenseNameId = otherExpenseNameId;
        return this;
    }
}
