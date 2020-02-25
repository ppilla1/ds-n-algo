# Problem Set-1 #
1. Find all subsets of the word "abc"
2. Given a set of integers S, find any subset which adds to given target T.
   .e.g. S = {1, -10, 9, 4, 3, 2, 50, 12, 13, -5}  , T=20
3. Find all anagrams of the word "abc"
4. Given a set of integers, find if it is possible to divide it into two groups such that sum of one group is a multiple of 5
   and sum of the other is odd

# Problem Set-2 #
1. Print all permutations of Nabc
   .e.g. N=1 then permutation of abc, N=2 then permutation of aabbcc etc.
2. Print all well-formed combinations of N{}
   .e.g.:
    N=1 then {}
    N=2 then {}{}, {{}}
    N=3 then {}{}{}, {}{{}}, {{}}{}, {{}{}}, {{{}}}
3. Implement power(x,y)    
      
# Problem Set-3 #
1. Find all circular (clockwise) tours a truck can take to visit all petrol pumps arranged in a circle.
   Assumption:
   a. c[] has distance from each petrol pump to next.
   b. p[] has amount of petrol at every pump.
   c. The truck has to stop at and use all petrol at each pump.
   d. The truck has infinite capacity.
   e. For 1 unit of petrol, the truck can go 1 unit of distance.
   
   .e.g: N=4, c[]={4,3,9,5}, p[]={1,2,10,8}
   
2. Find if given a black's postion, it is conquered in the board game Go.
   Rules:
   a. Black and White play alternatively
   b. Black is conquered if it is (and all its neighbouring blacks, if any, are also) surrounded by whites or boarder of the board
   c. Board size is 19 x 19