package atoms

import org.scalatest.funsuite.AnyFunSuite
import utils.Utils._
import scala.language.postfixOps

class DotTest extends AnyFunSuite {
  val x: Double = 8.1
  val y: Double = 6.6

  val dot: Dot = new Dot in (x, y)

  test("Dot.in") {
    assert((dot toAsyString) === ("dot(" concat (x, y) concat ", black);\n"))
  }

  test("Dot.in_equality") {
    assert((dot toAsyString) ===
           (new Dot in Point(x, y) toAsyString))
  }
}