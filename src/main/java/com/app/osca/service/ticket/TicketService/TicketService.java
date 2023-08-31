package com.app.osca.service.ticket.TicketService;

import com.app.osca.domain.TicketVO;
import com.app.osca.domain.dto.ticket.TicketDTO;

import java.util.List;

public interface TicketService {
    public List<TicketVO> getAll();
}