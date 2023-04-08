package com.lorenzo.springit.controller;

import com.lorenzo.springit.domain.Link;
import com.lorenzo.springit.repository.LinkRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/links")
public class LinkController {
    private LinkRepository linkRepository;

    public LinkController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }


    @GetMapping
    public List<Link> list() {
        return this.linkRepository.findAll();
    }

    @GetMapping("/{id}")
    public Link get(@PathVariable Long id) {
        Optional<Link> optional = this.linkRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @PostMapping
    public Link create(@ModelAttribute Link newLink) {
        return this.linkRepository.save(newLink);
    }

    @PutMapping("/{id}")
    public Link update(@PathVariable Long id, @ModelAttribute Link link) {
        return this.linkRepository.save(link);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Link> optional = this.linkRepository.findById(id);
        if (optional.isPresent()) {
            this.linkRepository.delete(optional.get());
        }
    }
}
