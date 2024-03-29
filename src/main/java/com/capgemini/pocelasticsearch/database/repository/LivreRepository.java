package com.capgemini.pocelasticsearch.database.repository;

import com.capgemini.pocelasticsearch.database.documents.LivreDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends ElasticsearchRepository<LivreDocument, String> {



}
