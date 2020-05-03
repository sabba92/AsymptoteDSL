package atoms

import org.scalatest.funsuite.AnyFunSuite
import utils.Utils._
import scala.language.postfixOps

class LineTest extends AnyFunSuite {
  val x1: Double = 4.2
  val y1: Double = 7.1
  val x2: Double = 2.3
  val y2: Double = 1.3
  val x3: Double = 7.2
  val y3: Double = 6.9

  val line2: Line = new Line from (x1, y1) to (x2, y2)
  val line3: Line = new Line from (x1, y1) to (x2, y2) to (x3, y3)
  val curvedLine: Line = new Line from (x1, y1) to (x2, y2) curved

  test("Line.from_to") {
    assert((line2 toAsyString) === ("draw(" concat (x1, y1) concat
      " -- " concat (x2, y2) concat ", black);\n"))
  }

  test("Line.multiple_to") {
    assert((line3 toAsyString) === ("draw(" concat (x1, y1) concat " -- "
      concat (x2, y2) concat " -- " concat (x3, y3) concat ", black);\n"))
  }

  test("Line.curved") {
    assert((curvedLine toAsyString) === ("draw(" concat (x1, y1) concat
      " .. " concat (x2, y2) concat ", black);\n"))
  }

  test("Line.from_to_equality") {
    assert((line2 toAsyString) ===
           (new Line from Point(x1, y1) to Point(x2, y2) toAsyString))
  }

  test("Line.points_number") {
    val line = new Line
    assert(line.points.size === 0)
    line from (0, 0) to (1, 2)
    assert(line.points.size === 2)
    line to (2, 5)
    assert(line.points.size === 3)
    line to (3, 8) to (4, 6)
    assert(line.points.size === 5)
  }
}