package luisQuiroz.BE_W5_D3.services;

import lombok.extern.slf4j.Slf4j;
import luisQuiroz.BE_W5_D3.controller.AuthorController;
import luisQuiroz.BE_W5_D3.entities.Author;
import luisQuiroz.BE_W5_D3.exceptions.BadRequestException;
import luisQuiroz.BE_W5_D3.exceptions.NotFoundException;
import luisQuiroz.BE_W5_D3.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@Slf4j
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

//    private List<Author> allAuthors = new ArrayList<>();
//
//    public List<Author> findAllAuthors(){
//        return this.allAuthors;
//    }
//
//   public Author saveAuthor(Author body){
//       Random random = new Random();
//       body.setId(random.nextInt(1, 1000000));
//       body.setUrlAvatar("https://ui-avatars.com/api/?name="+body.getNome()+"+"+body.getCognome());
//       this.allAuthors.add(body);
//       return body;
//   }
//
//   public Author findAndUpdateAuthor(int authorId, Author body){
//        Author af = this.findById(authorId);
//        af.setNome(body.getNome());
//        af.setCognome(body.getCognome());
//        af.setDataDiNascita(body.getDataDiNascita());
//        af.setUrlAvatar("https://ui-avatars.com/api/?name="+body.getNome()+"+"+body.getCognome());
//
//        return af;
//   }
//
//   public Author findById(int authorId){
//        return allAuthors.stream().filter(author -> author.getId().equals(authorId)).findFirst().get();
//   }
//
//   public void findAndDeleteAuthor(int id){
//        this.allAuthors.remove(this.findById(id));
//   }
    // ----------------------------------------esercizio di mercoledì-----------------------------------------------------


    public List<Author> findAll(){
        return this.authorRepository.findAll();
    }

    public Author findById(UUID authorId){
        return this.authorRepository.findById(authorId).orElseThrow(() -> new NotFoundException("Autore con id " + authorId + " non è stato trovato"));
    }

    public Author saveAuthor(Author body){
        // 1. controllare che l'autore non sia già registrato
        if (this.authorRepository.existsByEmail(body.getEmail())) throw new BadRequestException("Autore con email " + body.getEmail() + " esiste già!!!");

        // 2. aggiungere campi auto-generati
        body.setUrlAvatar("https://ui-avatars.com/api/?name="+body.getNome()+"+"+body.getCognome());

        // 3. salvare l'autore
        return this.authorRepository.save(body);

    }

    public Author findAndUpdate(UUID authorId, Author body){
        Author authorFound = this.findById(authorId);
        authorFound.setNome(body.getNome());
        authorFound.setCognome(body.getCognome());
        authorFound.setDataDiNascita(body.getDataDiNascita());
        // verifichiamo che la nuova email non sia già utilizzata

        if (this.authorRepository.existsByEmail(body.getEmail())) throw new RuntimeException("L'email inserita esiste già!");
        authorFound.setEmail(body.getEmail());
        authorFound.setUrlAvatar("https://ui-avatars.com/api/?name="+body.getNome()+"+"+body.getCognome());

        // alla fine mandare il nuovo body indietro
        return this.authorRepository.save(authorFound);
    }

    public void findAndDelete(UUID authorId){

        Author foundToDelete = this.findById(authorId);

        this.authorRepository.delete(foundToDelete);
    }


}
