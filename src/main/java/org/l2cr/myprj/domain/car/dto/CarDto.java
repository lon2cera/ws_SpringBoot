package org.lncr.chatdiscussion.domain.car.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {
    private String brand;
    private String model; 
    private String color;
    private String regNumber;
    private int modelYear;
    private int price;
    private int ownerId;

}
