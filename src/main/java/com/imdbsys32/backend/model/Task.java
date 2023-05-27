package com.imdbsys32.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tasks")
public class Task {

    @Id
    private String id;
    @Field("plantName")
    private String plantName;
    @Field("datePlanted")
    private Date datePlanted;
    @Field("phLevel")
    private float phLevel;
    @Field("farmer")
    private String farmer;
    @Field("status")
    private String status;
}
