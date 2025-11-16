package com.example.REVAMPJFSDB13.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
public class TransactionModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int transactionId;

    @ManyToOne
    @JoinColumn(name = "account_id",nullable = false)
    private BankModel bankModel;
    private BigDecimal transactionAmount;
    private LocalDateTime transactionTime;
    private String transactionType;


    public int getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public BankModel getBankModel() {
        return bankModel;
    }
    public void setBankModel(BankModel bankModel) {
        this.bankModel = bankModel;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }
    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }
    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getTransactionType(){
        return transactionType;
    }
    public void setTransactionType(String transactionType){
        this.transactionType = transactionType;
    }
}
