package atoms

import org.scalatest.funsuite.AnyFunSuite
import utils.Utils._
import scala.language.postfixOps

class PointTest extends AnyFunSuite {
  val x1: Double = 5.3
  val y1: Double = 4.6
  val x2: Double = 3.9
  val y2: Double = 8.4
  val dx: Double = 3.6
  val dy: Double = 6.3
  val f: Double = 2.1

  val p1: Point = Point(x1, y1)
  val p2: Point = Point(x2, y2)

  test("Point.toAsyString") {
    assert((p1 toAsyString) === coordsToString(x1, y1))
    assert((p2 toAsyString) === coordsToString(x2, y2))
  }

  test("Point.+") {
    assert((p1 + (dx, dy) toAsyString) === coordsToString(x1 + dx, y1 + dy))
    assert((p1 + p2 toAsyString) === coordsToString(x1 + x2, y1 + y2))
  }

  test("Point.-") {
    assert((p2 - (dx, dy) toAsyString) === coordsToString(x2 - dx, y2 - dy))
    assert((p1 - p2 toAsyString) === coordsToString(x1 - x2, y1 - y2))
  }

  test("Point.*") {
    assert((p2 * f toAsyString) === coordsToString(x2 * f, y2 * f))
  }
}