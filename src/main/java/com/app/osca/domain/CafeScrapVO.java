package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CafeScrapVO {
    private Long id;
    private Long memberId;
    private Long cafeId;
}
