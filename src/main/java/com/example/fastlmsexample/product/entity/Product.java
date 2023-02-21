package com.example.fastlmsexample.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String productId;
    private String productName;
    private String createDt;
    private String endDt;

    private LocalDateTime registerDt;

}
