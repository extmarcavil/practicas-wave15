package com.example.hql.repository;

import com.example.hql.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface SeriesRepository extends JpaRepository<Series, Integer> {

    @Query("select serie " +
            "from Season s " +
            "inner join s.serie serie " +
            "left join fetch serie.genre g " +
            "group by serie.id " +
            "having count(s.id) > :cant"
    )
    Stream<Series> findSeriesBySeasonCountGreaterThan(@Param("cant") Long cant);

    @Query("SELECT s " +
            "FROM Series s " +
            "LEFT JOIN fetch s.genre "
    )
    Stream<Series> findSeries();
}