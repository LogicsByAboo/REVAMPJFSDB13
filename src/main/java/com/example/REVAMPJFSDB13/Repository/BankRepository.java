package com.example.REVAMPJFSDB13.Repository;

import com.example.REVAMPJFSDB13.Model.BankModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface BankRepository extends JpaRepository<BankModel, Integer> {

}
