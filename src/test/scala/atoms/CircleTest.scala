package atoms

import org.scalatest.funsuite.AnyFunSuite
import utils.Utils._
import scala.language.postfixOps

class CircleTest extends AnyFunSuite {
  val x: Double = 7.1
  val y: Double = 1.6
  val radius: Double = 3.4

  val circle: Circle = new Circle centered (x, y) radius radius

  test("Circle.radius") {
    assert((circle toAsyString) === ("draw(circle(" concat (x, y)
      concat ", " concat radius.toString concat "), black);\n"))
  }
}