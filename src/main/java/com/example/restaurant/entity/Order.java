package com.example.restaurant.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

// 订单实体
@Entity
@Data
@Table(name = "restaurant_order") // Order是SQL关键字，建议改表名
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String dishName;
    private Integer quantity;

    // 新增：记录订单总金额
    private BigDecimal totalPrice;

    // 默认状态 (模拟：已下单、制作中、已完成)
    private String status = "待制作";

    private LocalDateTime orderTime = LocalDateTime.now();
}
