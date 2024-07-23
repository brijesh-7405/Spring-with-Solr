package com.solr.springwithsolr.controller;


import com.solr.springwithsolr.model.Document;
import com.solr.springwithsolr.repository.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SpringSolrController {
    @Autowired
    private DocumentRepo documentRepo;

    @RequestMapping("/")
    public String SpringBootSolrExample() {
        return "Welcome to Spring Boot solr Example";
    }
    @RequestMapping("/deleteAll")
    public String deleteAllDocuments() {
        try { //delete all documents from solr core
            documentRepo.deleteAll();
            return "documents deleted succesfully!";
        }catch (Exception e){
            return "Failed to delete documents";
        }
    }
//    @RequestMapping("/save")
//    public String saveAllDocuments() {
//        //Store Documents
//        documentRepo.save(new Document("1","demo","repo"));
//        return "document saved!!!";
//    }
    @RequestMapping("/getAll")
    public List<Document> getAllDocs() {
        List<Document> documents = new ArrayList<>();
        // iterate all documents and add it to list
        for (Document doc : this.documentRepo.findAll()) {
            documents.add(doc);
        }
        return documents;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getDocumnentById(@PathVariable String  id) {
        try {
            if(documentRepo.findById(id).isEmpty())
                return new ResponseEntity<>("Id not found", HttpStatus.SERVICE_UNAVAILABLE);
            else
                return new ResponseEntity<>(documentRepo.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(e, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping("/save")
    public ResponseEntity<?>  addDocument(@RequestBody Document document) {
        try {
            return new ResponseEntity<>(documentRepo.save(document), HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(e, HttpStatus.EXPECTATION_FAILED);
        }
    }

//    @PutMapping("/")
//    public ResponseEntity<?> updateDocument(@RequestBody Document document) {
//        try {
//            return new ResponseEntity<>(documentRepo.save(document), HttpStatus.OK);
//        } catch (Exception e) {
//            return  new ResponseEntity<>(e, HttpStatus.EXPECTATION_FAILED);
//        }
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        if(documentRepo.findById(id).isEmpty())
            return new ResponseEntity<>("Please enter a valid id",HttpStatus.BAD_REQUEST);
        else {
            try {
                documentRepo.deleteById(id);
                return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(e, HttpStatus.EXPECTATION_FAILED);
            }
        }
    }
}
