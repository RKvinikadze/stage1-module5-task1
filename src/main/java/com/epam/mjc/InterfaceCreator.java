package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            for (String s: list){
                if (!(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z'))
                    return false;
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
          int n = list.size();
          for (int i=0; i<n; i++){
              if (list.get(i) % 2 == 0) list.add(list.get(i));
          }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> res = new ArrayList<>();
            for (String s: values){
                if (!(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') || s.charAt(s.length() - 1) != '.' || s.split("\\s+").length <= 3)
                    continue;
                res.add(s);
            }
            return res;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> res = new HashMap<>();
            for (String s: list)
                res.put(s, s.length());

            return res;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
          List<Integer> res = new ArrayList<>();
          res.addAll(list1);
          res.addAll(list2);
          return res;
        };
    }
}
