/*
 * Copyright 2015 Nicolas Rinaudo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kantan.csv

import kantan.codecs.laws.discipline.SerializableTests
import kantan.csv.laws.discipline._
import kantan.csv.laws.discipline.arbitrary._
import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.typelevel.discipline.scalatest.Discipline

class OptionCodecTests extends FunSuite with GeneratorDrivenPropertyChecks with Discipline {
  checkAll("CellEncoder[Option[Int]]", SerializableTests[CellEncoder[Option[Int]]].serializable)
  checkAll("CellDecoder[Option[Int]]", SerializableTests[CellDecoder[Option[Int]]].serializable)

  checkAll("RowEncoder[Option[(Int, Int, Int)]]", SerializableTests[RowEncoder[Option[(Int, Int, Int)]]].serializable)
  checkAll("RowDecoder[Option[(Int, Int, Int)]]", SerializableTests[RowDecoder[Option[(Int, Int, Int)]]].serializable)

  checkAll("CellCodec[Option[Int]]", CellCodecTests[Option[Int]].codec[String, Float])
  checkAll("RowCodec[Option[(Int, Int, Int)]]", RowCodecTests[Option[(Int, Int, Int)]].codec[Byte, String])
}
