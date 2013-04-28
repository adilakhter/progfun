package objsets

object TweetSetWSheet {
  println("Welcome to the TweetSet worksheet")    //> Welcome to the TweetSet worksheet

  val set1 = new Empty                            //> set1  : objsets.Empty = objsets.Empty@78dc6a77
  val set2 = set1.incl(new Tweet("a", "a body", 20))
                                                  //> set2  : objsets.TweetSet = objsets.NonEmpty@36ff057f
  val set3 = set2.incl(new Tweet("b", "b body", 21))
                                                  //> set3  : objsets.TweetSet = objsets.NonEmpty@2d342ba4
  val c = new Tweet("c", "c body", 7)             //> c  : objsets.Tweet = User: c
                                                  //| Text: c body [7]
  val d = new Tweet("d", "d body", 9)             //> d  : objsets.Tweet = User: d
                                                  //| Text: d body [9]
  val set4c = set3.incl(c)                        //> set4c  : objsets.TweetSet = objsets.NonEmpty@3c1d332b
  val set4d = set3.incl(d)                        //> set4d  : objsets.TweetSet = objsets.NonEmpty@210a6ae2
  val set5 = set4c.incl(d)                        //> set5  : objsets.TweetSet = objsets.NonEmpty@32ef2c60

  set5.mostRetweeted                              //> res0: objsets.Tweet = User: b
                                                  //| Text: b body [21]
                                                  
  set2.mostRetweeted                              //> res1: objsets.Tweet = User: a
                                                  //| Text: a body [20]
  
  //set1.mostRetweeted

  set5.descendingByRetweet.reverse                //> res2: objsets.TweetList = User: c
                                                  //| Text: c body [7],User: d
                                                  //| Text: d body [9],User: a
                                                  //| Text: a body [20],User: b
                                                  //| Text: b body [21],Nil
  set1.descendingByRetweet.reverse                //> res3: objsets.TweetList = Nil
  
  
   val wordList = List("scala", "akka", "play framework", "sbt", "typesafe")
                                                  //> wordList  : List[String] = List(scala, akka, play framework, sbt, typesafe)
                                                  //| 
    val tweet = "This is an example tweet talking about scala and sbt."
                                                  //> tweet  : String = This is an example tweet talking about scala and sbt.
  (wordList.foldLeft(false)( _ || tweet.contains(_) ))
                                                  //> res4: Boolean = true
wordList.exists(tweet.contains)                   //> res5: Boolean = true
}