package com.movieflix.service;

import com.movieflix.dto.MovieDTO;
import com.movieflix.repositories.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public MovieDTO addMovie(MovieDTO movieDTO, MultipartFile file) {


        return null;
    }

    @Override
    public MovieDTO getMovie(Integer movieId) {
        return null;
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        return List.of();
    }
}
