package forcomp

import forcomp.Anagrams._

object AnagramTest2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(111); 
  println("Welcome to the Scala worksheet");$skip(441); 

  def sentenceAnagrams2(sentenceOccurrences: Occurrences) = {
    if (sentenceOccurrences.isEmpty) List(Nil)

    val c: List[Occurrences] = combinations(sentenceOccurrences)
    val vc = c.filter(o => dictionaryByOccurrences.contains(o))

    c.foreach( o => println(o.mkString(",")+ " -->" + dictionaryByOccurrences.get(o)))
    
    
    val words = vc.map(o => (o, dictionaryByOccurrences(o)))
    println("words: " + words)

  };System.out.println("""sentenceAnagrams2: (sentenceOccurrences: forcomp.Anagrams.Occurrences)Unit""");$skip(56); 

  sentenceAnagrams2(sentenceOccurrences(List("Yes")));$skip(58); val res$0 = 

  combinations(sentenceOccurrences(List("Yes", "Man")));System.out.println("""res0: List[forcomp.Anagrams.Occurrences] = """ + $show(res$0));$skip(63); 

  sentenceAnagrams2(sentenceOccurrences(List("Yes", "Man")));$skip(437); 

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
  };System.out.println("""sentenceAnagrams1: (sentenceOccurrences: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.Sentence]""");$skip(60); val res$1 = 

  sentenceAnagrams1(sentenceOccurrences(List("i", "am")));System.out.println("""res1: List[forcomp.Anagrams.Sentence] = """ + $show(res$1));$skip(67); val res$2 = 

  sentenceAnagrams1(sentenceOccurrences(List("linux", "rulez")));System.out.println("""res2: List[forcomp.Anagrams.Sentence] = """ + $show(res$2));$skip(106); 
 
  def powerset(s: String) =
    s.foldLeft(Set("")) {
      case (acc, x) => acc ++  acc.map(_ + x)
  };System.out.println("""powerset: (s: String)scala.collection.immutable.Set[String]""");$skip(60); val res$3 = 
  
  powerset("abc").toList sortWith ( _ < _) mkString "\n";System.out.println("""res3: String = """ + $show(res$3))}
}
