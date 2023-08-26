package com.app.osca.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReplyDTO {
    private Long id;
    private Long memberId;
    private Long studyId;
    private String replyContent;
    private String replyBlocked;
    private String reportNo;
    private String replyRegisterDate;
    private String replyUpdateDate;
    private String memberName;
}
