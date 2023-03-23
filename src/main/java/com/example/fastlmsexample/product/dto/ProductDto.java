package com.example.fastlmsexample.product.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString

public class ProductDto {
    String productId;
    String productName;

    String createDt;
    String endDt;
    LocalDateTime registerDt;

    // 추가 컬럼
    long totalCount;
    long seq;

}
