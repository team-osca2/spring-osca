package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class StudyImageVO {
    private Long imageId;
    private Long studyId;
}
