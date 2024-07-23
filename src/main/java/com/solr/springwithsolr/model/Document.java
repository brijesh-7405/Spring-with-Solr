package com.solr.springwithsolr.model;

import org.springframework.data.solr.core.mapping.SolrDocument;
import org.springframework.data.annotation.Id;
import org.apache.solr.client.solrj.beans.Field;

@SolrDocument(solrCoreName = "SpringDocument")
public class Document {
    @Id
    @Field
    private String id;
    @Field
    private String docType;

    @Field
    private String docTitle;
    public Document() {
    }


    public Document(String id, String docType, String docTitle){
        this.id = id;
        this.docTitle = docTitle;
        this.docType = docType;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }
    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", docType='" + docType + '\'' +
                ", docTitle='" + docTitle + '\'' +
                '}';
    }
    public String getDocType() {
        return docType;
    }
    public void setDocType(String docType) {
        this.docType = docType;
    }
    public String getDocTitle() {
        return docTitle;
    }
    public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
    }
}
