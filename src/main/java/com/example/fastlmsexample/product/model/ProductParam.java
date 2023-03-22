package com.example.fastlmsexample.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductParam {

    long pageIndex;
    long pageSize;

    String productType;
    String productValue;

    String productId;


    public long getPageStart() {
        init();
        return (pageIndex - 1) * pageSize;
    }

    public long getPageEnd() {
        init();
        return pageSize;
    }

    public void init() {
        if (pageIndex < 1) {
            pageIndex = 1;
        }

        if (pageSize < 10) {
            pageSize = 10;
        }
    }

    public String getQueryString() {
        init();

        StringBuilder sb = new StringBuilder();

        if (productType != null && productType.length() > 0) {
            sb.append(String.format("productType=%s", productType));
        }



        if (productValue != null && productValue.length() > 0) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("productValue=%s", productValue));
        }
        return sb.toString();
    }
}
