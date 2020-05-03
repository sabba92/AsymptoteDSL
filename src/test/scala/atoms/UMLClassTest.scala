package atoms

import org.scalatest.funsuite.AnyFunSuite

import scala.language.postfixOps

class UMLClassTest extends AnyFunSuite {

  val umlTrait: UMLClass = new UMLTrait("trait", (1, -1))
  val umlClass: UMLClass = new UMLClass("class", (10, -10)) withAttr
    List(("attrib1", "type"))
  val umlAbstract: UMLClass = new UMLAbstract("abstract", (60, -60)) withMeth
    List(("method1", List("params"), "type"),
      ("method2", List("params"), "type"),
      ("method3", List("params"), "type"),
      ("method_", List("params"), "type"))

  test("UMLClass.init") {
    assert((umlTrait.attribs size) === 0)
    assert((umlTrait.methods size) === 0)
  }

  test("UMLClass.withAttrib") {
    assert((umlClass.attribs size) === 1)
    assert((umlClass.methods size) === 0)
  }

  test("UMLClass.withMeth") {
    assert((umlAbstract.attribs size) === 0)
    assert((umlAbstract.methods size) === 4)
  }
}