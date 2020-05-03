package atoms

import org.scalatest.funsuite.AnyFunSuite
import traits.AsymptoteObject
import utils.Utils._
import scala.language.postfixOps

class LabelTest extends AnyFunSuite {
  val text: String = "test"
  val x: Double = 5.6
  val y: Double = 8.4
  val align: String = "E"
  val color: String = "red"

  val label1: Label = new Label on (x, y) saying text
  val label2: Label = new Label on (x, y) saying text aligned align
  val label3: AsymptoteObject = new Label on (x, y) saying text aligned align color color

  test("Label.saying") {
    assert((label1 toAsyString) === ("label(\"" concat text concat "\", " concat
      (x, y) concat ", align = NoAlign, black);\n"))
  }

  test("Label.aligned") {
    assert((label2 toAsyString) === ("label(\"" concat text concat "\", " concat
      (x, y) concat ", align = " concat align  concat ", black);\n"))
  }

  test("Label.color") {
    assert((label3 toAsyString) === ("label(\"" concat text concat "\", " concat
      (x, y) concat ", align = " concat align concat ", " concat color concat ");\n"))
  }

  test("Label.on_equality") {
    assert((label3 toAsyString) ===
           (new Label on Point(x, y) saying text aligned align color color toAsyString))
  }
}