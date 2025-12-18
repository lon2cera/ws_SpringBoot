package org.lncr.chatdiscussion.domain.car.repository;

// import java.util.List;

import org.lncr.chatdiscussion.domain.car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

public interface CarRepository extends JpaRepository<Car, Integer> {

    // List<Car> findByColor(String color);
    // List<Car> findByModelYear(int modelYear);
    // List<Car> findByBrandAndModel(String brand, String model);
    // List<Car> findByBrandOrColor(String brand, String color);
    // List<Car> findByBrandOrderByModelYearAsc(String brand);

    // @Query("SELECT c FROM Car c WHERE c.price >= :price")
    // List<Car> findByPriceGreaterThanEqual(@Param("price") int price);

    // @Query("SELECT c FROM Car c WHERE c.brand = ?1")
    // List<Car> findByBrand(String brand);
}
