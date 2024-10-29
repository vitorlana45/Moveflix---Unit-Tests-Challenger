package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;
    private final AuthService authService;

    public GenreService(GenreRepository genreRepository, AuthService authService) {
        this.genreRepository = genreRepository;
        this.authService = authService;
    }

    public List<GenreDTO> findAll() {

       authService.authenticated();

        var list = genreRepository.findAll();

        return list.stream().map(GenreDTO::new).toList();
    }
}
