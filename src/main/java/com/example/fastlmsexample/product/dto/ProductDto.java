package com.example.fastlmsexample.product.dto;

import com.example.fastlmsexample.product.entity.Product;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Data
@ToString
public class ProductDto {
    String productId;
    String productName;

    String createDt;
    String endDt;


    // 추가 컬럼
    long totalCount;
    long seq;

    public static ProductDto of(Product product) {

        return ProductDto.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .createDt(product.getCreateDt())
                .endDt(product.getEndDt())
                .build();
    }
}
