package com.hoho.stock.repository;

import com.hoho.stock.entity.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface StockRepository extends JpaRepository<Stock, Integer> {
    // GET /Stocks/:id
    @Override
    Stock findOne(Integer id);

    // GET /Stocks
    @Override
    Page<Stock> findAll(Pageable pageable);

    // POST /Stocks and PATCH /Stocks/:id
    @Override
    Stock save(Stock s);

    // DELETE /Stocks/:id
    @Override
    @RestResource(exported = false)
    void delete(Stock t);
}
