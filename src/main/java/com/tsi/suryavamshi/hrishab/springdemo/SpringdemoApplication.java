package com.tsi.suryavamshi.hrishab.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin
public class SpringdemoApplication {
	@Autowired
	private ActorRepository actRepo;
	@Autowired
	private FilmRepository filmRepo;
	public SpringdemoApplication(ActorRepository actorRepo,FilmRepository filRepo){
		this.actRepo = actorRepo;
		this.filmRepo = filRepo;
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}

	@GetMapping("/allActors")
	public Iterable<Actor> getAllActors(){
		return actRepo.findAll();
	}

	@PostMapping("/addActors")
	public ResponseEntity<Actor> createActor(@RequestBody Actor actor){
		Actor act = actor;
		actRepo.save(act);
		return ResponseEntity.status(HttpStatus.CREATED).body(act);

	}
	@PutMapping("/allActors/{actorID}")
	public ResponseEntity<Actor> updateActor(@RequestBody Actor actor, @PathVariable("actorID")Integer id){
		Optional<Actor> oActor = actRepo.findById(id);
		if (oActor.isPresent()){
			int actorID = oActor.get().getActorID();
			actor.setActorID(actorID);
			actRepo.save(actor);
			return ResponseEntity.status(HttpStatus.OK).body(actor);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(actor);
		}
	}

	@DeleteMapping("/allActors/{actorID}")
	public void deleteActor(@PathVariable("actorID")Integer id){
		actRepo.deleteById(id);
	}


	@GetMapping("/allFilms")
	public Iterable<Film> getAllFilms(){
		return filmRepo.findAll(Sort.by(Sort.Direction.DESC, "title"));
	}

//	@GetMapping("/unreleasedFilms")
//	public Iterable<Film> getAllUnreleased(){
//		return filmRepo.getAllByUnreleased(Sort.by(Sort.Direction.ASC, "release_year"));
//	}
//	@GetMapping("/recentFilms")
//	public Iterable<Film> getAllRecent(){
//		return filmRepo.getAllByRecent(Sort.by(Sort.Direction.DESC, "release_year"));
//	}

	@GetMapping("/allFilms/{langID}")
	public Iterable<Film> getAllLanguage( @PathVariable("langID")Integer id){
		return filmRepo.getAllByLangID(id);
	}

	@PostMapping("/addFilms")
	public ResponseEntity<Film> addFilm(@RequestBody Film filler){
		Film film = filler;
		filmRepo.save(film);
		return ResponseEntity.status(HttpStatus.CREATED).body(film);

	}

	@PutMapping("/addFilms/{filmID}")
	public ResponseEntity<Film> updateFilm(@RequestBody Film film, @PathVariable("filmID")Integer id){
		Optional<Film> oFilm = filmRepo.findById(id);
		if (oFilm.isPresent()){
			int filmID = oFilm.get().getFilmID();
			film.setFilmID(filmID);
			filmRepo.save(film);
			return ResponseEntity.status(HttpStatus.OK).body(film);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(film);
		}
	}

	@DeleteMapping("/allFilms/{filmID}")
	public void deleteFilm(@PathVariable("filmID")Integer id){
		filmRepo.deleteById(id);
	}

}
