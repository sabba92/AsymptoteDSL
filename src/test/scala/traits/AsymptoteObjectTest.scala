package traits

import atoms._
import org.scalatest.funsuite.AnyFunSuite

import scala.language.postfixOps

class AsymptoteObjectTest extends AnyFunSuite {

  val hexagon: AsymptoteObject = new Polygon sides 6 lineStyle "linetype(\"1 4\")"
  val octagon: AsymptoteObject = new Polygon sides 8 color "red"

  test("AsymptoteObject.color") {
    assert((hexagon toAsyString) === "draw(polygon(6), black+linetype(\"1 4\"));\n")
  }

  test("AsymptoteObject.linestyle") {
    assert((octagon toAsyString) === "draw(polygon(8), red);\n")
  }
}