package net.recursion;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class TestPairSubset {

    @Test
    public void testGenerateSubset(){
        PairSubset pairSubset = new PairSubset();

        List<Integer> problem = Arrays.asList(1,2,3);
        List<List<Integer>> result = pairSubset.generate(problem, new ArrayList<>());
        log.info("Pair subsets for {} is {}", problem, result);
        assertNotNull(result);
    }
}
