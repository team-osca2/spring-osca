package com.app.osca.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AdminStudyDTO {
    private Long id;
    private String studyTitle;
    private String studyRegisterDate;
    private String studyUpdateDate;
    private String studyReportNo;
    private String memberNickname;
    private Long memberRole;
    private String postIds;
}
