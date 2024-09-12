package luisQuiroz.BE_W5_D3.controller;


import luisQuiroz.BE_W5_D3.entities.Author;
import luisQuiroz.BE_W5_D3.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAuthors(){
        return authorService.findAllAuthors();
    }

    @GetMapping("/{authorId}")
    public Author pathParameterExample(@PathVariable int authorId){
        return this.authorService.findById(authorId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createNewAuthor(@RequestBody Author body){
        return this.authorService.saveAuthor(body);
    }

    @PutMapping("/{authorId}")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public Author updateAuthor(@PathVariable int authorId, @RequestBody Author body){
        return this.authorService.findAndUpdateAuthor(authorId, body);
    }

    @DeleteMapping("/{authorId}")
    public String deleteAuthor(@PathVariable int authorId){
        this.authorService.findAndDeleteAuthor(authorId);
        return "Autore eliminato con successo";
    }


}
