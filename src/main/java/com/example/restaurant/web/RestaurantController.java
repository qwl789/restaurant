package com.example.restaurant.web;

import com.example.restaurant.entity.MenuItem;
import com.example.restaurant.entity.Order;
import com.example.restaurant.repository.MenuItemRepository;
import com.example.restaurant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@Controller
public class RestaurantController {

    @Autowired
    private MenuItemRepository menuItemRepository;
    @Autowired
    private OrderRepository orderRepository;

    // 首页：展示菜单
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("menuItems", menuItemRepository.findAll());
        model.addAttribute("order", new Order()); // 用于表单绑定
        return "index";
    }

    // 新增：查看订单列表页面
    @GetMapping("/orders")
    public String orderList(Model model) {
        // 查询所有订单，并按时间倒序排列（最新的在最上面）
        model.addAttribute("orders", orderRepository.findAll(Sort.by(Sort.Direction.DESC, "orderTime")));
        return "orders";
    }

    @PostMapping("/order")
    public String placeOrder(Order order, Model model) {
        // 1. 根据前端传来的菜名，去数据库查单价
        MenuItem item = menuItemRepository.findByName(order.getDishName());

        // 2. 如果找到了菜品，计算总价 (单价 * 数量)
        if (item != null) {
            BigDecimal total = item.getPrice().multiply(new BigDecimal(order.getQuantity()));
            order.setTotalPrice(total);
        }

        // 3. 保存订单
        orderRepository.save(order);

        model.addAttribute("msg", "下单成功！您的 " + order.getDishName() + " 正在制作中。");
        model.addAttribute("menuItems", menuItemRepository.findAll());
        model.addAttribute("order", new Order());
        return "index";
    }
}
