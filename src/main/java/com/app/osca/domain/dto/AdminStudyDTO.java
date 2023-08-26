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
    private String memberNickname;
    private String studyRegisterDate;
//    private Long memberRole;
//    private String cafeAdTitle;
//    private String cafeAdRegisterDate;
}

