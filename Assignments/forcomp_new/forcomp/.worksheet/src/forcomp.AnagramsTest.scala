package forcomp
import forcomp.Anagrams._

object AnagramsTest {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(95); 
  println("Testing anagrams");$skip(20); 

  val w1 = "aabb";System.out.println("""w1  : String = """ + $show(w1 ));$skip(14); 
  val w2 = "";System.out.println("""w2  : String = """ + $show(w2 ));$skip(21); 
  val w3 = "Anagram";System.out.println("""w3  : String = """ + $show(w3 ));$skip(34); 

  val w1l = wordOccurrences(w1);System.out.println("""w1l  : forcomp.Anagrams.Occurrences = """ + $show(w1l ));$skip(32); 
  val w2l = wordOccurrences(w2);System.out.println("""w2l  : forcomp.Anagrams.Occurrences = """ + $show(w2l ));$skip(22); val res$0 = 
  wordOccurrences(w3);System.out.println("""res0: forcomp.Anagrams.Occurrences = """ + $show(res$0));$skip(34); val res$1 = 

  combinations(w1l).length == 9;System.out.println("""res1: Boolean = """ + $show(res$1));$skip(39); val res$2 = 

  combinations(wordOccurrences("a"));System.out.println("""res2: List[forcomp.Anagrams.Occurrences] = """ + $show(res$2));$skip(20); val res$3 = 
  combinations(w2l);System.out.println("""res3: List[forcomp.Anagrams.Occurrences] = """ + $show(res$3));$skip(47); val res$4 = 

  transformToString(wordOccurrences("aaab"));System.out.println("""res4: String = """ + $show(res$4));$skip(43); val res$5 = 

  transformToString(wordOccurrences(""));System.out.println("""res5: String = """ + $show(res$5));$skip(27); val res$6 = 

  stringCombinations("");System.out.println("""res6: scala.collection.immutable.Set[String] = """ + $show(res$6));$skip(54); val res$7 = 

  stringCombinations("") map wordOccurrences toList;System.out.println("""res7: List[forcomp.Anagrams.Occurrences] = """ + $show(res$7));$skip(36); 

  val x = wordOccurrences("lard");System.out.println("""x  : forcomp.Anagrams.Occurrences = """ + $show(x ));$skip(27); 

  val y = List(('l', 1));System.out.println("""y  : List[(Char, Int)] = """ + $show(y ));$skip(23); 

  val xmap = x.toMap;System.out.println("""xmap  : scala.collection.immutable.Map[Char,Int] = """ + $show(xmap ));$skip(21); 
  val ymap = y.toMap;System.out.println("""ymap  : scala.collection.immutable.Map[Char,Int] = """ + $show(ymap ));$skip(18); val res$8 = 

  xmap.get('z');System.out.println("""res8: Option[Int] = """ + $show(res$8));$skip(189); 

  def subOccurences(occurrences: Map[Char, Int], occurrence: (Char, Int)): Map[Char, Int] =
    {
      val (ch, i) = occurrence
      occurrences + (ch -> (occurrences(ch) - i))

    };System.out.println("""subOccurences: (occurrences: Map[Char,Int], occurrence: (Char, Int))Map[Char,Int]""");$skip(40); val res$9 = 

  (ymap foldLeft xmap)(subOccurences);System.out.println("""res9: scala.collection.immutable.Map[Char,Int] = """ + $show(res$9));$skip(45); val res$10 = 
  (ymap foldLeft xmap)(subOccurences).toList;System.out.println("""res10: List[(Char, Int)] = """ + $show(res$10));$skip(19); val res$11 = 

  subtract(x, y);System.out.println("""res11: forcomp.Anagrams.Occurrences = """ + $show(res$11));$skip(43); 

  val totalmap = xmap withDefaultValue 0;System.out.println("""totalmap  : scala.collection.immutable.Map[Char,Int] = """ + $show(totalmap ));$skip(65); val res$12 = 

  ymap.forall { case (ch: Char, o: Int) => totalmap(ch) >= o };System.out.println("""res12: Boolean = """ + $show(res$12));$skip(193); 

  //sentenceAnagrams(List("Yes", "man") )
  //val s = List("Yes", "man")
  //val o =  sentenceOccurrences(s)
  //combinations(o) map (x=> subtract(o, x))

  val xx = wordOccurrences("lard");System.out.println("""xx  : forcomp.Anagrams.Occurrences = """ + $show(xx ));$skip(38); 

  val sentence = List("Yes", "man");System.out.println("""sentence  : List[String] = """ + $show(sentence ));$skip(51); 
  val sOccurrences = sentenceOccurrences(sentence);System.out.println("""sOccurrences  : forcomp.Anagrams.Occurrences = """ + $show(sOccurrences ));$skip(44); 
  val sSubsets = combinations(sOccurrences);System.out.println("""sSubsets  : List[forcomp.Anagrams.Occurrences] = """ + $show(sSubsets ));$skip(42); 
  val other = combinations(sSubsets.head);System.out.println("""other  : List[forcomp.Anagrams.Occurrences] = """ + $show(other ));$skip(64); val res$13 = 
  for {
    o <- other if isSubset(sOccurrences, o)
  } yield o;System.out.println("""res13: List[forcomp.Anagrams.Occurrences] = """ + $show(res$13));$skip(250); 

  def isSubset_2(x: Occurrences, y: Occurrences): Boolean = {
    val xMap = x.toMap withDefaultValue 0
    val res = (y.toMap).forall { case (ch: Char, o: Int) => (xMap(ch) - o) > 0 }
    println("x:" + x + " y: " + y + "res: " + res)
    res
  };System.out.println("""isSubset_2: (x: forcomp.Anagrams.Occurrences, y: forcomp.Anagrams.Occurrences)Boolean""");$skip(78); 

  val x1 = List(('a', 1), ('e', 1), ('m', 1), ('n', 1), ('s', 1), ('y', 1));System.out.println("""x1  : List[(Char, Int)] = """ + $show(x1 ));$skip(38); 

  val y1 = List(('s', 1), ('y', 1));System.out.println("""y1  : List[(Char, Int)] = """ + $show(y1 ));$skip(44); 

  val x1Map = x1.toMap withDefaultValue 0;System.out.println("""x1Map  : scala.collection.immutable.Map[Char,Int] = """ + $show(x1Map ));$skip(25); 

  val y1Map = y1.toMap;System.out.println("""y1Map  : scala.collection.immutable.Map[Char,Int] = """ + $show(y1Map ));$skip(82); 
  val res = (y1.toMap).forall { case (ch: Char, o: Int) => (x1Map(ch) - o) >= 0 };System.out.println("""res  : Boolean = """ + $show(res ));$skip(55); val res$14 = 

  y1Map map { case (ch: Char, o: Int) => x1Map(ch) };System.out.println("""res14: scala.collection.immutable.Iterable[Int] = """ + $show(res$14));$skip(38); val res$15 = 

  sentenceAnagrams(List("I", "am"));System.out.println("""res15: List[forcomp.Anagrams.Sentence] = """ + $show(res$15));$skip(298); 

  def sentenceAnagrams1(sentenceOccurrences: Occurrences): List[Sentence] = {
	  for {
	    o <- combinations(sentenceOccurrences) if dictionaryByOccurrences.contains(o)
	    w <- dictionaryByOccurrences(o)
	    r <- sentenceAnagrams1(subtract(sentenceOccurrences, o))
	  } yield w :: r
   
  };System.out.println("""sentenceAnagrams1: (sentenceOccurrences: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.Sentence]""");$skip(60); val res$16 = 

  sentenceAnagrams1(sentenceOccurrences(List("i", "am")));System.out.println("""res16: List[forcomp.Anagrams.Sentence] = """ + $show(res$16))}

}
