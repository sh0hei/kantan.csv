package kantan.csv

import org.scalacheck.{Gen, Arbitrary}
import org.scalacheck.Arbitrary._
import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.typelevel.discipline.scalatest.Discipline
import kantan.csv.laws._
import kantan.csv.laws.discipline.RowCodecTests
import TupleTests._
import kantan.csv.laws.discipline.arbitrary._

class TupleTests extends FunSuite with GeneratorDrivenPropertyChecks with Discipline {
  implicit def tuple1[A: Arbitrary]: Arbitrary[Tuple1[A]] = Arbitrary(arbitrary[A].map(Tuple1.apply))

  checkAll("Tuple1[Int]", RowCodecTests[Tuple1[Int]].rowCodec[List[String], List[Float]])
  checkAll("(Int, Int)", RowCodecTests[(Int, Int)].rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int)", RowCodecTests[(Int, Int, Int)].rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int, Int)", RowCodecTests[(Int, Int, Int, Int)].rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int, Int, Int)", RowCodecTests[(Int, Int, Int, Int, Int)].rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int, Int, Int, Int)", RowCodecTests[(Int, Int, Int, Int, Int, Int)].rowCodec[List[String],
    List[Float]])
  checkAll("(Int, Int, Int, Int, Int, Int, Int)",
    RowCodecTests[(Int, Int, Int, Int, Int, Int, Int)].rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int, Int, Int, Int, Int, Int)",
    RowCodecTests[(Int, Int, Int, Int, Int, Int, Int, Int)].rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int, Int, Int, Int, Int, Int, Int)",
    RowCodecTests[(Int, Int, Int, Int, Int, Int, Int, Int, Int)].rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)",
    RowCodecTests[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)].rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)",
    RowCodecTests[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)].rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)",
    RowCodecTests[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)].rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)",
    RowCodecTests[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)]
      .rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)",
    RowCodecTests[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)]
      .rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)",
    RowCodecTests[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)]
      .rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)",
    RowCodecTests[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)]
      .rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)",
    RowCodecTests[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)]
      .rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)",
    RowCodecTests[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)]
      .rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)",
    RowCodecTests[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)]
      .rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)",
    RowCodecTests[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)]
      .rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)",
    RowCodecTests[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int,
      Int)].rowCodec[List[String], List[Float]])
  checkAll("(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)",
    RowCodecTests[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int,
      Int, Int)].rowCodec[List[String], List[Float]])
}

object TupleTests {
  implicit def illegalTuple[A]: Arbitrary[IllegalRow[A]] = illegal(Gen.alphaChar.map(s ⇒ Seq(s.toString)))
}