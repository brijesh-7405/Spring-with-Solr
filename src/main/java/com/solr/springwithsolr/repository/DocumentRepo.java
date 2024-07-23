package com.solr.springwithsolr.repository;

import com.solr.springwithsolr.model.Document;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface DocumentRepo extends SolrCrudRepository<Document, String> {
    List<Document> findByDocTitleEndsWith(String title);
    List<Document> findByDocTitleStartsWith(String title);

    List<Document> findByDocTypeEndsWith(String type);

    List<Document> findByDocTypeStartsWith(String type);
}
