package com.app.osca.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class StudyScrapDTO {
    private Long id;
    private Long memberId;
    private Long studyId;
    private String studyTitle;
    private String studyContents;
    private String studyCurriculum;
    private String studyPeriodDate;
    private String studyMemberTotalNumber;
    private String studyLocation;
    private String studyReportNo;
    private String studyDeadlineDate;
    private String studyStatus;
    private String studyBlocked;
}
