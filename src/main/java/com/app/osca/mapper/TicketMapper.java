package com.app.osca.mapper;

import com.app.osca.domain.TicketVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TicketMapper {
    public List<TicketVO> selectAll();
}
