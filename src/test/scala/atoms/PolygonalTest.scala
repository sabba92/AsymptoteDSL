package atoms

import org.scalatest.funsuite.AnyFunSuite
import utils.Utils._
import scala.language.postfixOps

class PolygonalTest extends AnyFunSuite {
  val x1: Double = 4.2
  val y1: Double = 7.1
  val x2: Double = 2.3
  val y2: Double = 1.3
  val x3: Double = 7.2
  val y3: Double = 6.9

  val polygonal: Line = new Polygonal from (x1, y1) to (x2, y2) to (x3, y3)

  test("Polygonal.toAsyString") {
    assert((polygonal toAsyString) === ("draw(" concat (x1, y1) concat " -- "
      concat (x2, y2) concat " -- " concat (x3, y3) concat "--cycle, black);\n"))
  }
}