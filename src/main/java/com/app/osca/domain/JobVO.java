package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class JobVO {
    private Long jobCategoryId;
    private String job;
    private Long id;
}
