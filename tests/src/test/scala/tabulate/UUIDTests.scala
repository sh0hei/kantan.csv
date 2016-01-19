package tabulate

import java.util.UUID

import org.scalacheck.{Arbitrary, Gen}
import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.typelevel.discipline.scalatest.Discipline
import tabulate.laws.discipline.CellCodecTests
import tabulate.laws.discipline.arbitrary._

class UUIDTests extends FunSuite with GeneratorDrivenPropertyChecks with Discipline {
  implicit val arbUUID = Arbitrary(Gen.uuid)

  checkAll("UUID", CellCodecTests[UUID].cellCodec[String, Float])
}