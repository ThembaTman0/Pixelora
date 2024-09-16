package org.pixelora.config;

import org.pixelora.model.Account;
import org.pixelora.model.Authority;
import org.pixelora.model.Post;
import org.pixelora.services.AccountService;
import org.pixelora.services.AuthorityService;
import org.pixelora.services.PostService;
import org.pixelora.util.constants.Authorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SeedData implements CommandLineRunner {


    @Autowired
    private PostService postService;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private AccountService accountService;
    @Override
    public void run(String... args) throws Exception {

        for(Authorities auth: Authorities.values()){
            Authority authority =new Authority();
            authority.setId(auth.getAuthorityId());
            authority.setName(auth.getAuthorityString());


        }

        Account account01=new Account();
        Account account02=new Account();

        account01.setEmail("account01@mail.com");
        account01.setPassword("password");
        account01.setFirstname("user01");
        account01.setLastname("lastname");

        account02.setEmail("account02@mail.com");
        account02.setPassword("password");
        account02.setFirstname("user02");
        account02.setFirstname("user02");
        account02.setLastname("lastname");


        accountService.save(account01);
        accountService.save(account02);

        //Post Dummy Data into H2 DB
        //This might move out once there is an update
        List<Post> post = postService.getAll();

        if (post.size() == 0){
            Post post01 = new Post();
            post01.setTitle("Post 01");
            post01.setAccount(account01);
            post01.setBody("Post 01 body.............");

            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("Post 02");
            post02.setAccount(account02);
            post02.setBody("Post 02 body.............");

            postService.save(post02);
        }
    }
}