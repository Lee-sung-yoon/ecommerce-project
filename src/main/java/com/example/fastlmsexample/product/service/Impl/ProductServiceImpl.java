package com.example.fastlmsexample.product.service.Impl;

import com.example.fastlmsexample.member.repository.MemberRepository;
import com.example.fastlmsexample.product.dto.ProductDto;
import com.example.fastlmsexample.product.entity.Product;
import com.example.fastlmsexample.product.mapper.ProductMapper;
import com.example.fastlmsexample.product.model.ProductParam;
import com.example.fastlmsexample.product.model.ProductRegisterRequest;
import com.example.fastlmsexample.product.repository.ProductRepository;
import com.example.fastlmsexample.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public boolean register(ProductRegisterRequest parameter) {

        Optional<Product> optionalProduct = productRepository.findById(parameter.getProductId());
        if (optionalProduct.isPresent()) {
            return false;
        }

        Product product = Product.builder()
                .productName(parameter.getProductName())
                .productId(parameter.getProductId())
                .createDt(parameter.getCreateDt())
                .endDt(parameter.getEndDt())
                .registerDt(LocalDateTime.now())
                .build();
        productRepository.save(product);

        return true;
    }

    @Override
    public List<ProductDto> list(ProductParam parameter) {
        long totalCount = productMapper.selectListCount(parameter);

        List<ProductDto> list = productMapper.selectList(parameter);
        if (!CollectionUtils.isEmpty(list)) {
            int  i = 0;
            for (ProductDto x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }

        return list;

//        return productRepository.findAll();
    }

}
