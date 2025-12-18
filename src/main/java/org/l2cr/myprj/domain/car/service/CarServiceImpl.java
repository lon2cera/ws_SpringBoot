package org.lncr.chatdiscussion.domain.car.service;

import java.util.List;

import org.lncr.chatdiscussion.domain.car.dto.CarCreateDto;
import org.lncr.chatdiscussion.domain.car.dto.CarResponseDto;
import org.lncr.chatdiscussion.domain.car.dto.CarUpdateDto;
import org.lncr.chatdiscussion.domain.car.entity.Car;
import org.lncr.chatdiscussion.domain.car.repository.CarRepository;
import org.lncr.chatdiscussion.domain.owner.entity.Owner;
import org.lncr.chatdiscussion.domain.owner.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;

    // 모든 차량 데이터 조회
    public List<CarResponseDto> getAllCars(){
        return carRepository.findAll()
                        .stream()
                        .map(CarResponseDto::new)
                        .toList();
    }
    
    // ID로 차량 조회
    public CarResponseDto getCar(int id){
        log.info("getCar()..."+id);
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        return new CarResponseDto(car);
    }

    // 차량 등록
    public CarResponseDto createCar(CarCreateDto CarCreateDto){
        log.info("createCar()..."+CarCreateDto.getOwnerId());
        Owner owner = ownerRepository.findById(CarCreateDto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner not found with id: " + CarCreateDto.getOwnerId()));
        Car car = CarCreateDto.toEntity(owner);
        Car savedCar = carRepository.save(car);
        return new CarResponseDto(savedCar);
    }

    // 차량 수정
    public CarResponseDto updateCar(int id, CarUpdateDto CarUpdateDto){
        log.info("updateCar()..."+id);
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        Owner owner = ownerRepository.findById(CarUpdateDto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner not found with id: " + CarUpdateDto.getOwnerId()));
        car.updateCar(
                CarUpdateDto.getColor(),
                CarUpdateDto.getPrice(),
                owner
        );
        Car updatedCar =  carRepository.save(car);
        return new CarResponseDto(updatedCar);
    }

    // 차량 삭제
    public void deleteCar(int id){
        log.info("deleteCar()..."+id);
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        carRepository.delete(car);
    }
}
