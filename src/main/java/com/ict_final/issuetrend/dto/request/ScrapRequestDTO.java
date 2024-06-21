package com.ict_final.issuetrend.dto.request;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScrapRequestDTO {
    private Long userNo;
    private String articleCode;
}
