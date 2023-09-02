package com.app.osca.dao;

import com.app.osca.domain.TicketVO;
import com.app.osca.mapper.TicketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TicketDAO {
    private final TicketMapper ticketMapper;

    public List<TicketVO> findAll(){
        return ticketMapper.selectAll();
    }
}