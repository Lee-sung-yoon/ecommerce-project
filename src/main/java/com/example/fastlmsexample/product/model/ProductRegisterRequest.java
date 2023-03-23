package com.example.fastlmsexample.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductRegisterRequest {

    private String productName;
    private String productId;
    private String createDt;
    private String endDt;

}
