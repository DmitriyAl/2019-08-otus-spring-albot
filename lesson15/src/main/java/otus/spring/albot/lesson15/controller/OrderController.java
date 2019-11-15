package otus.spring.albot.lesson15.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import otus.spring.albot.lesson15.entity.Order;
import otus.spring.albot.lesson15.service.OrderService;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;

    @GetMapping(value = {"", "orders"})
    public List<Order> welcomePage(Model model) {
        return orderService.getAllOrders();
    }

    @GetMapping(value = "orders/{id}")
    public String order(@PathVariable("id") Long id, Model model) {
        Order orderById = orderService.getOrderById(id);
        model.addAttribute("order", orderById);
        return "pages/order";
    }
}
