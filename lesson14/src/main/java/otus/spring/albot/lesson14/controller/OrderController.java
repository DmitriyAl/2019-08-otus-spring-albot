package otus.spring.albot.lesson14.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import otus.spring.albot.lesson14.entity.Order;
import otus.spring.albot.lesson14.service.OrderService;

@Controller
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;

    @GetMapping(value = {"", "orders"})
    public String welcomePage(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "pages/orders";
    }

    @GetMapping(value = "orders/{id}")
    public String order(@PathVariable("id") Long id, Model model) {
        Order orderById = orderService.getOrderById(id);
        model.addAttribute("order", orderById);
        return "pages/order";
    }
}