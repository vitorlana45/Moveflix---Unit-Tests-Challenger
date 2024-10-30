package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.services.MovieService;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<MovieDetailsDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(movieService.findById(id));
    }


    @GetMapping("/movies")
    public ResponseEntity<Page<MovieDetailsDTO>> findByGenre(@RequestParam(value = "genreId",  required = false) Long genreId, Pageable pageable) {
        return ResponseEntity.ok().body(movieService.findByGenre(genreId, pageable));
    }

}
