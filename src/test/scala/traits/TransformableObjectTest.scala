package traits

import atoms._
import org.scalatest.funsuite.AnyFunSuite
import utils.Utils._
import scala.language.postfixOps

class TransformableObjectTest extends AnyFunSuite {
  val x1: Double = 4.6
  val y1: Double = 2.6
  val x2: Double = 6.9
  val y2: Double = 8.3

  val circle: TransformableObject = new Circle centered (x1, y1) shift (5.1, -2.3)
  var square: TransformableObject = new UnitSquare rotate 52.5
  var rectangle: TransformableObject = new Box from (x1, y1) to (x2, y2) scale 2.5
  var triangle: TransformableObject = new Polygon sides 3 xscale 3.2
  val ellipse: TransformableObject = new Ellipse centered (x2, y2) yscale 0.25
  val hexagon: TransformableObject = new Polygon sides 6 shift (2.1, 3.2) rotate 25.6

  test("TransformableObject.shift") {
    assert((circle toAsyString) === ("draw(shift(5.1, -2.3) * circle("
      concat (x1, y1) concat ", 1.0), black);\n"))
  }

  test("TransformableObject.rotate") {
    assert((square toAsyString) === "draw(rotate(52.5) * unitsquare, black);\n")
  }

  test("TransformableObject.scale") {
    assert((rectangle toAsyString) === ("draw(scale(2.5) * box(" concat
      (x1, y1) concat ", " concat (x2, y2) concat "), black);\n"))
  }

  test("TransformableObject.xscale") {
    assert((triangle toAsyString) === "draw(xscale(3.2) * polygon(3), black);\n")
  }

  test("TransformableObject.yscale") {
    assert((ellipse toAsyString) === ("draw(yscale(0.25) * ellipse("
      concat (x2, y2) concat ", 1.0,1.0), black);\n"))
  }

  test("TransformableObject.shift_rotate_composition") {
    assert((hexagon toAsyString) === "draw(rotate(25.6) * shift(2.1, 3.2) * polygon(6), black);\n")
  }

  test("TransformableObject.composition_noncommutativity") {
    assert((hexagon toAsyString) !== "draw(shift(2.1, 3.2) * rotate(25.6) * polygon(6), black);\n")
  }
}