package com.example.socksapp.repository;

import com.example.socksapp.enums.Operations;
import com.example.socksapp.model.Sock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SocksRepository extends JpaRepository<Sock, Long> {
    //@Query("SELECT s FROM Sock s WHERE s.color = ?1 AND  = ?2 AND j.isCompleted = false")
//    List<Job> findByCompletedJobs(Long hiveId, Long activityId);
    //Page<Sock> findBy();

    Optional<Sock> findByColorAndCotton(String color, Integer cotton);

    @Modifying
    @Query("update Sock s set s.quantity = :quantity where s.id = :id")
    void updateEntity(@Param(value = "id") Long id, @Param(value = "quantity") Integer quantity);

    List<Sock> findByColorAndCottonLessThan(String color, Integer cotton);

    List<Sock> findByColorAndCottonGreaterThan(String color, Integer cotton);

    List<Sock> findByColorAndCottonEquals(String color, Integer cotton);

}
