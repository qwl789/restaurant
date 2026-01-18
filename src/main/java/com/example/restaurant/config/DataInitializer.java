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

                repository.save(new MenuItem("番茄鸡蛋菠菜面", "精选五花肉，慢火慢炖，肥而不腻，入口即化。",
                        new BigDecimal("48.00"),
                        "https://images.unsplash.com/photo-1525755662778-989d0524087e?w=500&q=80"));

                repository.save(new MenuItem("手工鸡肉丸", "新鲜时蔬，大火快炒，保留食材本味，健康清爽。",
                        new BigDecimal("22.00"),
                        "https://images.unsplash.com/photo-1550304943-4f24f54ddde9?w=500&q=80"));

                repository.save(new MenuItem("经典猪肉白菜馅儿饺子", "精选五花肉，慢火慢炖，肥而不腻，入口即化。",
                        new BigDecimal("48.00"),
                        "https://images.unsplash.com/photo-1525755662778-989d0524087e?w=500&q=80"));

                repository.save(new MenuItem("柚子茶", "新鲜时蔬，大火快炒，保留食材本味，健康清爽。",
                        new BigDecimal("22.00"),
                        "https://images.unsplash.com/photo-1550304943-4f24f54ddde9?w=500&q=80"));

                repository.save(new MenuItem("仔姜炒肉片", "夏日必备，鲜香麻辣，让你停不下来。",
                        new BigDecimal("99.00"),
                        "https://images.unsplash.com/photo-1550304943-4f24f54ddde9?w=500&q=80"));
                repository.save(new MenuItem("山药鸽子汤", "夏日必备，鲜香麻辣，让你停不下来。",
                        new BigDecimal("99.00"),
                        "https://images.unsplash.com/photo-1550304943-4f24f54ddde9?w=500&q=80"));
                repository.save(new MenuItem("红枣白米粥", "夏日必备，鲜香麻辣，让你停不下来。",
                        new BigDecimal("99.00"),
                        "https://images.unsplash.com/photo-1550304943-4f24f54ddde9?w=500&q=80"));
            }
        };
    }
}
