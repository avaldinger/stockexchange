package com.avalding.stockapp.tables.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avalding.stockapp.tables.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
