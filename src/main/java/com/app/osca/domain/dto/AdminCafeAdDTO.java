package com.app.osca.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AdminCafeAdDTO {
    private Long id;
    private String cafeAdTitle;
    private String cafeName;
    private String memberNickname;
    private String cafeAdRegisterDate;
}

