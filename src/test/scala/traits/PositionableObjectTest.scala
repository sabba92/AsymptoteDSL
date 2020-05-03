package traits

import atoms._
import org.scalatest.funsuite.AnyFunSuite

import scala.language.postfixOps

class PositionableObjectTest extends AnyFunSuite {

  val place1: PositionableObject = new Place("place1", 0, 0, null)
  val trans1: PositionableObject = new Transition("trans1", 1, 0, null)
  val place2: PositionableObject = new Place("place2", 2, 0, null)
  val trans2: PositionableObject = new Transition("trans2", 0, 1, null)
  val place3: PositionableObject = new Place("place3", 0, 2, null)

  test("PositionableObject.getPosition") {
    assert((place1 getPosition) === Point(0, 0))
    assert((trans1 getPosition) === Point(1, 0))
    assert((place2 getPosition) === Point(2, 0))
    assert((trans2 getPosition) === Point(0, 1))
    assert((place3 getPosition) === Point(0, 2))
  }

  test("PositionableObject.<") {
    assert((place1 < (place2, "x")) === true)
    assert((place1 < (trans1, "x")) === true)
    assert((trans1 < (place2, "x")) === true)
    assert((place2 < (place1, "x")) === false)
    assert((place2 < (trans1, "x")) === false)

    assert((place1 < (place3, "y")) === true)
    assert((place1 < (trans2, "y")) === true)
    assert((trans2 < (place3, "y")) === true)
    assert((place3 < (place1, "y")) === false)
    assert((place3 < (trans2, "y")) === false)

    assert((place1 < (place3, "x")) === false)
    assert((place1 < (place2, "y")) === false)
  }
}