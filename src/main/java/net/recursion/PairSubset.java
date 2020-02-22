package net.recursion;

import java.util.ArrayList;
import java.util.List;

public class PairSubset {

    List<List<Integer>> generate(List<Integer> problem, List<Integer> solution){
        List<List<Integer>> resultSet = new ArrayList<>();

        if (solution.size() == 2){
            resultSet.add(solution);
        }else if(!problem.isEmpty()){
            ArrayList<Integer> newProblem = new ArrayList<>(problem);
            ArrayList<Integer> newSolution = new ArrayList<>(solution);
            Integer element = newProblem.remove(0);
            newSolution.add(element);
            resultSet = generate(newProblem, newSolution);
            resultSet.addAll(generate(newProblem, new ArrayList<>(solution)));
        }

        return resultSet;
    }
}
