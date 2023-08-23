package com.app.osca.domain.dto.cafe;

import com.app.osca.domain.CafeImageVO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
public class CafeDTO {
    private Long id;
    private Long memberId;
    private String cafeBusinessNumber;
    private String cafeLocation;
    private String cafeName;
    private String cafeContactEmail;
    private String cafeContactPhoneNumber;
    private String cafeOpenTime;
    private String cafeEndTime;
    List<CafeImageVO> cafeImages;

    @Builder
    public CafeDTO(Long memberId, String cafeBusinessNumber, String cafeLocation, String cafeName) {
        this.memberId = memberId;
        this.cafeBusinessNumber = cafeBusinessNumber;
        this.cafeLocation = cafeLocation;
        this.cafeName = cafeName;
    }
}
