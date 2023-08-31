package com.app.osca.service.ticket.TicketService;

import com.app.osca.dao.CafeAdDAO;
import com.app.osca.dao.TicketDAO;
import com.app.osca.domain.TicketVO;
import com.app.osca.domain.dto.ticket.TicketDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    final private TicketDAO ticketDAO;
    final private CafeAdDAO cafeAdDAO;

    @Override
    public List<TicketVO> getAll() {
        return ticketDAO.findAll();
    }

}
