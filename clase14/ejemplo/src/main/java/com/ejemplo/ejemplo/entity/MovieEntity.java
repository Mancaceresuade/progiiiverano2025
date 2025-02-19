package com.ejemplo.ejemplo.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

@Node("Movie")
public class MovieEntity {
    @Id
    private final String title;
    @Property("tagline")
    private final String description;
    @Relationship(type = "ACTED_IN", direction = INCOMING)
    private Set<PersonEntity> actors = new HashSet<>();
    @Relationship(type = "DIRECTED", direction = INCOMING)
    private Set<PersonEntity> directors = new HashSet<>();
    public MovieEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Set<PersonEntity> getActors() {
        return actors;
    }

    public void setActors(Set<PersonEntity> actors) {
        this.actors = actors;
    }

    public Set<PersonEntity> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<PersonEntity> directors) {
        this.directors = directors;
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", actors=" + actors +
                ", directors=" + directors +
                '}';
    }
}