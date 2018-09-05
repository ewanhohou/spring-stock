package com.hoho.stock.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Stock {
    @Id
    @GeneratedValue
    private Integer stockid;
    private String symbol;
    private String name;
}
