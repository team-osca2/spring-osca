package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ReplyVO {
    private Long id;
    private Long memberId;
    private Long studyId;
    private String replyContent;
    private String replyBlocked;
    private String replyRegistDate;
    private String replyUpdateDate;
}
