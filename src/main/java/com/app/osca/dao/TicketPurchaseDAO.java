package com.app.osca.dao;

import com.app.osca.mapper.TicketPurchaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TicketPurchaseDAO {
    private final TicketPurchaseMapper ticketPurchaseMapper;
}