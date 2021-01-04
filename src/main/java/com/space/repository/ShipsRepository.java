package com.space.repository;

import com.space.controller.Order;
import com.space.model.Ship;
import com.space.model.ShipType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShipsRepository extends JpaRepository<Ship, Long> {

    //Ship findById(Long id);

    @Query("select s from Ship s where (:name is null or s.name like %:name%) " +
            "and (:planet is null or s.planet like %:planet%) " +
            "and (:after is null or s.prodDate >= :after) " +
            "and (:before is null or s.prodDate <= :before) " +
            "and (:minCrewSize is null or s.crewSize >= :minCrewSize) " +
            "and (:maxCrewSize is null or s.crewSize <= :maxCrewSize) " +
            "and (:shipType is null or s.shipType = :shipType) " +
            "and (:isUsed is null or s.isUsed = :isUsed) " +
            "and (:maxSpeed is null or s.speed <= :maxSpeed) " +
            "and (:minSpeed is null or s.speed >= :minSpeed) " +
            "and (:maxRating is null or s.rating <= :maxRating) " +
            "and (:minRating is null or s.rating >= :minRating) " +
            "")

    List<Ship> findByOrder(@Param("name") String name,
                           @Param("planet") String planet,
                           @Param("after") Date after,
                           @Param("before") Date before,
                           @Param("minCrewSize") Integer minCrewSize,
                           @Param("maxCrewSize") Integer maxCrewSize,
                           @Param("shipType") ShipType shipType,
                           @Param("isUsed") Boolean isUsed,
                           @Param("maxSpeed") Double maxSpeed,
                           @Param("minSpeed") Double minSpeed,
                           @Param("maxRating") Double maxRating,
                           @Param("minRating") Double minRating,
                           Pageable pageable);


    @Query("select s from Ship s where (:name is null or s.name like %:name%) " +
            "and (:planet is null or s.planet like %:planet%) " +
            "and (:after is null or s.prodDate >= :after) " +
            "and (:before is null or s.prodDate <= :before) " +
            "and (:minCrewSize is null or s.crewSize >= :minCrewSize) " +
            "and (:maxCrewSize is null or s.crewSize <= :maxCrewSize) " +
            "and (:shipType is null or s.shipType = :shipType) " +
            "and (:isUsed is null or s.isUsed = :isUsed) " +
            "and (:maxSpeed is null or s.speed <= :maxSpeed) " +
            "and (:minSpeed is null or s.speed >= :minSpeed) " +
            "and (:maxRating is null or s.rating <= :maxRating) " +
            "and (:minRating is null or s.rating >= :minRating) " +
            "")

    List<Ship> countByOrder(@Param("name") String name,
                           @Param("planet") String planet,
                           @Param("after") Date after,
                           @Param("before") Date before,
                           @Param("minCrewSize") Integer minCrewSize,
                           @Param("maxCrewSize") Integer maxCrewSize,
                           @Param("shipType") ShipType shipType,
                           @Param("isUsed") Boolean isUsed,
                           @Param("maxSpeed") Double maxSpeed,
                           @Param("minSpeed") Double minSpeed,
                           @Param("maxRating") Double maxRating,
                           @Param("minRating") Double minRating);
}
