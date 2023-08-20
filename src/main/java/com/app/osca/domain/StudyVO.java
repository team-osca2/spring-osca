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
    private String studyLocation;
    private String studyRegisterDate;
    private String studyUpdateDate;
    private Integer studyTotal;
    private String studyOpen;
    private String studyBlocked;
}
