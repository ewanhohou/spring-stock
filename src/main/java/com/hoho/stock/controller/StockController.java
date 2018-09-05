package com.hoho.stock.controller;

import com.hoho.stock.dto.StockDto;
import com.hoho.stock.entity.Stock;
import com.hoho.stock.repository.StockRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Stock")
@RestController
@RequestMapping(value = "/api")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @ApiOperation(value = "取得股票", notes = "列出所有股票")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/v1/stock", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Stock> getAll() {
        return stockRepository.findAll();
    }

    @ApiOperation(value = "新增股票", notes = "新增股票的內容")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "存檔成功")})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/v1/stock", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public StockDto create(
            @ApiParam(required = true, value = "股票內容") @RequestBody StockDto stockDto) {
        Stock stock = new Stock();
        stock.setStockid(stockDto.getStockid());
        stock.setName(stockDto.getName());
        stock.setSymbol(stockDto.getSymbol());
        stock = stockRepository.save(stock);
        stockDto.setStockid(stock.getStockid());
        return stockDto;
    }

    @ApiOperation(value = "取得股票內容", notes = "取得股票內容")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "股票資訊")})
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/v1/stock/{stockid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StockDto get(
            @ApiParam(required = true, name = "stockid", value = "股票ID") @PathVariable Integer stockid) {
        Stock stock = stockRepository.findOne(stockid);
        StockDto stockDto = new StockDto();
        stockDto.setStockid(stock.getStockid());
        stockDto.setName(stock.getName());
        stockDto.setSymbol(stock.getSymbol());
        return stockDto;
    }
}
