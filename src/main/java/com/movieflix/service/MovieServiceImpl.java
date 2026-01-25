package com.movieflix.service;

import com.movieflix.dto.MovieDTO;
import com.movieflix.entities.Movie;
import com.movieflix.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    private final FileService fileService;

    @Value("${project.poster}")
    private String path;

    @Value("${base.url}")
    private String baseUrl;

    public MovieServiceImpl(MovieRepository movieRepository, FileService fileService) {
        this.movieRepository = movieRepository;
        this.fileService = fileService;
    }


    @Override
    public MovieDTO addMovie(MovieDTO movieDTO, MultipartFile file) throws IOException {
        // 1. Upload the file
        String uploadFileName = fileService.uploadFile(path, file);

        // 2. Set the value of field 'poster' as file
        movieDTO.setPoster(uploadFileName);

        // 3. Map DTO to Movie object
        Movie movie = new Movie(
                null,
                movieDTO.getTitle(),
                movieDTO.getDirector(),
                movieDTO.getStudio(),
                movieDTO.getMovieCast(),
                movieDTO.getReleaseYear(),
                movieDTO.getPoster()
        );

        // 4. Save the movie object -> saved Movie object
        Movie savedMovie = movieRepository.save(movie);

        // 5. Generate the posterUrl
        String posterUrl = baseUrl + "/file/" + uploadFileName;

        // 6. map Movie object to DTO object and return it
        MovieDTO response = new MovieDTO(
                savedMovie.getMovieId(),
                savedMovie.getTitle(),
                savedMovie.getDirector(),
                savedMovie.getStudio(),
                savedMovie.getMovieCast(),
                savedMovie.getReleaseYear(),
                savedMovie.getPoster(),
                posterUrl
        );

        return response;
    }

    @Override
    public MovieDTO getMovie(Integer movieId) {
        // 1. check the data in DB and if exists, fetch the data of given ID
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie name not found"));

        // 2. generate posterUrl
        String posterUrl = baseUrl + "/file/" + movie.getPoster();

        // 3. map tp MovieDto
        MovieDTO response = new MovieDTO(
                movie.getMovieId(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getStudio(),
                movie.getMovieCast(),
                movie.getReleaseYear(),
                movie.getPoster(),
                posterUrl
        );

        return response;
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        // 1. fetch all data from DB
        List<Movie> movies = movieRepository.findAll();

        List<MovieDTO> movieDTOs = new ArrayList<>();

        // 2. iterate through the list, generate posterUrl for each movie obj,
        // and map to MovieDto obj
        for(Movie movie : movies) {
            String posterUrl = baseUrl + "/file/" + movie.getPoster();
            MovieDTO movieDTO = new MovieDTO(
                    movie.getMovieId(),
                    movie.getTitle(),
                    movie.getDirector(),
                    movie.getStudio(),
                    movie.getMovieCast(),
                    movie.getReleaseYear(),
                    movie.getPoster(),
                    posterUrl
            );
            movieDTOs.add(movieDTO);
        }

        return movieDTOs;
    }
}
