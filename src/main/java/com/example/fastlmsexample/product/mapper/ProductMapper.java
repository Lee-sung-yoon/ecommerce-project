package com.example.fastlmsexample.product.mapper;

import com.example.fastlmsexample.member.dto.MemberDto;
import com.example.fastlmsexample.product.dto.ProductDto;
import com.example.fastlmsexample.product.model.ProductParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    long selectListCount(ProductParam parameter);
    List<ProductDto> selectList(ProductParam parameter);


}
