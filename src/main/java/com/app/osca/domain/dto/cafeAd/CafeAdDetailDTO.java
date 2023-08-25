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
public class CafeAdDetailDTO {
    private Long id;
    private String cafeAdTitle;
    private String cafeAdContents;
    private String cafeAdRegisterDate;
    private String cafeAdUpdateDate;
    private String cafeAdDeadlineDate;
    private String cafeAdReportNo;
    private String cafeAdBlocked;
    private Long cafeId;
    private String cafeLocation;
    private String cafeName;
    private String cafeContactEmail;
    private String cafeContactPhonenumber;
    private String cafeOpenTime;
    private String cafeEndTime;
    List<CafeImageVO> cafeImages;

}
