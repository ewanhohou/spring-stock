package com.hoho.stock.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "股票資料")
public class StockDto {
    @ApiModelProperty(value = "序號", required = true)
    private Integer stockid;
    @ApiModelProperty(value = "股票代碼", required = true)
    private String symbol;
    @ApiModelProperty(value = "股票名稱", required = true)
    private String name;
}
