package com.app.osca.domain.dto.cafeAd;

import com.app.osca.domain.CafeImageVO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
public class CafeAdImagesDTO {
    private Long id;
    private String cafeAdTitle;
    private String cafeAdContents;
    private String cafeAdDeadlineDate;
    private String cafeAdReportNo;
    private String cafeAdBlocked;
    private Long cafeId;
    private String cafeLocation;
    private String cafeName;
    private String cafeOpenTime;
    private String cafeEndTime;
    List<CafeImageVO> cafeImages;

    @Builder
    public CafeAdImagesDTO(Long cafeId, String cafeAdTitle, String cafeAdContents, String cafeAdDeadlineDate) {
        this.cafeId = cafeId;
        this.cafeAdTitle = cafeAdTitle;
        this.cafeAdContents = cafeAdContents;
        this.cafeAdDeadlineDate = cafeAdDeadlineDate;
    }
}
