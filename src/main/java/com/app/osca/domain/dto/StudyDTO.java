package com.app.osca.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class StudyDTO {
    private Long id;
    private String studyTitle;
    private String memberNickname;
    private String studyRegisterDate;
//    private Long memberRole;
//    private String cafeAdTitle;
//    private String cafeAdRegisterDate;
}

