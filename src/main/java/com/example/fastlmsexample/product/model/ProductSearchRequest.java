package com.example.fastlmsexample.product.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductSearchRequest {
    private String productName;
    private String productCategory;

}
