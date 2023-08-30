package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ImageVO {
    private Long id;
    private String imagePath;
    private String imageUuid;
    private String imageName;
    private String imageType;
    private Long imageSize;
}
