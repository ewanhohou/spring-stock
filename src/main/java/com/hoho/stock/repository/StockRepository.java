package com.hoho.stock.repository;

import com.hoho.stock.entity.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface StockRepository extends JpaRepository<Stock, Integer> {
    // GET /stock/:id
    @Override
    Stock findOne(Integer id);

    // GET /stock
    @Override
    Page<Stock> findAll(Pageable pageable);

    // POST /stocks and PATCH /stock/:id
    @Override
    Stock save(Stock s);

    // DELETE /stock/:id
    @Override
    @RestResource(exported = false)
    void delete(Stock t);
}
