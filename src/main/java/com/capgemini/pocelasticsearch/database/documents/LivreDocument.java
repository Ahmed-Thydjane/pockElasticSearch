package com.capgemini.pocelasticsearch.database.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.List;

@Document(indexName = "livres")
@Data
@Setting(settingPath = "static/es-settings.json")
public class LivreDocument {

    @Id
    @Field(type=FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Text)
    private AuthorDocument authors;

}
