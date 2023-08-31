package com.app.osca.dao;

import com.app.osca.domain.StateEnum;
import com.app.osca.domain.dto.ticket.TicketPurchaseDTO;
import com.app.osca.mapper.TicketPurchaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TicketPurchaseDAO {
    private final TicketPurchaseMapper ticketPurchaseMapper;

    public StateEnum save(TicketPurchaseDTO ticketPurchaseDTO){
        return ticketPurchaseMapper.insert(ticketPurchaseDTO) == 1 ? StateEnum.SUCCESS : StateEnum.FAIL;
    }
}