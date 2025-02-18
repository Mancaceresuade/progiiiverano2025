package com.ejemplo.ejemplo.service;

import com.ejemplo.ejemplo.entity.MovieEntity;
import com.ejemplo.ejemplo.entity.PersonEntity;
import com.ejemplo.ejemplo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GraphService {
    private final MovieRepository movieRepository;
    private final Map<String, Set<String>> adjacencyList = new HashMap<>();

    @Autowired
    public GraphService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        buildGraph();
    }

    private void buildGraph() {
        movieRepository.findAll().collectList().subscribe(movies -> {
            for (MovieEntity movie : movies) {
                adjacencyList.putIfAbsent(movie.getTitle(), new HashSet<>());
                for (PersonEntity actor : movie.getActors()) {
                    adjacencyList.putIfAbsent(actor.getName(), new HashSet<>());
                    adjacencyList.get(movie.getTitle()).add(actor.getName());
                    adjacencyList.get(actor.getName()).add(movie.getTitle());
                }
                for (PersonEntity director : movie.getDirectors()) {
                    adjacencyList.putIfAbsent(director.getName(), new HashSet<>());
                    adjacencyList.get(movie.getTitle()).add(director.getName());
                    adjacencyList.get(director.getName()).add(movie.getTitle());
                }
            }
        });
    }

    public List<String> searchPath(String start, String end) {
        Set<String> visited = new HashSet<>();
        List<String> path = new ArrayList<>();
        if (backtrack(start, end, visited, path)) {
            return path;
        }
        return Collections.emptyList();
    }

    private boolean backtrack(String current, String target, Set<String> visited, List<String> path) {
        if (!adjacencyList.containsKey(current)) {
            return false;
        }
        path.add(current);
        visited.add(current);
        if (current.equals(target)) {
            return true;
        }
        for (String neighbor : adjacencyList.get(current)) {
            if (!visited.contains(neighbor) && backtrack(neighbor, target, visited, path)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }
}
