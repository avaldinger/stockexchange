package com.avalding.stockapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avalding.stockapp.tables.PriceHistory;


public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Integer> {

}
