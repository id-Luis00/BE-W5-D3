package luisQuiroz.BE_W5_D3.controller;


import jakarta.websocket.server.PathParam;
import luisQuiroz.BE_W5_D3.entities.BlogPost;
import luisQuiroz.BE_W5_D3.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BlogPosts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    public List<BlogPost> printAllBlogs(){
        return this.blogPostService.findAllBlogs();
    }

    @GetMapping("/{blogId}")
    public BlogPost findSingleBlog(@PathVariable int blogId){
        return this.blogPostService.findById(blogId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveNewBlogPost(@RequestBody BlogPost body){
        return this.blogPostService.saveNewBlog(body);
    }

    @PutMapping("/{blogId}")
    public BlogPost findAndUpdate(@PathVariable int blogId, @RequestBody BlogPost body){
        return this.blogPostService.findAndUpdateBlog(blogId, body);
    }

    @DeleteMapping("/{blogId}")
    public String findAndDelete(@PathVariable int blogId){
        this.blogPostService.findAndDelete(blogId);
        return "Blog " + blogId + " eliminato";
    }
}
