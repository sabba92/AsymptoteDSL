package complex

import atoms._
import traits.AsymptoteObject

import scala.collection.mutable.ListBuffer
import scala.language.postfixOps

class ClassDiag(classes: List[UMLClass], rel: List[(UMLClass, String, UMLClass, String, String)]) extends AsymptoteObject {
  implicit def pointToDouble(p: Point): (Double, Double) = (p.x, p.y)

  var obj: ListBuffer[AsymptoteObject] = ListBuffer.empty[AsymptoteObject]

  //possibile miglioramento: passare come startPoint un punto calcolato
  //sulla base delle classi posizionate sopra e a sinistra della corrente
  //in questo caso il costruttore della classe UML dovrebbe ricevere
  //una coppia di indici come se il diagramma fosse una griglia
  classes foreach { c =>
    c setStartPoint Point(c coords)
    this.obj ++= c.toAsyList
  }

  rel foreach { r =>
    this.obj += new Line from getClassPoint(r._1, r._2) to (r._5 takeRight 2 match {
      case "|>" => getOperation(r._4, (1.5, 0))(getClassPoint(r._3, r._4))
      case "<>" => getOperation(r._4, (2, 0))(getClassPoint(r._3, r._4))
      case _ => getClassPoint(r._3, r._4)
    }) lineStyle getLineType(r._5 take 2)
    this.addLineEnd(r._5 takeRight 2, r._3, r._4)
  }

  def getLineType(format: String): String = format match {
    case "--" => "linetype(\"8 8\")"
    case _ => ""
  }

  def addLineEnd(end: String, cl: UMLClass, pos: String): Unit = end match {
    case "<>" => this.obj += new UnitSquare rotate 45 yscale 1.5 rotate getRotation(pos) shift
      getOperation(pos, (2, 0))(getClassPoint(cl, pos))
    case "|>" => this.obj += new Polygon sides 3 rotate getRotation(pos) shift
      getOperation(pos, (1, 0))(getClassPoint(cl, pos))
    case "->" => val points = this.getHeadPoints(pos, getClassPoint(cl, pos))
      this.obj += new Line from points._1 to points._2 to points._3
  }

  def getHeadPoints(pos: String, p: Point): (Point, Point, Point) =
    (getOperation(pos, (1.5, 0.8))(p), p, getOperation(pos, (1.5, -0.8))(p))

  def getRotation(pos: String): Int = pos match {
    case "N" | "LN" | "RN" => 180
    case "E" | "CE" | "BE" => 90
    case "W" | "CW" | "BW" => -90
    case _ => 0
  }

  def getClassPoint(cl: UMLClass, pos: String): Point = pos match {
    case "N" => cl.N
    case "S" => cl.S
    case "RN" => cl.RN
    case "RS" => cl.RS
    case "LN" => cl.LN
    case "LS" => cl.LS
    case "E" => cl.E
    case "W" => cl.W
    case "BE" => cl.BE
    case "BW" => cl.BW
    case "CE" => cl.CE
    case _ => cl.CW
  }

  def getOperation(pos: String, offset: (Double, Double)): Point => Point = pos match {
    case "E" | "CE" | "BE" => _+(offset._1, offset._2)
    case "W" | "CW" | "BW" => _-(offset._1, offset._2)
    case "N" | "LN" | "RN" => _+(offset._2, offset._1)
    case _ => _-(offset._2, offset._1)
  }

  override def toAsyString: String = {
    var ret: String = ""
    this.obj foreach (o => ret = ret concat o.toAsyString)
    ret
  }
}