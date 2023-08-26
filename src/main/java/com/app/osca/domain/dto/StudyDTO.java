package com.app.osca.domain.dto;

import com.app.osca.domain.StudyImageVO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

@Component
@Data
@NoArgsConstructor
public class StudyDTO {
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
    private List<StudyImageVO> files = new ArrayList<>();
    private List<Long> fileIdsForDelete = new ArrayList<>();
}
