package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class FaqVO {
    private Long id;
    private String faqTitle;
    private String faqContent;
    private String faqType;
}
