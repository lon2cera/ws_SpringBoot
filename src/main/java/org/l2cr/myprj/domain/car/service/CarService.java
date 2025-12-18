package org.lncr.chatdiscussion.domain.car.service;

import java.util.List;

import org.lncr.chatdiscussion.domain.car.dto.CarCreateDto;
import org.lncr.chatdiscussion.domain.car.dto.CarResponseDto;
import org.lncr.chatdiscussion.domain.car.dto.CarUpdateDto;

public interface CarService {

    List<CarResponseDto> getAllCars();

    CarResponseDto getCar(int id);

    CarResponseDto createCar(CarCreateDto CarCreateDto);

    CarResponseDto updateCar(int id, CarUpdateDto carUpdateDto);

    void deleteCar(int id);

}
