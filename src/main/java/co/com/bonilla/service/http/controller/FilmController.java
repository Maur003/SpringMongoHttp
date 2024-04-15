package co.com.bonilla.service.http.controller;

import co.com.bonilla.service.http.dto.FilmDTO;
import co.com.bonilla.service.http.service.FilmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/film")
@RestController
public class FilmController {

    private final FilmService filmService;

    @GetMapping(path = "/getFilmById/{id}", produces = "application/json")
    public ResponseEntity getFilmById(@PathVariable String id) {
        try{

            return new ResponseEntity(filmService.getFilmById(id), HttpStatus.OK);

        } catch (Exception e) {
            log.error("Error getting film by id", e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/createFilm", produces = "application/json")
    public ResponseEntity createFilm(@RequestBody FilmDTO filmDTO) {
        try{

            return new ResponseEntity(filmService.createFilm(filmDTO), HttpStatus.OK);

        } catch (Exception e) {
            log.error("Error creating film", e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/updateFilm", produces = "application/json")
    public ResponseEntity updateFilm(@RequestBody FilmDTO filmDTO) {
        try{

            return new ResponseEntity(filmService.updateFilm(filmDTO), HttpStatus.OK);

        } catch (Exception e) {
            log.error("Error updating film", e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/getAllFilms", produces = "application/json")
    public ResponseEntity getAllFilms() {

        return new ResponseEntity(filmService.getAllFilms(), HttpStatus.OK);

    }

    @DeleteMapping(path = "/deleteFilm/{id}", produces = "application/json")
    public ResponseEntity deleteFilm(@PathVariable String id) {
        try{

            filmService.deleteFilm(id);
            return new ResponseEntity(HttpStatus.OK);

        } catch (Exception e) {
            log.error("Error deleting film", e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/getFilmHeaders/{id}", method = RequestMethod.HEAD)
    public ResponseEntity getFilmHeaders(@PathVariable String id) {
        try{

            return new ResponseEntity(filmService.getFilmHeaders(id), HttpStatus.OK);

        } catch (Exception e) {
            log.error("Error getting film headers", e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/options", method = RequestMethod.OPTIONS)
    public ResponseEntity options() {

            return new ResponseEntity(filmService.options(), HttpStatus.OK);
    }

    @PatchMapping(path = "/patchFilm/{id}", produces = "application/json")
    public ResponseEntity patchFilm(@PathVariable String id, @RequestBody FilmDTO filmDTO) {
        try{

            return new ResponseEntity(filmService.patchFilm(id, filmDTO), HttpStatus.OK);

        } catch (Exception e) {
            log.error("Error patching film", e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
