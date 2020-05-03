package atoms

import org.scalatest.funsuite.AnyFunSuite
import utils.Utils._
import scala.language.postfixOps

class BoxTest extends AnyFunSuite {
  val x1: Double = 3.1
  val y1: Double = 6.8
  val x2: Double = 12.5
  val y2: Double = 11.4
  val color: String = "blue"

  val box: Box = new Box from (x1, y1) to (x2, y2)
  val blueBox: Box = new Box from (x1, y1) to (x2, y2) color color

  test("Box.from_to") {
    assert((box toAsyString) === ("draw(box(" concat (x1, y1) concat
      ", " concat (x2, y2) concat "), black);\n"))
  }

  test("Box.color") {
    assert((blueBox toAsyString) === ("draw(box(" concat (x1, y1) concat
      ", " concat (x2, y2) concat "), " concat color concat ");\n"))
  }

  test("Box.from_to_equality") {
    assert((box toAsyString) ===
           (new Box from Point(x1, y1) to Point(x2, y2) toAsyString))
  }
}