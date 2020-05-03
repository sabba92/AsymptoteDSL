package atoms

import org.scalatest.funsuite.AnyFunSuite

import scala.language.postfixOps

class PropTest extends AnyFunSuite {
  val text: String = "text"

  val prop: Prop = new Prop(text)

  test("Prop.toAsyString") {
    assert((prop toAsyString) === (text concat "\n"))
  }
}