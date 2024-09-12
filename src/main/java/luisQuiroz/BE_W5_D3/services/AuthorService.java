package luisQuiroz.BE_W5_D3.services;

import lombok.extern.slf4j.Slf4j;
import luisQuiroz.BE_W5_D3.controller.AuthorController;
import luisQuiroz.BE_W5_D3.entities.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class AuthorService {

    private List<Author> allAuthors = new ArrayList<>();

    public List<Author> findAllAuthors(){
        return this.allAuthors;
    }

   public Author saveAuthor(Author body){
       Random random = new Random();
       body.setId(random.nextInt(1, 1000000));
       body.setUrlAvatar("https://ui-avatars.com/api/?name="+body.getNome()+"+"+body.getCognome());
       this.allAuthors.add(body);
       return body;
   }

   public Author findAndUpdateAuthor(int authorId, Author body){
        Author af = this.findById(authorId);
        af.setNome(body.getNome());
        af.setCognome(body.getCognome());
        af.setDataDiNascita(body.getDataDiNascita());
        af.setUrlAvatar("https://ui-avatars.com/api/?name="+body.getNome()+"+"+body.getCognome());

        return af;
   }

   public Author findById(int authorId){
        return allAuthors.stream().filter(author -> author.getId() == authorId).findFirst().get();
   }

   public void findAndDeleteAuthor(int id){
        this.allAuthors.remove(this.findById(id));
   }

}
