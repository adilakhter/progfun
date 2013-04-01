# Learning Scala 


## List and Sets 

As with functional languages, the bread-and-butter data structure is the `List`.

	> List(1,2,3) 
    
    > List("one", "two", "three")
    
    > List("one", "two",  3)
    
    > List("one", "two" , 3)(2)
    
    > Nil  // Nil.type = List() 
    
    

A `Set` is like a list, but sets do not have any explicit order. You specify a set with the `Set` keyword. 


	> val animals = Set("a", "b", "c") // immutable set collection 

Adding or subtracting from the set is easy:
    
    > animals + "d" 
    > animals - "a"
	> animals + Set("e", "f")

Sets are immutable. Keep in mind that set operations are destructive. Each set of operation builds a new set rather than modifying old ones. 



  



    



## Function ##





Functions in scala can be defined simply as follows:

    def fnname (args*){ // function body}

    def _double(i:Int) = i*2 

Implementing `loop` can be done in following manner. 

    
    def whileLoop{
    	var i = 1
    	while (i<=3) {
    		println (i)
    	}
    }


### Higher-Order function

Function that takes other functions as parameter or that return functions as result as called *higher order* function. One thing that is particular to functional programming treats function as value. This provides a flexible way to compose programs.




    