package com.app.osca.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor

public class AdminReplyDTO {

    private Long id;
    private String replyContent;
    private String studyTitle;
    private String memberNickname;
    private String replyRegisterDate;
    private String replyUpdateDate;
    private String replyReportNo;
}