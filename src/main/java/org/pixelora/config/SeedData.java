package org.pixelora.config;

import org.pixelora.model.Account;
import org.pixelora.model.Post;
import org.pixelora.services.AccountService;
import org.pixelora.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;
    @Override
    public void run(String... args) throws Exception {

        Account account1=new Account();
        Account account2=new Account();

        account1.setEmail("account01@mail.com");
        account1.setPassword("password");
        account1.setFirstname("user01");

        account2.setEmail("account02@mail.com");
        account2.setPassword("password");
        account2.setFirstname("user02");
        account2.setFirstname("user02");



        //Post Dummy Data into H2 DB
        List<Post> post = postService.getAll();

        if (post.size() == 0){
            Post post01 = new Post();
            post01.setTitle("Post 01");
            post01.setBody("Post 01 body.............");

            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("Post 02");
            post02.setBody("Post 02 body.............");

            postService.save(post02);
        }
    }
}