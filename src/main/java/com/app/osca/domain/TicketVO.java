package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class TicketVO {
    private Long id;
    private String name;
    private Long point;
}
