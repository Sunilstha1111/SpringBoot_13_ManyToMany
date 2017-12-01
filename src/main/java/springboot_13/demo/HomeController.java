package springboot_13.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    ActorRepository actorRepository;

    @RequestMapping("/")
    public String index (Model model){
        //First let's create an actor

        Actor actor = new Actor();
        actor.setName ("Sunil Shrestha");
        actor.setRealname("Sunil Dynamite Shrestha");

        //Now let's create a movie

        Movie movie = new Movie();
        movie.setTitle("3 idiots");
        movie.setYear(2009);
        movie.setDescription("About Student life");

        //Add the movie to an empty list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        //Add the list of movies to the actor's movie list
        actor.setMovies(movies);

        //Save the actor to the database
        actorRepository.save(actor);

        //Grab all the actors from the database and send them to the template
        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }
}
