package com.example.REVAMPJFSDB13.Controller;

import com.example.REVAMPJFSDB13.Model.BankModel;
import com.example.REVAMPJFSDB13.Model.TransactionModel;
import com.example.REVAMPJFSDB13.Repository.TransactionRepository;
import com.example.REVAMPJFSDB13.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Bank")
public class BankController {

    @Autowired
    BankService bankService;

    @Autowired
    TransactionRepository transactionRepository;

    @PostMapping("/accountCreation")
    public BankModel createNewAccount(@RequestBody BankModel bankModel){
        return bankService.create(bankModel);
    }

    @PostMapping("/withdraw/{id}")
    public String withdrawAmount(@PathVariable int id, @RequestParam("amount") BigDecimal amount,@RequestParam("pin") String pin){
        return bankService.withdrawAmount(id,amount,pin);
    }

    @PostMapping("/deposit/{id}")
    public String depositAmount(@PathVariable int id , @RequestParam("amount") BigDecimal amount , @RequestParam("pin") String pin){
        return bankService.depositAmount(id , amount , pin);
    }

    @GetMapping("/checkBalance/{id}/{pin}")
    public Optional<BigDecimal> checkBalance(@PathVariable("id")int id, @PathVariable("pin")String pin){
        return bankService.checkBalance(id,pin);
    }

    @GetMapping("/getTransactionHistory/{id}")
    List<TransactionModel> getTransactionHistory(@PathVariable int id){
        return transactionRepository.getTransactionHistory(id);
    }

    @GetMapping("/getCustomTransactionHistory/{id}")
    List<TransactionModel> getCustomTransactionHistory(@PathVariable int id , @RequestParam("Type") String type){
        return transactionRepository.getCustomTransactionHistory(id , type);
    }

    @GetMapping("getTransactionGreaterThanAmount")
    List<TransactionModel> getTransactiongreater(@RequestParam("Amount")BigDecimal amount){
        return transactionRepository.getTransactiongreater(amount);
    }
}
