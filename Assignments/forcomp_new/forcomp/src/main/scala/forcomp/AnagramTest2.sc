package forcomp

import forcomp.Anagrams._

object AnagramTest2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def sentenceAnagrams2(sentenceOccurrences: Occurrences) = {
    if (sentenceOccurrences.isEmpty) List(Nil)

    val c: List[Occurrences] = combinations(sentenceOccurrences)
    val vc = c.filter(o => dictionaryByOccurrences.contains(o))

    c.foreach( o => println(o.mkString(",")+ " -->" + dictionaryByOccurrences.get(o)))
    
    
    val words = vc.map(o => (o, dictionaryByOccurrences(o)))
    println("words: " + words)

  }                                               //> sentenceAnagrams2: (sentenceOccurrences: forcomp.Anagrams.Occurrences)Unit

  sentenceAnagrams2(sentenceOccurrences(List("Yes")))
                                                  //> (s,1),(y,1) -->None
                                                  //| (y,1) -->None
                                                  //| (s,1) -->None
                                                  //| (e,1) -->None
                                                  //|  -->None
                                                  //| (e,1),(s,1),(y,1) -->Some(List(yes))
                                                  //| (e,1),(y,1) -->None
                                                  //| (e,1),(s,1) -->None
                                                  //| words: List((List((e,1), (s,1), (y,1)),List(yes)))

  combinations(sentenceOccurrences(List("Yes", "Man")))
                                                  //> res0: List[forcomp.Anagrams.Occurrences] = List(List((s,1), (y,1)), List((a,
                                                  //| 1), (e,1), (m,1)), List((n,1), (s,1)), List((a,1), (n,1), (s,1)), List((a,1)
                                                  //| , (e,1), (s,1), (y,1)), List((a,1), (n,1)), List((a,1), (e,1), (m,1), (s,1),
                                                  //|  (y,1)), List((m,1), (n,1), (s,1), (y,1)), List((a,1), (n,1), (y,1)), List((
                                                  //| a,1), (s,1)), List((e,1), (m,1), (s,1)), List((a,1), (e,1), (m,1), (n,1)), L
                                                  //| ist((a,1), (m,1)), List((y,1)), List((m,1)), List((a,1), (n,1), (s,1), (y,1)
                                                  //| ), List((s,1)), List((e,1), (n,1), (y,1)), List((a,1), (e,1)), List((a,1), (
                                                  //| m,1), (n,1)), List((a,1), (m,1), (n,1), (s,1)), List((a,1)), List((a,1), (e,
                                                  //| 1), (n,1), (s,1)), List((e,1), (n,1), (s,1)), List((m,1), (n,1)), List((e,1)
                                                  //| ), List((a,1), (e,1), (n,1)), List((e,1), (m,1), (n,1), (y,1)), List((e,1), 
                                                  //| (m,1), (n,1), (s,1), (y,1)), List((a,1), (e,1), (s,1)), List(), List((e,1), 
                                                  //| (n,1), (s,1), (y,1)), List((e,1), (m,1), (n,1)), List((m,1), (n,1), (y,1)), 
                                                  //| List((e,1), (m,1), (n,1)
                                                  //| Output exceeds cutoff limit.

  sentenceAnagrams2(sentenceOccurrences(List("Yes", "Man")))
                                                  //> (s,1),(y,1) -->None
                                                  //| (a,1),(e,1),(m,1) -->Some(List(Mae))
                                                  //| (n,1),(s,1) -->None
                                                  //| (a,1),(n,1),(s,1) -->Some(List(San))
                                                  //| (a,1),(e,1),(s,1),(y,1) -->Some(List(ayes, easy, yeas))
                                                  //| (a,1),(n,1) -->Some(List(an))
                                                  //| (a,1),(e,1),(m,1),(s,1),(y,1) -->Some(List(seamy))
                                                  //| (m,1),(n,1),(s,1),(y,1) -->None
                                                  //| (a,1),(n,1),(y,1) -->Some(List(any, nay))
                                                  //| (a,1),(s,1) -->Some(List(as))
                                                  //| (e,1),(m,1),(s,1) -->None
                                                  //| (a,1),(e,1),(m,1),(n,1) -->Some(List(amen, mane, mean, name))
                                                  //| (a,1),(m,1) -->Some(List(am))
                                                  //| (y,1) -->None
                                                  //| (m,1) -->None
                                                  //| (a,1),(n,1),(s,1),(y,1) -->None
                                                  //| (s,1) -->None
                                                  //| (e,1),(n,1),(y,1) -->None
                                                  //| (a,1),(e,1) -->None
                                                  //| (a,1),(m,1),(n,1) -->Some(List(man))
                                                  //| (a,1),(m,1),(n,1),(s,1) -->Some(List(Mans))
                                                  //| (a,1) -->None
                                                  //| (a,1),(e,1),(n,1),(s,1) -->Some(List(sane, Sean))
                                                  //| (e,1),(n,1),(s,1) -->None
                                                  //| (m,1),(n,1) -->None
                                                  //| (e,1) -->None
                                                  //| (a,1),(e,1),(n,1) -->None
                                                  //| (e,1),(m,1),(n,1),(y,1) -->None
                                                  //| 
                                                  //| Output exceeds cutoff limit.

  def sentenceAnagrams1(sentenceOccurrences: Occurrences): List[Sentence] = {
    //println("Sentence Anagram: "+ sentenceOccurrences)
    if (sentenceOccurrences.isEmpty) List(Nil)
    else {
      for {
        o <- combinations(sentenceOccurrences)
        if dictionaryByOccurrences.contains(o)
        w <- dictionaryByOccurrences(o)
        r <- sentenceAnagrams1(subtract(sentenceOccurrences, o))
      } yield w :: r
    }
  }                                               //> sentenceAnagrams1: (sentenceOccurrences: forcomp.Anagrams.Occurrences)List[
                                                  //| forcomp.Anagrams.Sentence]

  sentenceAnagrams1(sentenceOccurrences(List("i", "am")))
                                                  //> res1: List[forcomp.Anagrams.Sentence] = List(List(aim))

  sentenceAnagrams1(sentenceOccurrences(List("linux", "rulez")))
                                                  //> res2: List[forcomp.Anagrams.Sentence] = List(List(null, Rex, Uzi), List(nul
                                                  //| l, Uzi, Rex), List(Rex, null, Uzi), List(Rex, Zulu, Lin), List(Rex, Zulu, n
                                                  //| il), List(Rex, Uzi, null), List(Rex, Lin, Zulu), List(Rex, nil, Zulu), List
                                                  //| (Zulu, Rex, Lin), List(Zulu, Rex, nil), List(Zulu, Lin, Rex), List(Zulu, ni
                                                  //| l, Rex), List(Uzi, null, Rex), List(Uzi, Rex, null), List(rulez, Linux), Li
                                                  //| st(Lin, Rex, Zulu), List(Lin, Zulu, Rex), List(nil, Rex, Zulu), List(nil, Z
                                                  //| ulu, Rex), List(Linux, rulez))
 
  def powerset(s: String) =
    s.foldLeft(Set("")) {
      case (acc, x) => acc ++  acc.map(_ + x)
  }                                               //> powerset: (s: String)scala.collection.immutable.Set[String]
  
  powerset("abc").toList sortWith ( _ < _) mkString "\n"
                                                  //> res3: String = "
                                                  //| a
                                                  //| ab
                                                  //| abc
                                                  //| ac
                                                  //| b
                                                  //| bc
                                                  //| c"
}