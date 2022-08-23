package lu.atozdigital.api.services;

import lu.atozdigital.api.DTO.OrderDto;
import lu.atozdigital.api.Repositories.OrderRepository;
import lu.atozdigital.api.entities.Orders;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Orders> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();

        orders.forEach(order -> {
            OrderDto orderDto = new OrderDto();
            orderDto.date = new Date();
            orderDto.reference = order.getReference();
            orderDtos.add(orderDto);
        });
        return orderDtos;
    }

    @Override
    public void saveOrder(Orders order) {
        order.setDate(new Date());
        orderRepository.save(order);
    }

    @Override
    public Orders updateOrder(Long id) {
        Optional<Orders> orders = orderRepository.findById(id);
        if(orders.isPresent()){
            orders.get().setDate(new Date());
            return orderRepository.save(orders.get());
        }
        return null;
    }
}
