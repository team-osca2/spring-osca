package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MessageVO {
    private Long id;
    private Long studyId;
    private Long sender;
    private Long receiver;
    private String messageRegistDate;
    private String messageStatus;
    private String messageRead;
}
