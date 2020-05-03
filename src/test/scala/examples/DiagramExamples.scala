package examples

import atoms._
import complex._
import org.scalatest.funsuite.AnyFunSuite
import traits.AsymptoteObject
import utils._

import scala.language.postfixOps

class DiagramExamples extends AnyFunSuite {
  val props: List[AsymptoteObject] = List(
    new Prop("size(60cm, 30cm);")
  )

  val AppClass = new UMLTrait("App", (0, -7))
  val AsyDSLClass = new UMLClass("AsymptoteDSL", (28, -6.25)) withAttr
    List(("asyObj", "AsymptoteImage"))
  val AsyImgClass = new UMLClass("AsymptoteImage", (60, 0)) withAttr
    List(("settings", "ListBuffer[AsymptoteObject]"),
      ("objects", "ListBuffer[AsymptoteObject]"),
      ("logo", "AsymptoteObject")) withMeth
    List(("withProp", List("List[AsymptoteObject]"), "AsymptoteImage"),
      ("having", List("List[AsymptoteObject]"), "AsymptoteImage"),
      ("logoOn", List("(Double, Double)"), "AsymptoteImage"),
      ("logoOn", List("Point"), "AsymptoteImage"),
      ("toAsyString", List.empty[String], "String"))
  val AsyObjClass = new UMLTrait("AsymptoteObject", (65, -27)) withAttr
    List(("action", "String"), ("color", "String"),
      ("lineStyle", "String"), ("param", "String")) withMeth
    List(("color", List("String"), "AsymptoteObject"),
      ("lineStyle", List("String"), "AsymptoteObject"),
      ("updateParam", List("String"), "Unit"),
      ("toAsyString", List.empty[String], "String"))
  val PosObjClass = new UMLTrait("PositionableObject", (0.5, -20)) withAttr
    List(("name", "String"), ("x", "Double"), ("y", "Double"), ("asy", "AsymptoteObject")) withMeth
    List(("getPosition", List.empty[String], "Point"),
      ("$<$", List("PositionableObject", "String"), "Boolean"))
  val PropClass = new UMLClass("Prop", (36, -33)) withMeth
    List(("toAsyString", List.empty[String], "String"))
  val LabelClass = new UMLClass("Label", (34, -44.5)) withAttr
    List(("point", "Point"), ("test", "String"), ("align", "String"),
      ("minip", "Boolean"), ("minis", "Double")) withMeth
    List(("on", List("(Double, Double)"), "Label"), ("on", List("Point"), "Label"),
      ("saying", List("String"), "Label"), ("aligned", List("String"), "Label"),
      ("minipage", List("(String, Int)"), "Label"), ("getMinipage", List.empty[String], "String"),
      ("toAsyString", List.empty[String], "String"))
  val PlaceClass = new UMLClass("Place", (0, -46))
  val TransClass = new UMLClass("Transition", (18, -45)) withAttr
    List(("rotated", "Boolean"))
  val DrawableObjClass = new UMLTrait("DrawableObject", (104, -35.75)) withMeth
    List(("fill", List("Boolean"), "DrawableObject"))
  val CenterableObjClass = new UMLAbstract("CenterableObject", (104, -20)) withAttr
    List(("center", "Point")) withMeth
    List(("centered", List("(Double, Double)"), "CenterableObject"),
      ("centered_", List("Point"), "CenterableObject"))
  val TransfObjClass = new UMLTrait("TransformableObject", (140, -38.5)) withMeth
    List(("rotate", List("Double"), "TransformableObject"),
      ("shift", List("(Double, Double)"), "TransformableObject"),
      ("scale", List("Double"), "TransformableObject"),
      ("xscale", List("Double"), "TransformableObject"),
      ("yscale", List("Double"), "TransformableObject"))
  val USquareClass = new UMLClass("UnitSquare", (131, -66))
  val UCircleClass = new UMLClass("UnitCircle", (150.3, -66))
  val PolygonClass = new UMLClass("Polygon", (169, -65)) withMeth
    List(("sides", List("Integer"), "Polygon"))
  val BoxClass = new UMLClass("Box", (186, -36)) withAttr
    List(("p1", "Point"), ("p2", "Point")) withMeth
    List(("from", List("Point"), "Box"),
      ("from", List("(Double, Double)"), "Box"),
      ("to", List("Point"), "Box"),
      ("to", List("(Double, Double)"), "Box"),
      ("updateParams", List.empty[String], "Unit"),
      ("color", List("String"), "Box"))
  val CircleClass = new UMLClass("Circle", (118, 0)) withAttr
    List(("r", "Double")) withMeth
    List(("centered", List("(Double, Double)"), "Circle"),
      ("centered", List("Point"), "Circle"),
      ("radius", List("Double"), "Circle"),
      ("updateParams", List.empty[String], "Unit"))
  val EllipseClass = new UMLClass("Ellipse", (169, -13.75)) withAttr
    List(("a", "(Double, Double)")) withMeth
    List(("centered", List("(Double, Double)"), "Ellipse"),
      ("centered", List("Point"), "Ellipse"),
      ("axes", List("(Double, Double)"), "Ellipse"),
      ("updateParams", List.empty[String], "Unit"))
  val PointTrait = new UMLTrait("Point", (86.75, -55)) withAttr
    List(("x", "Double"), ("y", "Double")) withMeth
    List(("+", List("(Double, Double)"), "Point"),
      ("+", List("Point"), "Point"),
      ("-", List("(Double, Double)"), "Point"),
      ("-", List("Point"), "Point"),
      ("*", List("Double"), "Point"),
      ("mid", List("Point"), "Point"))
  val PointClass = new UMLClass("Point", (86.75, -90.4)) withMeth
    List(("toAsyString", List.empty[String], "String"))
  val DotClass = new UMLClass("Dot", (60, -86.3)) withAttr
    List(("p", "Point")) withMeth
    List(("in", List("Point"), "Dot"), ("in", List("(Double, Double)"), "Dot"))
  val LineClass = new UMLClass("Line", (109.5, -76)) withAttr
    List(("points", "ListBuffer[Point]"), ("connector", "String")) withMeth
    List(("listToParams", List("ListBuffer[Point]"), "String"),
      ("from", List("Point"), "Line"),
      ("from", List("(Double, Double)"), "Line"),
      ("to", List("Point"), "Line"),
      ("to", List("(Double, Double)"), "Line"),
      ("addPoint", List("Point"), "Line"),
      ("curved", List.empty[String], "Line"))
  val PolygonalClass = new UMLClass("Polygonal", (152, -76)) withMeth
    List(("updateParam", List("String"), "Unit"))
  val ArrowClass = new UMLClass("Arrow", (177, -76)) withAttr
    List(("head", "String"), ("size", "String")) withMeth
    List(("style", List("Boolean"), "Arrow"),
      ("style", List("String"), "Arrow"),
      ("style", List("(Boolean, String)"), "Arrow"),
      ("style", List("(String, Boolean)"), "Arrow"),
      ("toAsyString", List.empty[String], "String"))
  val PetriClass = new UMLTrait("Petri", (9, -59))
  val PetriAutoClass = new UMLClass("PetriAuto", (0, -70))
  val PetriGridClass = new UMLClass("PetriGrid", (18, -70))
  val AxesClass = new UMLClass("Axes", (108, -46))
  val UMLTClass = new UMLClass("UMLTrait", (0, -78))
  val UMLAbsClass = new UMLClass("UMLAbstract", (28, -90))
  val UMLClassClass = new UMLClass("UMLClass", (28, -78))
  val UMLCDClass = new UMLClass("UMLClassDiagram", (56, -78))

  val diag = new ClassDiag(List(AppClass, AsyDSLClass, AsyImgClass, AsyObjClass, PosObjClass, LabelClass,
    PropClass, PlaceClass, TransClass, DrawableObjClass, CenterableObjClass, TransfObjClass, USquareClass,
    UCircleClass, PolygonClass, BoxClass, CircleClass, EllipseClass, PointClass, PointTrait, DotClass,
    LineClass, PolygonalClass, ArrowClass, PetriClass, PetriAutoClass, PetriGridClass, AxesClass,
    UMLAbsClass, UMLTClass, UMLClassClass, UMLCDClass),
    List((AsyDSLClass, "CW", AppClass, "CE", "--|>"),
      (AsyDSLClass, "CE", AsyImgClass, "CW", "->"),
      (AsyObjClass, "N", AsyImgClass, "S", "-<>"),
      (PosObjClass, "CE", AsyObjClass, "W", "->"),
      (PropClass, "CE", AsyObjClass, "CW", "--|>"),
      (LabelClass, "E", AsyObjClass, "BW", "--|>"),
      (PlaceClass, "LN", PosObjClass, "LS", "--|>"),
      (TransClass, "RN", PosObjClass, "RS", "--|>"),
      (DrawableObjClass, "W", AsyObjClass, "CE", "-|>"),
      (CenterableObjClass, "LS", DrawableObjClass, "LN", "-|>"),
      (TransfObjClass, "W", DrawableObjClass, "CE", "-|>"),
      (BoxClass, "CW", TransfObjClass, "CE", "--|>"),
      (CircleClass, "RS", TransfObjClass, "LN", "--|>"),
      (EllipseClass, "LS", TransfObjClass, "RN", "--|>"),
      (CircleClass, "LS", CenterableObjClass, "N", "--|>"),
      (EllipseClass, "CW", CenterableObjClass, "E", "--|>"),
      (USquareClass, "RN", TransfObjClass, "LS", "--|>"),
      (UCircleClass, "N", TransfObjClass, "S", "--|>"),
      (PolygonClass, "LN", TransfObjClass, "RS", "--|>"),
      (PointTrait, "LN", AsyObjClass, "RS", "-|>"),
      (PointClass, "LN", PointTrait, "LS", "--|>"),
      (DotClass, "RN", AsyObjClass, "S", "--|>"),
      (DotClass, "CE", PointClass, "W", "->"),
      (LineClass, "N", DrawableObjClass, "RS", "--|>"),
      (PointClass, "BE", LineClass, "BW", "-<>"),
      (PolygonalClass, "W", LineClass, "E", "-|>"),
      (ArrowClass, "CW", LineClass, "CE", "-|>"),
      (PosObjClass, "S", PetriClass, "N", "-<>"),
      (PetriAutoClass, "RN", PetriClass, "LS", "-|>"),
      (PetriGridClass, "LN", PetriClass, "RS", "-|>"),
      (AsyObjClass, "BE", AxesClass, "W", "-<>"),
      (UMLTClass, "CE", UMLClassClass, "CW", "-|>"),
      (UMLAbsClass, "N", UMLClassClass, "S", "-|>"),
      (UMLCDClass, "CW", UMLClassClass, "CE", "->"),
      (AsyObjClass, "LS", UMLCDClass, "RN", "-<>"),
    ))

  val images: List[DSLTest] = List(
    new DSLTest(props, List(diag),
      Point(200, -100), "diagram")
  )

  images foreach { i => i toAsyFile }
}
