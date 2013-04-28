package worksheet


object TestSet {
  import funsets.FunSets._;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(92); 
  
  println("Test FunSets");$skip(36); 

  
  
  val set1 = singletonSet(1);System.out.println("""set1  : Int => Boolean = """ + $show(set1 ));$skip(19); val res$0 = 
  contains(set1,1);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(19); val res$1 = 
  contains(set1,2);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(32); 
  
  val set2 = singletonSet(2);System.out.println("""set2  : Int => Boolean = """ + $show(set2 ));$skip(19); val res$2 = 
  contains(set2,1);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(19); val res$3 = 
  contains(set2,2);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(43); 
  
  
  val setUnion12 = union(set1, set2);System.out.println("""setUnion12  : Int => Boolean = """ + $show(setUnion12 ));$skip(68); val res$4 = 
  
  // Following statement should be true
  contains(setUnion12,1);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(25); val res$5 = 
  contains(setUnion12,2);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(53); 
    
  val setIntersection12 = intersect(set1, set2);System.out.println("""setIntersection12  : Int => Boolean = """ + $show(setIntersection12 ));$skip(76); val res$6 = 
  
  // Following statement should be false
  contains(setIntersection12,1);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(32); val res$7 = 
  contains(setIntersection12,2);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(60); 
  
  
  val setUnion123 = union(setUnion12,singletonSet(3));System.out.println("""setUnion123  : Int => Boolean = """ + $show(setUnion123 ));$skip(27); 
  
  printSet(setUnion123);$skip(76); 
  
  // {1,2,3}- {1,2} => {3}
  val setDiff = diff(setUnion123, setUnion12);System.out.println("""setDiff  : Int => Boolean = """ + $show(setDiff ));$skip(38); val res$8 = 
  
  
  contains(setDiff, 1) == false;System.out.println("""res8: Boolean = """ + $show(res$8));$skip(31); val res$9 = 
  contains(setDiff,2) == false;System.out.println("""res9: Boolean = """ + $show(res$9));$skip(31); val res$10 = 
  contains(setDiff, 3) == true;System.out.println("""res10: Boolean = """ + $show(res$10));$skip(62); 
  
  val setWithElementOverOne = filter(setUnion123, x=> x>1);System.out.println("""setWithElementOverOne  : Int => Boolean = """ + $show(setWithElementOverOne ));$skip(28); val res$11 = 

  setWithElementOverOne(1);System.out.println("""res11: Boolean = """ + $show(res$11));$skip(30); val res$12 = 
  
  setWithElementOverOne(2);System.out.println("""res12: Boolean = """ + $show(res$12));$skip(30); val res$13 = 
  
  setWithElementOverOne(3);System.out.println("""res13: Boolean = """ + $show(res$13));$skip(28); val res$14 = 

  setWithElementOverOne(4);System.out.println("""res14: Boolean = """ + $show(res$14));$skip(25); 

  printSet(setUnion123);$skip(36); val res$15 = 
  
  forall(setUnion123, x => x>0);System.out.println("""res15: Boolean = """ + $show(res$15));$skip(32); val res$16 = 
  forall(setUnion123, x => x>2);System.out.println("""res16: Boolean = """ + $show(res$16));$skip(32); val res$17 = 
  forall(setUnion123, x => x>3);System.out.println("""res17: Boolean = """ + $show(res$17));$skip(32); val res$18 = 
  forall(setUnion123, x => x<4);System.out.println("""res18: Boolean = """ + $show(res$18));$skip(28); 
  
  printSet(setUnion123);$skip(32); val res$19 = 
  exists(setUnion123, x => x>2);System.out.println("""res19: Boolean = """ + $show(res$19));$skip(32); val res$20 = 
  exists(setUnion123, x => x>2);System.out.println("""res20: Boolean = """ + $show(res$20));$skip(37); val res$21 = 
   
  exists(setUnion123, x => x>0);System.out.println("""res21: Boolean = """ + $show(res$21));$skip(32); val res$22 = 
  exists(setUnion123, x => x>3);System.out.println("""res22: Boolean = """ + $show(res$22));$skip(35); val res$23 = 
  
  exists(setUnion123, x => x>0);System.out.println("""res23: Boolean = """ + $show(res$23));$skip(32); val res$24 = 
  exists(setUnion123, x => x>3);System.out.println("""res24: Boolean = """ + $show(res$24));$skip(35); val res$25 = 
  
  exists(setUnion123, x => x>1);System.out.println("""res25: Boolean = """ + $show(res$25));$skip(32); val res$26 = 
  exists(setUnion123, x => x>2);System.out.println("""res26: Boolean = """ + $show(res$26));$skip(31); val res$27 = 
  exists(setUnion123, x=>true);System.out.println("""res27: Boolean = """ + $show(res$27));$skip(41); 
  
  printSet(map(setUnion123, x=> x*x));$skip(35); val res$28 = 
  
  forall(setUnion123, x => x>0);System.out.println("""res28: Boolean = """ + $show(res$28));$skip(32); val res$29 = 
  forall(setUnion123, x => x>2);System.out.println("""res29: Boolean = """ + $show(res$29));$skip(32); val res$30 = 
  forall(setUnion123, x => x>3);System.out.println("""res30: Boolean = """ + $show(res$30));$skip(32); val res$31 = 
  forall(setUnion123, x => x<4);System.out.println("""res31: Boolean = """ + $show(res$31));$skip(38); val res$32 = 
  
  
  exists(setUnion123, x => x>2);System.out.println("""res32: Boolean = """ + $show(res$32));$skip(42); 
  
  printSet(map(setUnion123, x => x*x))}
  
}
