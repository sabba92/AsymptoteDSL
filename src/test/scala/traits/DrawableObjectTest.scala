package traits

import atoms._
import org.scalatest.funsuite.AnyFunSuite

import scala.language.postfixOps

class DrawableObjectTest extends AnyFunSuite {

  val circle: DrawableObject = new UnitCircle fill true
  val square: DrawableObject = new UnitSquare fill true

  test("DrawableObject.fill") {
    assert((circle toAsyString) === "fill(unitcircle, black);\n")
    assert((square toAsyString) === "fill(unitsquare, black);\n")
  }
}