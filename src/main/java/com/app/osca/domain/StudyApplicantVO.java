package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class StudyApplicantVO {
    private Long id;
    private Long memberId;
    private Long studyId;
    private String studyApplicantIntroduction;
    private String studyApplicantMotive;
    private String studyApplicantStatus;
}
