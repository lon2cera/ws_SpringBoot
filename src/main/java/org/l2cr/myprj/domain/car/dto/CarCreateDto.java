package org.lncr.chatdiscussion.domain.car.dto;

import org.lncr.chatdiscussion.domain.car.entity.Car;
import org.lncr.chatdiscussion.domain.owner.entity.Owner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarCreateDto {
    private String brand, model, color, regNumber;
    private int modelYear, price;
    private int ownerId;

    public Car toEntity(Owner owner){
        return Car.builder()
                .brand(brand)
                .model(model)
                .color(color)
                .regNumber(regNumber)
                .modelYear(modelYear)
                .price(price)
                .owner(owner)
                .build();
    }
}
