package com.app.osca.dao;

import com.app.osca.mapper.TicketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TicketDAO {
    private final TicketMapper ticketMapper;
}