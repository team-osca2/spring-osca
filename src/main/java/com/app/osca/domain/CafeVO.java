package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CafeVO {
    private Long id;
    private Long memberId;
    private String cafeBusinessNumber;
    private String cafeLocation;
    private String cafeName;
    private String cafeContactEmail;
    private String cafeContactPhonenumber;
    private String cafeOpenTime;
    private String cafeEndTime;
}
