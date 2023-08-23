package com.app.osca.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CafeAdDTO {
    private Long id;
    private String cafeAdTitle;
    private String memberName;
    private String cafeAdDate;
}
