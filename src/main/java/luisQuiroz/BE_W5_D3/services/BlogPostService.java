package luisQuiroz.BE_W5_D3.services;

import luisQuiroz.BE_W5_D3.entities.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {

    List<BlogPost> allBlogs = new ArrayList<>();

    public List<BlogPost> findAllBlogs(){
        return this.allBlogs;
    }

    public BlogPost findById(int blogId){
        return this.allBlogs.stream().filter(blogPost -> blogPost.getId() == blogId).findFirst().orElseThrow(() -> new RuntimeException("Blog non trovato"));
    }

    public BlogPost saveNewBlog(BlogPost body){
        Random random = new Random();
        body.setId(random.nextInt(1, 100000));
        body.setUrlCover("https://static.vecteezy.com/system/resources/thumbnails/005/545/335/small/user-sign-icon-person-symbol-human-avatar-isolated-on-white-backogrund-vector.jpg");
        body.setTempoDiLettura(random.nextInt(1, 300));
        this.allBlogs.add(body);
        return body;
    }

    public BlogPost findAndUpdateBlog(int blogId, BlogPost body){
        BlogPost blogFound = this.findById(blogId);
        blogFound.setCategoria(body.getCategoria());
        blogFound.setTitolo(body.getTitolo());
        blogFound.setContenuto(body.getContenuto());

        return blogFound;
    }


    public void findAndDelete(int blogId){
        this.allBlogs.remove(this.findById(blogId));
    }


}
