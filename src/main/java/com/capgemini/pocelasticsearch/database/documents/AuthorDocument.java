package com.capgemini.pocelasticsearch.database.documents;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.List;

@Data
@Document(indexName = "author")
@Setting(settingPath = "static/es-settings.json")
public class AuthorDocument {

    @Field(type = FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<LivreDocument> livres;

}
