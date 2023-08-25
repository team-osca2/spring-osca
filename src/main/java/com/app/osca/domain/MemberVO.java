package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberVO {
    private Long id;
    private String memberName;
    private String memberNickname;
    private String memberEmail;
    private String memberPassword;
    private String memberPhonenumber;
    private String memberReportNo;
    private Long memberRole;
    private String memberBlocked;
    private String memberRegistDate;
    private String memberUpdateDate;
}
