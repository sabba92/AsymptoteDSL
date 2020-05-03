package atoms

import org.scalatest.funsuite.AnyFunSuite

import scala.language.postfixOps

class UnitCircleTest extends AnyFunSuite {

  test("UnitCircle.toAsyString") {
    assert((new UnitCircle toAsyString) === "draw(unitcircle, black);\n")
  }
}