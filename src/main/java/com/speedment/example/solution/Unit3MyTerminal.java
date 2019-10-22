package com.speedment.example.solution;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.speedment.example.unit.Unit3Terminal;

public final class Unit3MyTerminal implements Unit3Terminal {

    @Override
    public void addToSet(Stream<String> stream, Set<String> set) {
        stream.forEach(set::add);
    }

    @Override
    public void addToListInOrder(Stream<String> stream, List<String> list) {
        stream.forEachOrdered(list::add);
    }

    @Override
    public Set<String> collectToSet(Stream<String> stream) {
        return stream.collect(Collectors.toSet());
    }

    @Override
    public List<String> collectToList(Stream<String> stream) {
        return stream.collect(Collectors.toList());
    }

    @Override
    public String collectJoining(Stream<String> stream) {
        return stream.collect(Collectors.joining("->"));
    }

    @Override
    public String[] toArray(Stream<String> stream) {
        return stream.toArray(String[]::new);
    }

    @Override
    public Map<String, Integer> collectToMap(Stream<String> stream) {
        return stream.collect(Collectors.toMap(Function.identity(), s -> (int) s.chars().count()));
    }

    @Override
    public int countCharacters(Stream<String> stream) {
        return stream.mapToInt(s -> s.length()).sum();
    }

    @Override
    public int maxWordLen(Stream<String> stream) {
        return stream.mapToInt(s -> s.length()).max().orElse(0);
    }

    @Override
    public IntSummaryStatistics statistics(Stream<String> stream) {
        return stream.mapToInt(s -> s.length()).summaryStatistics();
    }

    @Override
    public Optional<String> findLongestString(Stream<String> stream) {
        return stream.max((s1, s2) -> s1.length()>=s2.length() ? 1 : -1); //there must be a more elegant solution...
    }

    @Override
    public Map<Integer, List<String>> wordsGroupedByLength(Stream<String> stream) {
        return stream.collect(Collectors.groupingBy(s -> s.length()));
    }

    @Override
    public Map<Integer, Long> wordsGroupedByLengthCounted(Stream<String> stream) {
        return stream.collect(Collectors.groupingBy(s -> s.length(), Collectors.counting()));
    }

}
