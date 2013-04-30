package worksheet


object TestSet {
  import funsets.FunSets._
  
  println("Test FunSets")                         //> Test FunSets

  
  
  val set1 = singletonSet(1)                      //> set1  : Int => Boolean = <function1>
  contains(set1,1)                                //> res0: Boolean = true
  contains(set1,2)                                //> res1: Boolean = false
  
  val set2 = singletonSet(2)                      //> set2  : Int => Boolean = <function1>
  contains(set2,1)                                //> res2: Boolean = false
  contains(set2,2)                                //> res3: Boolean = true
  
  
  val setUnion12 = union(set1, set2)              //> setUnion12  : Int => Boolean = <function1>
  
  // Following statement should be true
  contains(setUnion12,1)                          //> res4: Boolean = true
  contains(setUnion12,2)                          //> res5: Boolean = true
    
  val setIntersection12 = intersect(set1, set2)   //> setIntersection12  : Int => Boolean = <function1>
  
  // Following statement should be false
  contains(setIntersection12,1)                   //> res6: Boolean = false
  contains(setIntersection12,2)                   //> res7: Boolean = false
  
  
  val setUnion123 = union(setUnion12,singletonSet(3))
                                                  //> setUnion123  : Int => Boolean = <function1>
  
  printSet(setUnion123)                           //> {1,2,3}
  
  // {1,2,3}- {1,2} => {3}
  val setDiff = diff(setUnion123, setUnion12)     //> setDiff  : Int => Boolean = <function1>
  
  
  contains(setDiff, 1) == false                   //> res8: Boolean = true
  contains(setDiff,2) == false                    //> res9: Boolean = true
  contains(setDiff, 3) == true                    //> res10: Boolean = true
  
  val setWithElementOverOne = filter(setUnion123, x=> x>1)
                                                  //> setWithElementOverOne  : Int => Boolean = <function1>

  setWithElementOverOne(1)                        //> res11: Boolean = false
  
  setWithElementOverOne(2)                        //> res12: Boolean = true
  
  setWithElementOverOne(3)                        //> res13: Boolean = true

  setWithElementOverOne(4)                        //> res14: Boolean = false

  printSet(setUnion123)                           //> {1,2,3}
  
  forall(setUnion123, x => x>0)                   //> res15: Boolean = true
  forall(setUnion123, x => x>2)                   //> res16: Boolean = false
  forall(setUnion123, x => x>3)                   //> res17: Boolean = false
  forall(setUnion123, x => x<4)                   //> res18: Boolean = true
  
  printSet(setUnion123)                           //> {1,2,3}
  exists(setUnion123, x => x>2)                   //> res19: Boolean = true
  exists(setUnion123, x => x>2)                   //> res20: Boolean = true
   
  exists(setUnion123, x => x>0)                   //> res21: Boolean = true
  exists(setUnion123, x => x>3)                   //> res22: Boolean = false
  
  exists(setUnion123, x => x>0)                   //> res23: Boolean = true
  exists(setUnion123, x => x>3)                   //> res24: Boolean = false
  
  exists(setUnion123, x => x>1)                   //> res25: Boolean = true
  exists(setUnion123, x => x>2)                   //> res26: Boolean = true
  exists(setUnion123, x=>true)                    //> res27: Boolean = true
  
  printSet(map(setUnion123, x=> x*x))             //> {1,4,9}
  
  forall(setUnion123, x => x>0)                   //> res28: Boolean = true
  forall(setUnion123, x => x>2)                   //> res29: Boolean = false
  forall(setUnion123, x => x>3)                   //> res30: Boolean = false
  forall(setUnion123, x => x<4)                   //> res31: Boolean = true
  
  
  exists(setUnion123, x => x>2)                   //> res32: Boolean = true
  
  printSet(map(setUnion123, x => x*x))            //> {1,4,9}
  
}