package com.app.osca.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class Search {
    String type;
    String keyword;
    String order;

    public String[] getTypes(){
        return type.split("");
    }
}
