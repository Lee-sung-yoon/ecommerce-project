package com.example.fastlmsexample.product.controller;

import com.example.fastlmsexample.product.dto.ProductDto;
import com.example.fastlmsexample.product.model.ProductParam;
import com.example.fastlmsexample.product.model.ProductRegisterRequest;
import com.example.fastlmsexample.product.model.ProductSearchRequest;
import com.example.fastlmsexample.product.service.ProductService;
import com.example.fastlmsexample.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product/search")
    public String list(Model model, ProductParam parameter) {
        parameter.init();

        List<ProductDto> products = productService.list(parameter);

        long totalCount = 0;
        if (products != null && products.size() > 0) {
            totalCount = products.get(0).getTotalCount();
        }
        String queryString = "";

        PageUtil pageUtil = new PageUtil(totalCount, parameter.getPageSize(), parameter.getPageIndex(), queryString);

        model.addAttribute("list", products);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pager", pageUtil.pager());

        return "product/search";
    }


    @PostMapping("/product/search")
    public String productSearchSubmit(Model model, ProductSearchRequest parameter) {

        return "product/search";
    }

    @GetMapping("/product/register")
    public String productRegister() {

        return "product/register";
    }

    @PostMapping("/product/register")
    public String productRegisterSubmit(Model model, HttpServletRequest request
            , ProductRegisterRequest parameter) {

        boolean result = productService.register(parameter);
        model.addAttribute("result", result);

        return "product/register_complete";
    }

}
