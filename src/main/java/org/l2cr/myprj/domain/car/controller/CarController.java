package org.lncr.chatdiscussion.domain.car.controller;

import java.util.List;

import org.lncr.chatdiscussion.domain.car.dto.CarCreateDto;
import org.lncr.chatdiscussion.domain.car.dto.CarDto;
import org.lncr.chatdiscussion.domain.car.dto.CarResponseDto;
import org.lncr.chatdiscussion.domain.car.dto.CarUpdateDto;
import org.lncr.chatdiscussion.domain.car.service.CarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
@Log4j2
public class CarController {
    private final CarService carService;

    // 모든 차량 데이터 조회
    @GetMapping
    public ResponseEntity<List<CarResponseDto>> getAllCars() {
        log.info("getAllCars()...");
        return ResponseEntity.status(HttpStatus.OK).body(carService.getAllCars());
    }

    // Id로 차량 조회
    @GetMapping("/{id}")
    public ResponseEntity<CarResponseDto> getCar(@PathVariable("id") int id) {
        log.info("getCar()..."+id);
        return ResponseEntity.status(HttpStatus.OK).body(carService.getCar(id));
    }
    
    // 차량 등록
    @PostMapping
    public ResponseEntity<CarResponseDto> createCar(@RequestBody CarCreateDto CarCreateDto) {
        log.info("createCar()..."+CarCreateDto.getOwnerId());
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.createCar(CarCreateDto));
    }

    // 차량 수정
    @PostMapping("/{id}")
    public ResponseEntity<CarResponseDto> updateCar(@PathVariable("id") int id, @RequestBody CarUpdateDto CarUpdateDto) {
        log.info("updateCar()..."+id);
        return ResponseEntity.status(HttpStatus.OK).body(carService.updateCar(id, CarUpdateDto));
    }   

    // 차량 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") int id) {
        log.info("deleteCar()..."+id);
        carService.deleteCar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
