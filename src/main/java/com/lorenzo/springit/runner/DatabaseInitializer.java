package com.lorenzo.springit.runner;

import com.lorenzo.springit.domain.Comment;
import com.lorenzo.springit.domain.Link;
import com.lorenzo.springit.repository.CommentRepository;
import com.lorenzo.springit.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class DatabaseInitializer implements CommandLineRunner {
    @Autowired
    LinkRepository linkRepository;

    @Autowired
    CommentRepository commentRepository;
    @Override
    public void run(String... args) throws Exception {
        Link link = new Link("Link A", "https://www.google.com");
        linkRepository.save(link);

        Comment comment = new Comment("good link", link);
        commentRepository.save(comment);

        link.addComment(comment);

        System.out.println("Database initizalized");
    }
}
