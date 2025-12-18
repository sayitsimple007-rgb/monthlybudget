package com.example.monthlybudget.api.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long amountDue;
    private Long amountPaid;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;
    @ManyToOne
    @JoinColumn(name = "expense_type_id")
    private ExpenseType expenseType;
    @Version
    private Long version;

    public Expense() {
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Long getAmountDue(){
        return amountDue;
    }

    public void setAmountDue(Long amountDue){
        this.amountDue = amountDue;
    }

    public Long getAmountPaid(){
        return amountPaid;
    }

    public void setAmountPaid(Long amountPaid){
        this.amountPaid = amountPaid;
    }

    public Country getCountry(){
        return country;
    }

    public void setCountry(Country country){
        this.country = country;
    }

    public State getState(){
        return state;
    }

    public void setState(State state){
        this.state = state;
    }

    public ExpenseType getExpenseType(){
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType){
        this.expenseType = expenseType;
    }

    public Long getVersion(){
        return version;
    }

    public void setVersion(Long version){
        this.version = version;
    }
}
