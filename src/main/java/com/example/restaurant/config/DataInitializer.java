package com.example.restaurant.config;

import com.example.restaurant.entity.MenuItem;
import com.example.restaurant.repository.MenuItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;


@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner initData(MenuItemRepository repository) {
        return args -> {
            // 如果数据库是空的，则初始化数据
            if (repository.count() == 0) {
                // 使用了来自 Unsplash 或其他图床的稳定高质量图片
                repository.save(new MenuItem("宫保鸡丁", "经典川菜，花生酥脆，鸡肉鲜嫩，酸甜微辣。",
                        new BigDecimal("32.00"),
                        "https://images.unsplash.com/photo-1525755662778-989d0524087e?w=500&q=80"));

                repository.save(new MenuItem("秘制红烧肉", "精选五花肉，慢火慢炖，肥而不腻，入口即化。",
                        new BigDecimal("48.00"),
                        "https://images.unsplash.com/photo-1525755662778-989d0524087e?w=500&q=80"));

                repository.save(new MenuItem("蒜蓉西兰花", "新鲜时蔬，大火快炒，保留食材本味，健康清爽。",
                        new BigDecimal("22.00"),
                        "https://images.unsplash.com/photo-1550304943-4f24f54ddde9?w=500&q=80"));

                repository.save(new MenuItem("秘制红烧肉", "精选五花肉，慢火慢炖，肥而不腻，入口即化。",
                        new BigDecimal("48.00"),
                        "https://images.unsplash.com/photo-1525755662778-989d0524087e?w=500&q=80"));

                repository.save(new MenuItem("蒜蓉西兰花", "新鲜时蔬，大火快炒，保留食材本味，健康清爽。",
                        new BigDecimal("22.00"),
                        "https://images.unsplash.com/photo-1550304943-4f24f54ddde9?w=500&q=80"));

                repository.save(new MenuItem("麻辣小龙虾 (大份)", "夏日必备，鲜香麻辣，让你停不下来。",
                        new BigDecimal("99.00"),
                        "https://images.unsplash.com/photo-1550304943-4f24f54ddde9?w=500&q=80"));
                repository.save(new MenuItem("凉拌青瓜 (大份)", "夏日必备，鲜香麻辣，让你停不下来。",
                        new BigDecimal("99.00"),
                        "https://images.unsplash.com/photo-1550304943-4f24f54ddde9?w=500&q=80"));
                repository.save(new MenuItem("水煮鱼 (大份)", "夏日必备，鲜香麻辣，让你停不下来。",
                        new BigDecimal("99.00"),
                        "https://images.unsplash.com/photo-1550304943-4f24f54ddde9?w=500&q=80"));
            }
        };
    }
}
