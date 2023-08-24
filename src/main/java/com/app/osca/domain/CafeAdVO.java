package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CafeAdVO {
    private Long id;
    private Long cafeId;
    private String cafeAdTitle;
    private String cafeAdContents;
    private String cafeAdRegisterDate;
    private String cafeAdUpdateDate;
    private String cafeAdDeadlineDate;
    private String cafeAdReportNo;
    private String cafeAdBlocked;
}
