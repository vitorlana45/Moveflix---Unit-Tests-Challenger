package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.*;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final AuthService authService;


    public MovieService(MovieRepository movieRepository, AuthService authService) {
        this.movieRepository = movieRepository;
        this.authService = authService;
    }

    public MovieDetailsDTO findById(Long id) {

        authService.authenticated();

        var entity = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        MovieDetailsDTO movieDetailsDTO = new MovieDetailsDTO();
        movieDetailsDTO.setId(entity.getId());
        movieDetailsDTO.setTitle(entity.getTitle());
        movieDetailsDTO.setSubTitle(entity.getSubTitle());
        movieDetailsDTO.setYear(entity.getYear());
        movieDetailsDTO.setImgUrl(entity.getImgUrl());
        movieDetailsDTO.setSynopsis(entity.getSynopsis());
        movieDetailsDTO.setGenre(new GenreDTO(entity.getGenre()));

        return movieDetailsDTO;
    }

    public Page<MovieDetailsDTO> findByGenre(Long genreId, Pageable pageable) {

            authService.authenticated();

            if(genreId != null){
                return convertMovieToDTO(movieRepository.findByGenreId(genreId, pageable));
            }
                return convertMovieToDTO(movieRepository.findAllOrderedByTitle(pageable));
            }

    private Page<MovieDetailsDTO> convertMovieToDTO(Page<Movie> filteredPage) {
        return filteredPage.map(MovieDetailsDTO::new);
    }
}
