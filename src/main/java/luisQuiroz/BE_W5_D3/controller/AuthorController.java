package luisQuiroz.BE_W5_D3.controller;


import luisQuiroz.BE_W5_D3.entities.Author;
import luisQuiroz.BE_W5_D3.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

//    @GetMapping
//    public List<Author> getAuthors(){
//        return authorService.findAllAuthors();
//    }
//
//    @GetMapping("/{authorId}")
//    public Author pathParameterExample(@PathVariable int authorId){
//        return this.authorService.findById(authorId);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Author createNewAuthor(@RequestBody Author body){
//        return this.authorService.saveAuthor(body);
//    }
//
//    @PutMapping("/{authorId}")
//    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
//    public Author updateAuthor(@PathVariable int authorId, @RequestBody Author body){
//        return this.authorService.findAndUpdateAuthor(authorId, body);
//    }
//
//    @DeleteMapping("/{authorId}")
//    public String deleteAuthor(@PathVariable int authorId){
//        this.authorService.findAndDeleteAuthor(authorId);
//        return "Autore eliminato con successo";
//    }


//--------------------------------------------ESERCIZIO MERCOLEDI------------------------------------------------------

    // * GET tutti gli autori
    @GetMapping
    // cosa incredibilmente utile per evitare di sovraccaricare il response
    public Page<Author> findAllAuthors(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "5") int size) {
        return this.authorService.findAll(page, size);
    }

    // * GET singolo autore
    @GetMapping("/{authorId}")
    // Spring gestisce da solo il problema dell'UUID trasformandolo in una stringa
    public Author findById(@PathVariable UUID authorId) {
        return this.authorService.findById(authorId);
    }

    // * POST crea nuovo autore
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author body) {
        return this.authorService.saveAuthor(body);
    }

    // * PUT modifica autore per id
    @PutMapping("/{authorId}")
    public Author findAndUpdate(@PathVariable UUID authorId, @RequestBody Author body) {
        return this.authorService.findAndUpdate(authorId, body);
    }


    // * DELETE elimina autore per id
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable UUID authorId) {
        this.authorService.findAndDelete(authorId);
    }


}
