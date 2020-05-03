package complex

import org.scalatest.funsuite.AnyFunSuite

import scala.language.postfixOps

class AxesTest extends AnyFunSuite {
  var axes: Axes = new Axes

  test("Axes.init") {
    assert(axes.start === 0)
    assert(axes.stop === 0)
  }

  test("Axes.from") {
    axes from -9.2
    assert(axes.start === -9.2)
  }

  test("Axes.to") {
    axes to 18.9
    assert(axes.stop === 18.9)
  }

  test("Axes.every") {
    axes every (5, 2.5)
    // 4 primary ticks + 4 primary labels + 10 secondary ticks per axis + origin
    val n = (4 * 2 + 10) * 2 + 1
    assert((axes.ticks size) === n)
  }
}