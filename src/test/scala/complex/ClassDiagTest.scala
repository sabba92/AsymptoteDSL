package complex

import atoms.{UMLAbstract, UMLClass, UMLTrait}
import org.scalatest.funsuite.AnyFunSuite

import scala.language.postfixOps

class ClassDiagTest extends AnyFunSuite {

  val umlTrait: UMLClass = new UMLTrait("trait", (1, -1))
  val umlClass: UMLClass = new UMLClass("class", (10, -10)) withAttr
    List(("attrib1", "type"))
  val umlAbstract: UMLClass = new UMLAbstract("abstract", (60, -60)) withMeth
    List(("method1", List("params"), "type"),
      ("method2", List("params"), "type"),
      ("method3", List("params"), "type"),
      ("method_", List("params"), "type"))
  val diag: ClassDiag = new ClassDiag(List(umlAbstract, umlClass, umlTrait), List(
    (umlAbstract, "CE", umlClass, "CW", "-|>"),
    (umlClass, "S", umlAbstract, "N", "--|>")))

  test("ClassDiag.init") {
    // 1 box + 2 lines + 1 label per class +
    // 1 line and 1 head per arrow
    val n: Int = 4 * 3 + 2 * 2
    assert((diag.obj size) == n)
  }
}