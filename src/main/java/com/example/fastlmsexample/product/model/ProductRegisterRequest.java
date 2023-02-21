package com.example.fastlmsexample.product.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductRegisterRequest {

    private String productName;
    private String productId;
    private String createDt;
    private String endDt;

}
