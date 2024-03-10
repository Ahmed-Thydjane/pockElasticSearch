package com.capgemini.pocelasticsearch.service;

import com.capgemini.pocelasticsearch.database.documents.LivreDocument;
import com.capgemini.pocelasticsearch.database.repository.LivreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivreService {

    private final LivreRepository repository;


    @Autowired
    public LivreService(LivreRepository repository) {
        this.repository = repository;
    }

    public void save(final LivreDocument livre) {
        repository.save(livre);
    }

    public LivreDocument findById(final String id) {
        return repository.findById(id).orElse(null);
    }

    public Page<LivreDocument> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Page<LivreDocument> findByAuthor(String authorName){
        return null;
    }


}
