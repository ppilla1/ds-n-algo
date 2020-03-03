package net.recursion;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

@Slf4j
public class TestStackAndQueue {

    @Test
    public void testArrayDequeAsStack(){
        Deque<String> explicitStack = new ArrayDeque<>();

        int charA = 'a';
        char aChar = (char)charA;

        log.info("ASCII {} , charater {}", charA, aChar);
        try {
            explicitStack.pop();
            assertTrue(false);
        }catch (NoSuchElementException e){
            assertTrue(true);
        }

        explicitStack.push("ONE");
        explicitStack.push("TWO");

        assertTrue("TWO".equals(explicitStack.pop()));
        assertTrue("ONE".equals(explicitStack.pop()));

        try {
            explicitStack.pop();
            assertTrue(false);
        }catch (NoSuchElementException e){
            assertTrue(true);
        }


    }

    @Test
    public void testArrayDequeAsQueue(){
        Deque<String> explicitQueue = new ArrayDeque<>();

        assertNull(explicitQueue.poll());

        explicitQueue.offer("ONE");
        explicitQueue.offer("TWO");

        assertTrue("ONE".equals(explicitQueue.poll()));
        assertTrue("TWO".equals(explicitQueue.poll()));

        assertNull(explicitQueue.poll());
    }
}
