package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class StudyVO {
    private Long id;
    private Long memberId;
    private String studyTitle;
    private String studyContents;
    private String studyCurriculum;
    private String studyPeriodDate;
    private String studyMemberTotalNumber;
    private String studyLocation;
    private String studyReportNo;
    private String studyRegisterDate;
    private String studyUpdateDate;
    private String studyApplyDeadline;
    private String studyStatus;
    private String studyBlocked;
}
