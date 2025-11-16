package com.example.REVAMPJFSDB13.Service;

import com.example.REVAMPJFSDB13.Model.BankModel;
import com.example.REVAMPJFSDB13.Model.TransactionModel;
import com.example.REVAMPJFSDB13.Repository.BankRepository;
import com.example.REVAMPJFSDB13.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    BankRepository bankRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public BankModel create(BankModel bankModel) {
        return bankRepository.save(bankModel);
    }

    public String withdrawAmount(int id, BigDecimal amount, String pin) {

        BankModel data = bankRepository.findById(id).orElse(null);

        if(data == null){
            return "Account not found";
        }
        if(!data.getPin().matches(pin)){
            return "Invalid pin";
        }
        if(data.getAccountBalance().compareTo(amount) <0){
            return "INSUFFICIENT ACCOUNT BALANCE";
        }

        data.setAccountBalance(data.getAccountBalance().subtract(amount));
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setBankModel(data);
        transactionModel.setTransactionAmount(amount);
        transactionModel.setTransactionTime(LocalDateTime.now());
        transactionModel.setTransactionType("WITHRDRAW");
        transactionRepository.save(transactionModel);
        bankRepository.save(data);

        return "WITHDRAW SUCCESSFUL FROM" + id + "amount of" + amount + "AVAILABLE BALANCE IS" + data.getAccountBalance();
    }

    public String depositAmount(int id , BigDecimal amount , String pin){

        BankModel data = bankRepository.findById(id).orElse(null);

        if(data == null){
            return "INVALID ACCOUNT ID";
        }
        if(!data.getPin().matches(pin)){
            return "INVALID PIN";
        }

        data.setAccountBalance(data.getAccountBalance().add(amount));
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setBankModel(data);
        transactionModel.setTransactionAmount(data.getAccountBalance());
        transactionModel.setTransactionTime(LocalDateTime.now());
        transactionModel.setTransactionType("DEPOSIT");
        transactionRepository.save(transactionModel);
        bankRepository.save(data);

        return "DEPOSIT SUCCESSFUL TO" + id + "amount of" + amount + "AVAILABLE BALANCE IS" + data.getAccountBalance();
    }

    public Optional<BigDecimal> checkBalance(int id,String pin){

        BankModel data = bankRepository.findById(id).orElse(null);
        if(!data.getPin().matches(pin)){
            return Optional.empty();
        }
        return Optional.of(data.getAccountBalance()) ;
    }
    }

