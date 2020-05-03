package atoms

import org.scalatest.funsuite.AnyFunSuite
import utils.Utils._
import scala.language.postfixOps

class EllipseTest extends AnyFunSuite {
  val x: Double = 9.8
  val y: Double = 4.2
  val axes: (Double, Double) = (6.2, 2.4)

  val ellipse: Ellipse = new Ellipse centered (x, y) axes axes

  test("Ellipse.axes") {
    assert((ellipse toAsyString) === ("draw(ellipse(" concat (x, y)
      concat ", " concat axes.toString.drop(1).dropRight(1) concat "), black);\n"))
  }
}