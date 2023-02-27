package com.example.fastlmsexample.product.service;

import com.example.fastlmsexample.product.dto.ProductDto;
import com.example.fastlmsexample.product.entity.Product;
import com.example.fastlmsexample.product.model.ProductParam;
import com.example.fastlmsexample.product.model.ProductRegisterRequest;

import java.util.List;

public interface ProductService {
    boolean register(ProductRegisterRequest parameter);

    /**
     * 등록된 상품 목록 가져오기
     */
    List<ProductDto> list(ProductParam parameter);
}
