package com.app.osca.dao;

import com.app.osca.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MessageDAO {
    private final MessageMapper messageMapper;
}
