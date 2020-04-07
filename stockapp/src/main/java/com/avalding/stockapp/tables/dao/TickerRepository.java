package com.avalding.stockapp.tables.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avalding.stockapp.tables.Tickers;


public interface TickerRepository extends JpaRepository<Tickers, Integer> {

}
