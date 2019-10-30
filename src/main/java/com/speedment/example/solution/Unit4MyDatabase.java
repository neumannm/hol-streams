package com.speedment.example.solution;

import com.speedment.example.domainmodel.sakila.sakila.sakila.film.Film;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film.FilmManager;
import com.speedment.example.unit.Unit4Database;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;

public final class Unit4MyDatabase implements Unit4Database {

    @Override
    public long countAllFilms(FilmManager films) {
        return films.stream().count();
    }

    @Override
    public long countPg13Films(FilmManager films) {
        return films.stream().filter(Film.RATING.equal("PG-13")).count();
    }

    public List<Film> tenKidsFilms(FilmManager films) {
        return films.stream().filter(Film.RATING.equal("G")).limit(10).collect(Collectors.toList());
    }

    @Override
    public List<String> fiveLongFilms(FilmManager films) {
        return films.stream().filter(Film.LENGTH.greaterThan(120)).limit(5).map(Film.TITLE).collect(Collectors.toList());
    }

    @Override
    public List<Film> filmsSortedByLengthThirdPage(FilmManager films) {
        return films.stream().sorted(Film.LENGTH).skip(10*2).limit(10).collect(Collectors.toList());
    }

    @Override
    public Map<String, Long> frequencyTableOfRating(FilmManager films) {
        return films.stream().collect(Collectors.groupingBy(Film.RATING, Collectors.counting()));
    }
}
