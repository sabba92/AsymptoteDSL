package atoms

import org.scalatest.funsuite.AnyFunSuite

import scala.language.postfixOps

class UnitSquareTest extends AnyFunSuite {

  test("UnitSquare.toAsyString") {
    assert((new UnitSquare toAsyString) === "draw(unitsquare, black);\n")
  }
}