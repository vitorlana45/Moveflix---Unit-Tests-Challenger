package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(nativeQuery = true, value = """
    SELECT * FROM (
        SELECT DISTINCT tb_movie.id, tb_movie.title, tb_movie.sub_title, tb_movie.movie_year, tb_movie.img_url, tb_movie.synopsis, tb_movie.genre_id
        FROM tb_movie
        INNER JOIN tb_genre ON tb_movie.genre_id = :genreId
        ORDER BY tb_movie.id
    ) AS tb_result
    """, countQuery = """
    SELECT COUNT(*) FROM (
        SELECT DISTINCT tb_movie.id
        FROM tb_movie
        INNER JOIN tb_genre ON tb_movie.genre_id = :genreId
        ORDER BY tb_movie.id
    ) AS tb_result
    """)
    Page<Movie> findByGenreId(Long genreId, Pageable pageable);

    @Query(nativeQuery = true, value = """
    SELECT * FROM tb_movie
    ORDER BY tb_movie.title
    """)
    Page<Movie> findAllOrderedByTitle(Pageable pageable);

}
