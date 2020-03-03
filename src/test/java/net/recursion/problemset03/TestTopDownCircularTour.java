package net.recursion.problemset03;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class TestTopDownCircularTour {

    @Test
    public void testFindTourRouteDF(){
        int[] cost = {4,3,9,5};
        int[] fuel = {1,2,10,8};
        TopDownCircularTour topDownCircularTour = new TopDownCircularTour(cost, fuel);

        List<String> routes = topDownCircularTour.findTourRouteDFdefaultStack();
        assertNotNull(routes);
        assertTrue(!routes.isEmpty());
        log.info("Circular routes {}", routes);
    }
}
