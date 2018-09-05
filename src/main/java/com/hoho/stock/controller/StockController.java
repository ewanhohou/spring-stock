package com.hoho.stock.controller;

import com.hoho.stock.entity.Stock;
import com.hoho.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class StockController {
    @Autowired
    private StockRepository stockRepository;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/v1/stocks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Stock> getAll() {
        return stockRepository.findAll();
    }
}
