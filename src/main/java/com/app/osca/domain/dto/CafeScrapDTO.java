package com.app.osca.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CafeScrapDTO {
    private Long id;
    private Long memberId;
    private Long cafeId;
    private String cafeLocation;
    private String cafeName;
    private String cafeContactEmail;
    private String cafeContactPhonenumber;
    private String cafeOpenTime;
    private String cafeEndTime;
}
