package atoms

import org.scalatest.funsuite.AnyFunSuite
import utils.Utils._
import scala.language.postfixOps

class ArrowTest extends AnyFunSuite {

  val x1: Double = 5.4
  val y1: Double = 6.3
  val x2: Double = 7.2
  val y2: Double = 8.1

  val arrow: Line = new Arrow from (x1, y1) to (x2, y2)
  val simpleArrow: Line = new Arrow style "SimpleHead" from (x1, y1) to (x2, y2)
  val littleArrow: Line = new Arrow style true from (x1, y1) to (x2, y2)
  val littleHookArrow: Line = new Arrow style ("HookHead", true) from (x1, y1) to (x2, y2)

  test("Arrow.style") {
    assert((arrow toAsyString) === ("draw(" concat (x1, y1) concat
      " -- " concat (x2, y2) concat ", arrow = Arrow(), black);\n"))
  }

  test("Arrow.style_shape") {
    assert((simpleArrow toAsyString) === ("draw(" concat (x1, y1) concat
      " -- " concat (x2, y2) concat ", arrow = Arrow(SimpleHead), black);\n"))
  }

  test("Arrow.style_size") {
    assert((littleArrow toAsyString) === ("draw(" concat (x1, y1) concat
      " -- " concat (x2, y2) concat ", arrow = ArcArrow(), black);\n"))
  }

  test("Arrow.style_size_shape") {
    assert((littleHookArrow toAsyString) === ("draw(" concat (x1, y1) concat
      " -- " concat (x2, y2) concat ", arrow = ArcArrow(HookHead), black);\n"))
  }

  test("Arrow.style_equality") {
    assert((littleHookArrow toAsyString) ===
           (new Arrow style (true, "HookHead") from Point(x1, y1) to Point(x2, y2) toAsyString))
  }
}