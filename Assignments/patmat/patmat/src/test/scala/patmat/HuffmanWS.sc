package patmat
import patmat.Huffman._
object HuffmanWS{
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
    val t = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
                                                  //> t  : patmat.Huffman.Fork = Fork(Leaf(a,2),Leaf(b,3),List(a, b),5)
    val tt = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
                                                  //> tt  : patmat.Huffman.Fork = Fork(Fork(Leaf(a,2),Leaf(b,3),List(a, b),5),Leaf
                                                  //| (d,4),List(a, b, d),9)
    
    weight(t) == 5                                //> res0: Boolean = true
    
    weight(tt)                                    //> res1: Int = 9
    
    chars(t)                                      //> res2: List[Char] = List(a, b)

    chars(tt)                                     //> res3: List[Char] = List(a, b, d)
    
    string2Chars("Hi")                            //> res4: List[Char] = List(H, i)

  
    val freqs = times(List('a', 'b', 'a', 'c','b','a'))
                                                  //> freqs  : List[(Char, Int)] = List((a,3), (b,2), (c,1))
    
    makeOrderedLeafList(freqs)                    //> res5: List[patmat.Huffman.Leaf] = List(Leaf(c,1), Leaf(b,2), Leaf(a,3))
    
    
    // res should be List(Leaf('e',1), Leaf('t',2), Leaf('x',3))
    makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3)))
                                                  //> res6: List[patmat.Huffman.Leaf] = List(Leaf(e,1), Leaf(t,2), Leaf(x,3))
     val lflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
                                                  //> lflist  : List[patmat.Huffman.Leaf] = List(Leaf(e,1), Leaf(t,2), Leaf(x,4))
                                                  //| 
     // res  List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
     combine(lflist)                              //> res7: List[patmat.Huffman.CodeTree] = List(Fork(Leaf(e,1),Leaf(t,2),List(e, 
                                                  //| t),3), Leaf(x,4))

    
    until(singleton, combine)(lflist)             //> res8: List[patmat.Huffman.CodeTree] = List(Fork(Fork(Leaf(e,1),Leaf(t,2),Lis
                                                  //| t(e, t),3),Leaf(x,4),List(e, t, x),7))
    val tree = createCodeTree('t'::'e'::'x'::'t'::'x'::'x'::'x'::Nil)
                                                  //> tree  : patmat.Huffman.CodeTree = Fork(Fork(Leaf(e,1),Leaf(t,2),List(e, t),3
                                                  //| ),Leaf(x,4),List(e, t, x),7)

    val (ls, ch) = decodeCharecter(tree, List(0,0,0, 1,1))
                                                  //> ls  : List[patmat.Huffman.Bit] = List(0, 1, 1)
                                                  //| ch  : Char = e
    
    val (ls1, ch1) = decodeCharecter(tree, ls)    //> ls1  : List[patmat.Huffman.Bit] = List(1)
                                                  //| ch1  : Char = t
  
    val (ls2, ch2) = decodeCharecter(tree, ls1)   //> ls2  : List[patmat.Huffman.Bit] = List()
                                                  //| ch2  : Char = x

   decode(tree, List(0,0,0, 1,1,1,0,0))           //> res9: List[Char] = List(e, t, x, x, e)
   
   decodedSecret                                  //> res10: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)

 
    encode(tree) ("eextt".toList)                 //> char: e bits: List(0, 0)
                                                  //| char: t bits: List(0, 1)
                                                  //| char: x bits: List(1)
                                                  //| res11: List[patmat.Huffman.Bit] = List(0, 0, 0, 0, 1, 0, 1, 0, 1)
    val res = encode(tree)(List('e', 't', 'x', 'x', 'e'))
                                                  //> char: e bits: List(0, 0)
                                                  //| char: t bits: List(0, 1)
                                                  //| char: x bits: List(1)
                                                  //| res  : List[patmat.Huffman.Bit] = List(0, 0, 0, 1, 1, 1, 0, 0)
    res == List(0,0,0, 1,1,1,0,0)                 //> res12: Boolean = true
    
    val ct = convert(tree)                        //> ct  : patmat.Huffman.CodeTable = List((e,List(0, 0)), (t,List(0, 1)), (x,Li
                                                  //| st(1)))
    
    codeBits(ct)('e')                             //> res13: List[patmat.Huffman.Bit] = List(0, 0)
    codeBits(ct)('t')                             //> res14: List[patmat.Huffman.Bit] = List(0, 1)
    codeBits(ct)('x')                             //> res15: List[patmat.Huffman.Bit] = List(1)

    quickEncode(tree)("etxxe".toList) == res      //> res16: Boolean = true

}