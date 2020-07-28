package com.example.repository;

import com.example.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);

    Optional<UserEntity> findById(Integer id);

    @Query(
            value = "SELECT u.id, active, full_name, password, username FROM userdetails u CROSS JOIN user_urls WHERE user_urls.urls = :urls  AND u.id=:user_id ",
            nativeQuery = true)
    UserEntity findByUrlsAndUserId(@Param("urls") String urls,
                                   @Param("user_id") Integer user_id);

    @Query(
            value = "SELECT DISTINCT u.id, active, full_name, password, username FROM userdetails u CROSS JOIN user_urls WHERE user_urls.date =:date",
            nativeQuery = true)
    List<UserEntity> findByLocalDate(@Param("date") LocalDate date);
}
