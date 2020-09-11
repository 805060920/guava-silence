package com.silence.ex.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auth yang
 * @Description
 * @Date 2020/8/21
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SilenceEntity {

    private Long rankId;

    private String rankName;

    private Integer year;

    private String LocationName;

    private String locationCountryName;
}
