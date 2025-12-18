package org.lncr.chatdiscussion.domain.car.entity;

import org.lncr.chatdiscussion.domain.owner.entity.Owner;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Car {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //기본 키

    private String brand, model, color, regNumber;

    private int modelYear, price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Builder
    public Car(String brand, String model, String color, String regNumber, int modelYear, int price, Owner owner){
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.regNumber = regNumber;
        this.modelYear = modelYear;
        this.price = price;
        this.owner = owner;
    }

    public void updateCar(String color, int price,Owner owner){
        this.color = color;
        this.price = price;
        this.owner = owner;
    }
}
