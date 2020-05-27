package com.avalding.stockapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avalding.stockapp.tables.AccountBalances;

public interface AccountBalancesRepository extends JpaRepository<AccountBalances, Integer> {

}
