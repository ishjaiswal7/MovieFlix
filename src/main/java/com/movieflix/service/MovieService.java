package com.movieflix.service;

import com.movieflix.dto.MovieDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MovieService {

    MovieDTO addMovie(MovieDTO movieDTO, MultipartFile file);

    MovieDTO getMovie(Integer movieId);

    List<MovieDTO> getAllMovies();

}
