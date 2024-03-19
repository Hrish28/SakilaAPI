package com.tsi.suryavamshi.hrishab.springdemo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film,Integer>{

    @Query("SELECT t FROM Film t WHERE t.language= ?1")
    List<Film> getAllByLangID(Integer id);


//    @Query("SELECT u FROM film u WHERE u.release_year > 2024")
//    List<Film> getAllByUnreleased(Sort s);
//
//    @Query("SELECT u FROM film u WHERE u.release_year < 2024")
//    List<Film> getAllByRecent(Sort s);

}
