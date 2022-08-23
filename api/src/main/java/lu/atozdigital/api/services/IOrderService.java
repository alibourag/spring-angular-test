package lu.atozdigital.api.services;

import lu.atozdigital.api.DTO.OrderDto;
import lu.atozdigital.api.entities.Orders;


import java.util.List;

public interface IOrderService {
    public List<OrderDto> getAllOrders();
    public void saveOrder(Orders order);
    public Orders updateOrder(Long id);
}
