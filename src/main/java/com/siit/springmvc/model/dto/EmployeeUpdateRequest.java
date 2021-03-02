package com.siit.springmvc.model.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateRequest {

    private int id;

    @Size(min = 1, max = 90)
    private String job;

    @NotNull
    @Min(1)
    @Max(99999999)
    private Integer manager;

    @NotBlank
    private String name;

    @Min(300)
    private Integer salary;

}
