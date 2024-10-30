package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.*;
import com.devsuperior.movieflix.repositories.*;
import com.devsuperior.movieflix.services.exceptions.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.*;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final AuthService authService;
    private final MovieRepository movieRepository;

    public ReviewService(ReviewRepository reviewRepository, AuthService authService, MovieRepository movieRepository) {
        this.reviewRepository = reviewRepository;
        this.authService = authService;
        this.movieRepository = movieRepository;
    }

    public ReviewDTO insert(ReviewDTO reviewDTO) {
        var user = authService.authenticated();

        Set<Role> roles = user.getRoles();

        for (Role role : roles) {
            if (role.getAuthority().equals("ROLE_VISITOR")) {
                throw new ForbiddenAccess("Access denied");
            }
        }

        Movie movie = movieRepository.findById(reviewDTO.getMovieId()).orElseThrow(() -> new ResourceNotFoundException("Movie not found"));

        Review newReview = new Review();
        newReview.setText(reviewDTO.getText());
        newReview.setMovie(movie);
        newReview.setUser(user);

        var savedReview = reviewRepository.save(newReview);

        return new ReviewDTO(savedReview);
    }
}