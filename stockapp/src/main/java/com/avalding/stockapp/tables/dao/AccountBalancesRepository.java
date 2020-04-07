package com.avalding.stockapp.tables.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avalding.stockapp.tables.AccountBalances;

public interface AccountBalancesRepository extends JpaRepository<AccountBalances, Integer> {

}
