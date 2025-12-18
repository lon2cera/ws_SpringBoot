package org.lncr.chatdiscussion.domain.car.dto;

import org.lncr.chatdiscussion.domain.car.entity.Car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CarResponseDto {
    private int id;
    private String brand, model, color, regNumber;
    private int modelYear, prive;
    private String ownerName;

    public CarResponseDto(Car car){
        this.id = car.getId();
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.color = car.getColor();
        this.regNumber = car.getRegNumber();
        this.modelYear = car.getModelYear();
        this.prive = car.getPrice();
        this.ownerName = car.getOwner().getFirstname() + " " + car.getOwner().getLastname();
    }
}
