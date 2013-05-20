package forcomp
import forcomp.Anagrams._

object AnagramsTest {
  println("Testing anagrams")                     //> Testing anagrams

  val w1 = "aabb"                                 //> w1  : String = aabb
  val w2 = ""                                     //> w2  : String = ""
  val w3 = "Anagram"                              //> w3  : String = Anagram

  val w1l = wordOccurrences(w1)                   //> w1l  : forcomp.Anagrams.Occurrences = List((a,2), (b,2))
  val w2l = wordOccurrences(w2)                   //> w2l  : forcomp.Anagrams.Occurrences = List()
  wordOccurrences(w3)                             //> res0: forcomp.Anagrams.Occurrences = List((a,3), (g,1), (m,1), (n,1), (r,1))
                                                  //| 

  combinations(w1l).length == 9                   //> res1: Boolean = true

  combinations(wordOccurrences("a"))              //> res2: List[forcomp.Anagrams.Occurrences] = List(List(), List((a,1)))
  combinations(w2l)                               //> res3: List[forcomp.Anagrams.Occurrences] = List(List())

  transformToString(wordOccurrences("aaab"))      //> res4: String = aaab

  transformToString(wordOccurrences(""))          //> res5: String = ""

  stringCombinations("")                          //> res6: scala.collection.immutable.Set[String] = Set("")

  stringCombinations("") map wordOccurrences toList
                                                  //> res7: List[forcomp.Anagrams.Occurrences] = List(List())

  val x = wordOccurrences("lard")                 //> x  : forcomp.Anagrams.Occurrences = List((a,1), (d,1), (l,1), (r,1))

  val y = List(('l', 1))                          //> y  : List[(Char, Int)] = List((l,1))

  val xmap = x.toMap                              //> xmap  : scala.collection.immutable.Map[Char,Int] = Map(a -> 1, d -> 1, l -> 
                                                  //| 1, r -> 1)
  val ymap = y.toMap                              //> ymap  : scala.collection.immutable.Map[Char,Int] = Map(l -> 1)

  xmap.get('z')                                   //> res8: Option[Int] = None

  def subOccurences(occurrences: Map[Char, Int], occurrence: (Char, Int)): Map[Char, Int] =
    {
      val (ch, i) = occurrence
      occurrences + (ch -> (occurrences(ch) - i))

    }                                             //> subOccurences: (occurrences: Map[Char,Int], occurrence: (Char, Int))Map[Char
                                                  //| ,Int]

  (ymap foldLeft xmap)(subOccurences)             //> res9: scala.collection.immutable.Map[Char,Int] = Map(a -> 1, d -> 1, l -> 0,
                                                  //|  r -> 1)
  (ymap foldLeft xmap)(subOccurences).toList      //> res10: List[(Char, Int)] = List((a,1), (d,1), (l,0), (r,1))

  subtract(x, y)                                  //> res11: forcomp.Anagrams.Occurrences = List((a,1), (d,1), (r,1))

  val totalmap = xmap withDefaultValue 0          //> totalmap  : scala.collection.immutable.Map[Char,Int] = Map(a -> 1, d -> 1, l
                                                  //|  -> 1, r -> 1)

  ymap.forall { case (ch: Char, o: Int) => totalmap(ch) >= o }
                                                  //> res12: Boolean = true

  //sentenceAnagrams(List("Yes", "man") )
  //val s = List("Yes", "man")
  //val o =  sentenceOccurrences(s)
  //combinations(o) map (x=> subtract(o, x))

  val xx = wordOccurrences("lard")                //> xx  : forcomp.Anagrams.Occurrences = List((a,1), (d,1), (l,1), (r,1))

  val sentence = List("Yes", "man")               //> sentence  : List[String] = List(Yes, man)
  val sOccurrences = sentenceOccurrences(sentence)//> sOccurrences  : forcomp.Anagrams.Occurrences = List((a,1), (e,1), (m,1), (n
                                                  //| ,1), (s,1), (y,1))
  val sSubsets = combinations(sOccurrences)       //> sSubsets  : List[forcomp.Anagrams.Occurrences] = List(List((s,1), (y,1)), L
                                                  //| ist((a,1), (e,1), (m,1)), List((n,1), (s,1)), List((m,1), (n,1), (s,1), (y,
                                                  //| 1)), List((a,1), (e,1), (m,1), (n,1)), List((y,1)), List((m,1)), List((s,1)
                                                  //| ), List((a,1), (e,1)), List((a,1)), List((m,1), (n,1)), List((e,1)), List((
                                                  //| e,1), (m,1), (n,1), (s,1), (y,1)), List(), List((e,1), (m,1), (n,1)), List(
                                                  //| (e,1), (m,1), (n,1), (s,1)), List((n,1)), List((n,1), (s,1), (y,1)), List((
                                                  //| m,1), (n,1), (s,1)), List((e,1), (m,1)), List((a,1), (e,1), (m,1), (n,1), (
                                                  //| s,1)), List((a,1), (e,1), (m,1), (n,1), (s,1), (y,1)))
  val other = combinations(sSubsets.head)         //> other  : List[forcomp.Anagrams.Occurrences] = List(List(), List((s,1)), Lis
                                                  //| t((s,1), (y,1)), List((y,1)))
  for {
    o <- other if isSubset(sOccurrences, o)
  } yield o                                       //> res13: List[forcomp.Anagrams.Occurrences] = List(List(), List((s,1)), List(
                                                  //| (s,1), (y,1)), List((y,1)))

  def isSubset_2(x: Occurrences, y: Occurrences): Boolean = {
    val xMap = x.toMap withDefaultValue 0
    val res = (y.toMap).forall { case (ch: Char, o: Int) => (xMap(ch) - o) > 0 }
    println("x:" + x + " y: " + y + "res: " + res)
    res
  }                                               //> isSubset_2: (x: forcomp.Anagrams.Occurrences, y: forcomp.Anagrams.Occurrenc
                                                  //| es)Boolean

  val x1 = List(('a', 1), ('e', 1), ('m', 1), ('n', 1), ('s', 1), ('y', 1))
                                                  //> x1  : List[(Char, Int)] = List((a,1), (e,1), (m,1), (n,1), (s,1), (y,1))

  val y1 = List(('s', 1), ('y', 1))               //> y1  : List[(Char, Int)] = List((s,1), (y,1))

  val x1Map = x1.toMap withDefaultValue 0         //> x1Map  : scala.collection.immutable.Map[Char,Int] = Map(e -> 1, s -> 1, n -
                                                  //| > 1, y -> 1, a -> 1, m -> 1)

  val y1Map = y1.toMap                            //> y1Map  : scala.collection.immutable.Map[Char,Int] = Map(s -> 1, y -> 1)
  val res = (y1.toMap).forall { case (ch: Char, o: Int) => (x1Map(ch) - o) >= 0 }
                                                  //> res  : Boolean = true

  y1Map map { case (ch: Char, o: Int) => x1Map(ch) }
                                                  //> res14: scala.collection.immutable.Iterable[Int] = List(1, 1)

  sentenceAnagrams(List("I", "am"))               //> result:  List(List()) s: List()
                                                  //| result:  List(List(aim)) s: List((a,1), (i,1), (m,1))
                                                  //| res15: List[forcomp.Anagrams.Sentence] = List(List(aim))

  def sentenceAnagrams1(sentenceOccurrences: Occurrences): List[Sentence] = {
	  for {
	    o <- combinations(sentenceOccurrences) if dictionaryByOccurrences.contains(o)
	    w <- dictionaryByOccurrences(o)
	    r <- sentenceAnagrams1(subtract(sentenceOccurrences, o))
	  } yield w :: r
   
  }                                               //> sentenceAnagrams1: (sentenceOccurrences: forcomp.Anagrams.Occurrences)List[
                                                  //| forcomp.Anagrams.Sentence]

  sentenceAnagrams1(sentenceOccurrences(List("i", "am")))
                                                  //> res16: List[forcomp.Anagrams.Sentence] = List()

}