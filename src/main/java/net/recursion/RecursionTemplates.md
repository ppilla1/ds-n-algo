# Top-Down #

Note : Use implicit java method call stack or ArrayDeque<E> as explicit stack cast to Deque<E> interface 

recursion(problem-at-this-point, solution-so-far){
    1. if (problem-at-this-point is trivial or empty)
        process solution-so-far
        return
    2. deplete the problem-at-this-point into new-sub-problem's
    
    3. enrich the solution-so-far into new-solution-so-far
    
    // One or more of below
    4. recursion(new-sub-problem's, new-solution-so-far)
}

main(){
    0. recursion(full-problem, empty-solution)
}

# Bottom-Up#

Note: Use explicit queue ArrayDeque<E> cast to Deque<E> interface with methods offer(e) [as enqueue method] and poll() [as dequeue method] 

solution recursion(problem-at-this-point){
    1. if (problem-at-this-point is trivial or empty)
        return simple-solution
    
    2. deplete problem-at-this-point to new-sub-problem's
    
    // One or more of below
    3. temp-solution's = recursion(new-sub-problem's)
    
    4. put together temp-solution's into complex-solution
    
    5. return complex-solution
}

main(){
    0. final-solution = recursion(full-problem)
}