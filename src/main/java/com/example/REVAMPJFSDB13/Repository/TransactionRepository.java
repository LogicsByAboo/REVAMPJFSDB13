package com.example.REVAMPJFSDB13.Repository;

import com.example.REVAMPJFSDB13.Model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionModel , Integer> {

    @Query("Select t from TransactionModel t where t.bankModel.accountId = :id")
    List<TransactionModel> getTransactionHistory(int id);

    @Query("Select t from TransactionModel t where t.bankModel.accountId = :Id and t.transactionType = :type")
    List<TransactionModel> getCustomTransactionHistory(int id , String type);

   @Query("Select t from TransactionModel t where t.transactionAmount > :amount")
    List<TransactionModel> getTransactiongreater(BigDecimal amount);

}
