package com.avalding.stockapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avalding.stockapp.tables.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
