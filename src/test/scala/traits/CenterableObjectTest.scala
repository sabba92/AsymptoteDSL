package traits

import atoms._
import org.scalatest.funsuite.AnyFunSuite
import utils.Utils._
import scala.language.postfixOps

class CenterableObjectTest extends AnyFunSuite {
  val x: Double = 4.6
  val y: Double = 2.6

  val circle: CenterableObject = new Circle centered (x, y)
  val ellipse: CenterableObject = new Ellipse centered (x, y)

  test("CenterableObject.centered") {
    assert((circle toAsyString) === ("draw(circle(" concat (x, y) concat ", 1.0), black);\n"))
    assert((ellipse toAsyString) === ("draw(ellipse(" concat (x, y) concat ", 1.0,1.0), black);\n"))
  }

  test("CenterableObject.centered_equality") {
    assert((circle toAsyString) === (new Circle centered Point(x, y) toAsyString))
    assert((ellipse toAsyString) === (new Ellipse centered Point(x, y) toAsyString))
  }
}