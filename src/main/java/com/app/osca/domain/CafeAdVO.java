package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CafeAdVO {
    private Long id;
    private String cafeId;
    private String cafeAdTitle;
    private String cafeAdContents;
    private String cafeAdRegistDate;
    private String cafeAdUpdateDate;
    private String cafeAdDeadlineDate;
    private String cafeReportNo;
    private String cafeAdBlocked;
}
