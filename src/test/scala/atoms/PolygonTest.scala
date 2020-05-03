package atoms

import org.scalatest.funsuite.AnyFunSuite
import traits.AsymptoteObject

import scala.language.postfixOps

class PolygonTest extends AnyFunSuite {

  val triangle: Polygon = new Polygon sides 3
  val greenPentagon: AsymptoteObject = new Polygon sides 5 color "green"

  test("Polygon.sides") {
    assert((triangle toAsyString) === "draw(polygon(3), black);\n")
  }

  test("Polygon.color") {
    assert((greenPentagon toAsyString) === "draw(polygon(5), green);\n")
  }
}