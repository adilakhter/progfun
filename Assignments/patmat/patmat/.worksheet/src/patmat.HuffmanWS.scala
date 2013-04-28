package patmat
import patmat.Huffman._
object HuffmanWS{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(100); 
  println("Welcome to the Scala worksheet");$skip(64); 
  
    val t = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5);System.out.println("""t  : patmat.Huffman.Fork = """ + $show(t ));$skip(103); 
    val tt = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9);System.out.println("""tt  : patmat.Huffman.Fork = """ + $show(tt ));$skip(24); val res$0 = 
    
    weight(t) == 5;System.out.println("""res0: Boolean = """ + $show(res$0));$skip(20); val res$1 = 
    
    weight(tt);System.out.println("""res1: Int = """ + $show(res$1));$skip(19); val res$2 = 
    
    chars(t);System.out.println("""res2: List[Char] = """ + $show(res$2));$skip(15); val res$3 = 

    chars(tt);System.out.println("""res3: List[Char] = """ + $show(res$3));$skip(28); val res$4 = 
    
    string2Chars("Hi");System.out.println("""res4: List[Char] = """ + $show(res$4));$skip(60); 

  
    val freqs = times(List('a', 'b', 'a', 'c','b','a'));System.out.println("""freqs  : List[(Char, Int)] = """ + $show(freqs ));$skip(36); val res$5 = 
    
    makeOrderedLeafList(freqs);System.out.println("""res5: List[patmat.Huffman.Leaf] = """ + $show(res$5));$skip(135); val res$6 = 
    
    
    // res should be List(Leaf('e',1), Leaf('t',2), Leaf('x',3))
    makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3)));System.out.println("""res6: List[patmat.Huffman.Leaf] = """ + $show(res$6));$skip(65); 
     val lflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4));System.out.println("""lflist  : List[patmat.Huffman.Leaf] = """ + $show(lflist ));$skip(101); val res$7 = 
     // res  List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
     combine(lflist);System.out.println("""res7: List[patmat.Huffman.CodeTree] = """ + $show(res$7));$skip(44); val res$8 = 

    
    until(singleton, combine)(lflist);System.out.println("""res8: List[patmat.Huffman.CodeTree] = """ + $show(res$8));$skip(70); 
    val tree = createCodeTree('t'::'e'::'x'::'t'::'x'::'x'::'x'::Nil);System.out.println("""tree  : patmat.Huffman.CodeTree = """ + $show(tree ));$skip(60); 

    val (ls, ch) = decodeCharecter(tree, List(0,0,0, 1,1));System.out.println("""ls  : List[patmat.Huffman.Bit] = """ + $show(ls ));System.out.println("""ch  : Char = """ + $show(ch ));$skip(52); 
    
    val (ls1, ch1) = decodeCharecter(tree, ls);System.out.println("""ls1  : List[patmat.Huffman.Bit] = """ + $show(ls1 ));System.out.println("""ch1  : Char = """ + $show(ch1 ));$skip(51); 
  
    val (ls2, ch2) = decodeCharecter(tree, ls1);System.out.println("""ls2  : List[patmat.Huffman.Bit] = """ + $show(ls2 ));System.out.println("""ch2  : Char = """ + $show(ch2 ));$skip(41); val res$9 = 

   decode(tree, List(0,0,0, 1,1,1,0,0));System.out.println("""res9: List[Char] = """ + $show(res$9));$skip(21); val res$10 = 
   
   decodedSecret;System.out.println("""res10: List[Char] = """ + $show(res$10));$skip(37); val res$11 = 

 
    encode(tree) ("eextt".toList);System.out.println("""res11: List[patmat.Huffman.Bit] = """ + $show(res$11));$skip(58); 
    val res = encode(tree)(List('e', 't', 'x', 'x', 'e'));System.out.println("""res  : List[patmat.Huffman.Bit] = """ + $show(res ));$skip(34); val res$12 = 
    res == List(0,0,0, 1,1,1,0,0);System.out.println("""res12: Boolean = """ + $show(res$12));$skip(32); 
    
    val ct = convert(tree);System.out.println("""ct  : patmat.Huffman.CodeTable = """ + $show(ct ));$skip(27); val res$13 = 
    
    codeBits(ct)('e');System.out.println("""res13: List[patmat.Huffman.Bit] = """ + $show(res$13));$skip(22); val res$14 = 
    codeBits(ct)('t');System.out.println("""res14: List[patmat.Huffman.Bit] = """ + $show(res$14));$skip(22); val res$15 = 
    codeBits(ct)('x');System.out.println("""res15: List[patmat.Huffman.Bit] = """ + $show(res$15));$skip(46); val res$16 = 

    quickEncode(tree)("etxxe".toList) == res;System.out.println("""res16: Boolean = """ + $show(res$16))}

}
