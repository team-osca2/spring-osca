package com.app.osca.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberJobDTO {
    private Long id;
    private Long memberId;
    private Long jobId;
    private String job;
}
