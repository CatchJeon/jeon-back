package com.example.catchjeon_back.repository;

import com.example.catchjeon_back.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Game findByMail(String mail);
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Game u WHERE u.mail = :mail AND u.passw = :passw")
    boolean existsByNicknameAndPassword(@Param("mail") String mail, @Param("passw") String passw);
}


