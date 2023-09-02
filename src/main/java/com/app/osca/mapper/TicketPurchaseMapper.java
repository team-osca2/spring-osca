package com.app.osca.mapper;

import com.app.osca.domain.dto.ticket.TicketPurchaseDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TicketPurchaseMapper {
    public Integer insert(TicketPurchaseDTO ticketPurchaseDTO);
}
