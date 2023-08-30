package com.app.osca.service.ticket.TicketService;

import com.app.osca.dao.TicketDAO;
import com.app.osca.domain.TicketVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    final private TicketDAO ticketDAO;

    @Override
    public List<TicketVO> getAll() {
        return ticketDAO.findAll();
    }
}
