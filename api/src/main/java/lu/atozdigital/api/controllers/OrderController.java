package lu.atozdigital.api.controllers;

import lu.atozdigital.api.DTO.OrderDto;
import lu.atozdigital.api.entities.Orders;
import lu.atozdigital.api.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping
    public List<OrderDto> getAllOrders(){
        return orderService.getAllOrders();
    }
    @PostMapping
    public void saveOrder(@RequestBody Orders order){
        orderService.saveOrder(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable("id") Long id){
        Orders orders = orderService.updateOrder(id);
        if (orders!=null){
            return new ResponseEntity<>(orders,HttpStatus.OK);
        }
        return new ResponseEntity<>("Order Not Found !!",HttpStatus.NOT_FOUND);
    }
}
