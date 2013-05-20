package forcomp

import forcomp.Anagrams._
object SentenceAnagrams  extends App{
  
//  val x  = List(('a',1), ('e',1), ('m',1), ('n',1), ('s',1), ('y',1))
//  
//  val y = List(('s',1), ('y',1))
//
//
//  isSubset(x, y)
//  
  
  //println(sentenceAnagrams(List("linux", "rulez"))) 
  
  def sentenceAnagrams2(sentenceOccurrences: Occurrences) = {
    if (sentenceOccurrences.isEmpty) List(Nil)

    val c: List[Occurrences] = combinations(sentenceOccurrences)
    
    c.foreach(o => println(o.mkString(",")))
    
    
    val vc = c.filter(o => dictionaryByOccurrences.contains(o))
    
    

    //c.foreach( o => println(o.mkString(",")+ " -->" + dictionaryByOccurrences.get(o)))
    
    //val words = vc.map(o => (o, dictionaryByOccurrences(o)))
    //println("words: " + words)

  }                                               //> sentenceAnagrams2: (sentenceOccurrences: forcomp.Anagrams.Occurrences)Unit
  
  def sortOccurrences(xl:List[Occurrences]):List[Occurrences]  = {
    xl sortWith{
      case (Nil, _) => false
      case(_, Nil) => true 
      case(x, y) => (x.head._1 < y.head._1) || ((x.head._1 == y.head._1) && (x.head._2 < y.head._2)) 
    }
  }
  //sentenceAnagrams2(sentenceOccurrences(List("Yes" , "Men")))
  
//  println(sentenceOccurrences(List("Yes" , "Men")))
//  
//  println(sentenceOccurrences(List("aa" , "bb")))
//  
//  println(stringCombinations("yesman"))
//  
//  println("Test:")
//  println(combinations(sentenceOccurrences(List("Yes" , "Men"))).mkString("\n"))
//  
//  println("Test2:=====")
//  println(sortOccurrences(combinations(sentenceOccurrences(List("aac" , "b")))).mkString("\n"))
//  println()
//  
//  println("Test3:====")
//  println(sortOccurrences(combinations(sentenceOccurrences(List("Yes" , "Man")))).mkString("\n"))
//  println()
//  
//  
//  println("Test4:====")
//  println(stringCombinations("aeMnsY").mkString("\n"))
//  println()
//  
  def powerset[A](s: Set[A]) = 
    s.foldLeft(Set(Set.empty[A])) { 
    	case (ss, el) => val res = ss ++ ss.map(_ + el); println("acc: "+res);res  
    }
  
  
  def powerset1(s: String) = 
    s.foldLeft(Set("")) { 
    	case (ss, el) => val res = ss ++  ss.map(_ + ""+ el.toString); println("acc: "+res);res  
    }
  
  
  val ss = Set("")
  val res = ss.map(_ + "" + "a")
  
  println(ss++res)
  
  
  val ss1 = ss ++ res
  val res1 = ss1.map(_ + "" + "b")
  
  println(ss1++res1)
  
  
  
  //println(powerset(Set('a', 'b', 'c')))
  
  //println(powerset1("a").toList.sortWith(_<_))
  
  println(powerset1("abc").toList.sortWith(_<_))
  
  
}