package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberJobVO {
    private Long id;
    private Long memberId;
    private Long jobCategoryId;
    private Long jobId;
}
