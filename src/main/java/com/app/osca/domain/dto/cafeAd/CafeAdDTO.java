package com.app.osca.domain.dto.cafeAd;

import com.app.osca.domain.CafeImageVO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Data
public class CafeAdDTO {
    private Long id;
    private Long cafeId;
    private String cafeAdTitle;
    private String cafeAdContents;
    private String cafeAdDeadlineDate;
    private String cafeAdBlocked;
    CafeImageVO cafeImages;
}
