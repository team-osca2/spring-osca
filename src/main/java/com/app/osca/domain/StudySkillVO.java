package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class StudySkillVO {
    private Long id;
    private String skillListId;
    private String studyId;
}
