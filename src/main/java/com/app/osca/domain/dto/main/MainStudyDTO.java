package com.app.osca.domain.dto.main;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MainStudyDTO {
    private Long studyId;
    private String studyTitle;
    private Long imageId;
    private String imagePath;
    private String imageUuid;
    private String imageName;
    private String imageType;
    private String imageSize;
}
