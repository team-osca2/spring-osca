package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class GeneralVO {
    private Long memberId;
    private Long generalUniversity;
    private Long generalCompany;
    private Long generalWorkDateBegin;
    private Long generalWorkDateEnd;
    private Long generalIntroduction;
    private Long generalCareer;
    private Long generalSalary;
}
