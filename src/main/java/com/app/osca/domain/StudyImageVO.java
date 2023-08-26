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
    private String imagePath;
    private String imageUuid;
    private String imageName;
    private Long imageSize;
    private String imageType;

}
