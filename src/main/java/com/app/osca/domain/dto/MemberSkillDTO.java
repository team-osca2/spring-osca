package com.app.osca.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberSkillDTO {
    private Long id;
    private Long memberId;
    private Long skillListId;
    private String skill;
}
