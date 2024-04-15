package co.com.bonilla.service.http.mapper;

import co.com.bonilla.service.http.dto.FilmDTO;
import co.com.bonilla.service.http.model.Film;

import java.util.List;
import java.util.stream.Collectors;

public class FilmMapper {
    public static FilmDTO domainToDTO(Film film) {
        return FilmDTO.builder()
                .id(film.getId())
                .title(film.getTitle())
                .producer(film.getProducer())
                .duration(film.getDuration())
                .genre(film.getGenre())
                .build();
    }

    public static List<FilmDTO> domainToDTOList(List<Film> films) {
        return films.stream()
                .map(FilmMapper::domainToDTO)
                .collect(Collectors.toList());
    }

    public static Film createDtoToDomain(FilmDTO filmDTO) {
        return Film.builder()
                .title(filmDTO.getTitle())
                .producer(filmDTO.getProducer())
                .duration(filmDTO.getDuration())
                .genre(filmDTO.getGenre())
                .build();
    }

    public static Film updateDtoToDomain(FilmDTO filmDTO) {
        return Film.builder()
                .id(filmDTO.getId())
                .title(filmDTO.getTitle())
                .producer(filmDTO.getProducer())
                .duration(filmDTO.getDuration())
                .genre(filmDTO.getGenre())
                .build();
    }
}
