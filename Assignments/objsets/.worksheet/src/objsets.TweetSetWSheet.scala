package objsets

object TweetSetWSheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(88); 
  println("Welcome to the TweetSet worksheet");$skip(25); 

  val set1 = new Empty;System.out.println("""set1  : objsets.Empty = """ + $show(set1 ));$skip(53); 
  val set2 = set1.incl(new Tweet("a", "a body", 20));System.out.println("""set2  : objsets.TweetSet = """ + $show(set2 ));$skip(53); 
  val set3 = set2.incl(new Tweet("b", "b body", 21));System.out.println("""set3  : objsets.TweetSet = """ + $show(set3 ));$skip(38); 
  val c = new Tweet("c", "c body", 7);System.out.println("""c  : objsets.Tweet = """ + $show(c ));$skip(38); 
  val d = new Tweet("d", "d body", 9);System.out.println("""d  : objsets.Tweet = """ + $show(d ));$skip(27); 
  val set4c = set3.incl(c);System.out.println("""set4c  : objsets.TweetSet = """ + $show(set4c ));$skip(27); 
  val set4d = set3.incl(d);System.out.println("""set4d  : objsets.TweetSet = """ + $show(set4d ));$skip(27); 
  val set5 = set4c.incl(d);System.out.println("""set5  : objsets.TweetSet = """ + $show(set5 ));$skip(23); val res$0 = 

  set5.mostRetweeted;System.out.println("""res0: objsets.Tweet = """ + $show(res$0));$skip(72); val res$1 = 
                                                  
  set2.mostRetweeted;System.out.println("""res1: objsets.Tweet = """ + $show(res$1));$skip(62); val res$2 = 
  
  //set1.mostRetweeted

  set5.descendingByRetweet.reverse;System.out.println("""res2: objsets.TweetList = """ + $show(res$2));$skip(35); val res$3 = 
  set1.descendingByRetweet.reverse;System.out.println("""res3: objsets.TweetList = """ + $show(res$3));$skip(83); 
  
  
   val wordList = List("scala", "akka", "play framework", "sbt", "typesafe");System.out.println("""wordList  : List[String] = """ + $show(wordList ));$skip(72); 
    val tweet = "This is an example tweet talking about scala and sbt.";System.out.println("""tweet  : String = """ + $show(tweet ));$skip(55); val res$4 = 
  (wordList.foldLeft(false)( _ || tweet.contains(_) ));System.out.println("""res4: Boolean = """ + $show(res$4));$skip(32); val res$5 = 
wordList.exists(tweet.contains);System.out.println("""res5: Boolean = """ + $show(res$5))}
}
