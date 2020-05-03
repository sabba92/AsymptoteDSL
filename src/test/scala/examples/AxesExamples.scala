package examples

import atoms._
import complex.Axes
import org.scalatest.funsuite.AnyFunSuite
import traits.{AsymptoteObject, TransformableObject}
import utils.DSLTest

import scala.language.postfixOps

class AxesExamples extends AnyFunSuite {
  val props: List[AsymptoteObject] = List(
    new Prop("size(15cm, 15cm);")
  )

  val refAxes: Axes = new Axes from -8 to 21 every (3, 1.5)
  val p: Point = Point(Math.sqrt(2) * 5 / 2, Math.exp(5 / 2))

  val axes2: List[AsymptoteObject] = List(
    refAxes,
    new Dot in (9, 5),
    new Dot in Point(8.5, 8.5),
    new Dot in (3, 3) color "red",
    new Dot in p color "blue",
    new Label on p saying "$ (\\frac{5}{2} \\sqrt 2, e^\\frac{5}{2}) $" aligned "E"
  )

  val axes3: List[AsymptoteObject] = List(
    refAxes,
    new Dot in p color "red",
    new Label on p saying "N" aligned "N",
    new Label on p saying "W" aligned "W" color "blue",
    new Label on p saying "SE" aligned "SE"
  )

  val axes4: List[AsymptoteObject] = List(
    refAxes,
    new Polygonal from (-3, -3) to (5, 8) to (8, 5) color "blue",
    new Polygonal from (9, 9) to (11, 16) to (3, 10) to (12, 12) fill true color "green",
    new Line from (12, -1) to (15, -4) to (12, 3) color "orange",
    new Line from (12, -1) to (15, -4) to (12, 3) curved,
    new Arrow from (-4.5, -1) to (-4.5, 10) lineStyle "linetype(\"8 8\")" color "red",
    new Line from (-3, -1) to (-3, 10) lineStyle "linetype(\"1 4\")" color "blue",
    new Line from (-6, -1) to (-6, 10) lineStyle "linetype(\"1 4 4 4\")" color "orange",
    new Arrow from (6, -7) to (10, -2) to (15, -6) color "blue",
    new Arrow from (6, -7) to (10, -2) to (15, -6) curved,
    new Arrow style "SimpleHead" from (12, 5) to (16, 5) color "red",
    new Label on (16, 5) saying "SimpleHead, false" aligned "E" color "red",
    new Arrow style ("SimpleHead", true) from (12, 7) to (16, 7) color "orange",
    new Label on (16, 7) saying "SimpleHead, true" aligned "E" color "orange",
    new Arrow style "HookHead" from (12, 9) to (16, 9) color "green",
    new Label on (16, 9) saying "HookHead, false" aligned "E" color "green",
    new Arrow style ("HookHead", true) from (12, 11) to (16, 11) color "blue",
    new Label on (16, 11) saying "HookHead, true" aligned "E" color "blue",
    new Arrow style "TeXHead" from (12, 13) to (16, 13) color "magenta",
    new Label on (16, 13) saying "TeXHead, false" aligned "E" color "magenta",
    new Arrow style ("TeXHead", true) from (12, 15) to (16, 15) color "gray",
    new Label on (16, 15) saying "TeXHead, true" aligned "E" color "gray",
    new Arrow from (12, 17) to (16, 17) color "yellow",
    new Label on (16, 17) saying "true" aligned "E" color "yellow",
    new Arrow style true from (12, 19) to (16, 19) color "cyan",
    new Label on (16, 19) saying "" aligned "E" color "cyan",
    new Polygonal from (-6, 20) to (1, 20) to (1, 12) to (-6, 12)
      lineStyle "linetype(\"1 4 8 4\")" color "magenta"
  )

  val axes5: List[AsymptoteObject] = List(
    refAxes,
    new Ellipse axes (4, 8) centered (10, 10) color "blue",
    new Ellipse axes (8, 4) centered (10, 10) color "magenta",
    // scaling examples
    new Ellipse axes (4, 8) centered (10, 10) xscale 0.5
      lineStyle "linetype(\"4 8\")" color "blue",
    new Ellipse axes (8, 4) centered (10, 10) yscale 0.5
      lineStyle "linetype(\"1 8\")" color "magenta",
    new UnitSquare color "orange",
    new UnitSquare scale 3 color "green",
    new UnitSquare scale 3 rotate 180 color "red", // rotation example
    new Box from (1, -1) to (2, -3) color "cyan",
    new Box from (1, -1) to (2, -3) shift (2, -2) fill true color "orange",
    // non-commutativity examples
    new Box from (1, -1) to (2, -3) rotate 180 fill true color "blue",
    new Box from (1, -1) to (2, -3) shift (2, -2) rotate 180 color "orange",
    new Box from (1, -1) to (2, -3) rotate 180 shift (2, -2) color "blue"

  )

  val axes6: List[AsymptoteObject] = List(
    refAxes,
    new UnitCircle fill true color "red",
    new UnitCircle scale 5 color "orange",
    new UnitCircle scale 2.5 color "red",
    new UnitCircle scale 5 shift(0, 10) lineStyle "linetype(\"1 4 4 4\")" color "blue",
    new UnitCircle scale 5 shift(10, 10) lineStyle "linetype(\"1 8\")" color "blue",
    new UnitCircle scale 5 shift(10, 0) lineStyle "linetype(\"4 4\")" color "blue",
    new Polygon sides 3,
    new Polygon sides 5 scale 5,
    new Polygon sides 7 scale 5 shift(10, 10) color "orange",
    new Polygon sides 5 rotate 36 scale 5 shift (10, 0),
    new Polygon sides 5 rotate -36 scale 5 shift (0, 10),
    new Circle centered (17, 17) radius 2 lineStyle "linetype(\"1 8\")" color "purple",
    new Circle centered (0, 0) radius 2 xscale 2 yscale 0.5 shift (17, 17)
      lineStyle "linetype(\"8 8\")" color "purple",
    new Circle centered (0, 0) radius 1 yscale 4 shift (17, 17)
      lineStyle "linetype(\"8 8\")" color "purple",
    new Circle centered (0, 0) radius 4 xscale 0.25 rotate 45 shift (17, 17)
      lineStyle "linetype(\"1 4 4 4\")" color "purple",
    new Circle centered (0, 0) radius 4 xscale 0.25 rotate -45 shift (17, 17)
      lineStyle "linetype(\"1 4 4 4\")" color "purple"
  )

  val axes7: List[AsymptoteObject] = List(
    new Polygon sides 3,
    new Polygon sides 3 rotate 20,
    new Polygon sides 3 rotate -20
  )

  def rotatedPolygons(s: Int): List[TransformableObject] =
    for(n <- (1 to 360 / s) toList)
      yield new Polygon sides s rotate n

  val triangles = rotatedPolygons(3)
  val pentagons = rotatedPolygons(5)
  val polygons =
    for(n <- (3 to 9) toList)
      yield new Polygon sides n

  def shift(amount: Double = 0): Point => Point = _ * -1 + (amount, amount)
  def none: Point => Point = identity
  val max: Int = 30
  val range: List[Int] = (1 to max) toList
  val origin: Point = Point(0, 0)

  val parabolic1 = (new Line from (0, max) to origin to (max, 0)) ::
    range.map(i => new Line from (i, 0) to (0, max + 1 - i))

  val parabolic2 = (new Box from origin to (max, max)) ::
    range.flatMap(i => for (op <- List(none, shift(max)))
      yield new Line from op(Point(i, 0)) to op(Point(0, max + 1 - i)))

  val parabolic3 = (new Box from origin to (max, max)) ::
    range.flatMap(i =>
      for ((p1, p2) <- List((Point(i, 0), Point(0, max + 1 - i)),
        (Point(max, i), Point(i - 1, 0))))
        yield new Line from p1 to p2)

  val parabolic4 = (new Box from origin to (max, max)) ::
    range.flatMap(i =>
      for (op <- List(none, shift(max));
           (p1, p2) <- List((Point(i, 0), Point(0, max + 1 - i)),
             (Point(max, i), Point(i - 1, 0))))
        yield new Line from op(p1) to op(p2))

  val parabolic5 = List(new Line from (-max, 0) to (max, 0),
    new Line from (0, -max) to (0, max)) ++
    range.flatMap(i => for (amount <- List(1, -1); j <- List(i, -i))
      yield new Line from Point(j, 0) * amount to Point(0, max + 1 - i) * amount)


  val images: List[DSLTest] = List(
    new DSLTest(props, List(new Axes from -20 to 50 every(10, 5)),
      Point(35, -20), "axes1"),
    new DSLTest(props, axes2, Point(16, -8), "axes2"),
    new DSLTest(props, axes3, Point(16, -8), "axes3"),
    new DSLTest(props, axes4, Point(16, -8), "axes4"),
    new DSLTest(props, axes5, Point(16, -8), "axes5"),
    new DSLTest(props, axes6, Point(16, -8), "axes6"),
    new DSLTest(props, axes7, Point(0, -1), "axes7"),
    new DSLTest(props, triangles, Point(0, -1.1), "triangles"),
    new DSLTest(props, pentagons, Point(0, -1.1), "pentagons"),
    new DSLTest(props, polygons, Point(0, -1), "polygons"),
    new DSLTest(props, parabolic1, Point(23, -1), "parabolic1"),
    new DSLTest(props, parabolic2, Point(23, -1), "parabolic2"),
    new DSLTest(props, parabolic3, Point(23, -1), "parabolic3"),
    new DSLTest(props, parabolic4, Point(23, -1), "parabolic4"),
    new DSLTest(props, parabolic5, Point(20, -30), "parabolic5"),
  )

  images foreach { i => i toAsyFile }
}
