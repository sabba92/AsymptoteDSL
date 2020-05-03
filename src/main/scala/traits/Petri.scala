package traits

import atoms._

import scala.collection.mutable.ListBuffer
import scala.language.postfixOps

abstract class Petri(i: Map[String, List[String]],
                     o: Map[String, List[String]],
                     m: List[(String, Int)],
                     wi: List[(String, String, Int)],
                     wo: List[(String, String, Int)],
                     sp: Double,
                     d: Int) extends AsymptoteObject {

  val space: Double = sp
  val dim: Int = d
  val block: Double = this.space + this.dim
  val half: Double = this.dim / 2.0

  var places: Map[String, Place] = Map.empty[String, Place]
  var transitions: Map[String, Transition] = Map.empty[String, Transition]
  val otherObj: ListBuffer[AsymptoteObject] = ListBuffer.empty[AsymptoteObject]

  def addLabel(text: String, x: Double, y: Double): Unit = this.addLabel(text, Point(x, y))
  def addLabel(text: String, p: Point): Unit = {
    this.otherObj += new Label saying text on p aligned "S"
  }

  def addArrows(in: Map[String, List[String]], out: Map[String, List[String]]): Unit = {
    def findWeight(place: String, trans: String, direction: String): Int  =
      ((direction match {
        case "in" => wi
        case _ => wo
      }).find(f => (f._1 equals place) && (f._2 equals trans)) getOrElse ("", "", 1))._3

    def updatePoints(obj1: PositionableObject, obj2: PositionableObject,
                     rotated: Boolean, coeff: Double): Point = {
      val coord: String = if (rotated) "y" else "x"
      var offset: Point = if (rotated) Point(0, 1) else Point(1, 0)
      offset *= (if (obj1 < (obj2, coord)) -half else half) //offset della piazza
      offset * coeff
    }

    def addArrow(p1: Point, p2: Point, w: Int): Unit = {
      this.otherObj += new Arrow style "HookHead" from p1 to p2
      this.addLabel(w toString, p1 mid p2)
    }

    List((in, "in"), (out, "out")) foreach { l =>
      l._1 foreach { t =>
        val tPoint: Point = this.transitions(t._1).getPosition
        val rotated: Boolean = transitions(t._1).rotated
        t._2 foreach { p =>
          val pPoint: Point = this.places(p).getPosition
          val offset: Point = updatePoints(transitions(t._1), places(p), rotated, 1)
          val w: Int = findWeight(p, t._1, l._2)
          if (l._2 == "in")
            addArrow(pPoint + offset, tPoint - offset * 0.25, w)
          else
            addArrow(tPoint - offset * 0.25, pPoint + offset, w)
        }
      }
    }
  }

  def addMarkings(markings: List[(String, Int)]): Unit = {
    def addMarking(p: Point, id: Int): Unit = {
      val c = new Circle radius this.half / 8.0
      val offset: Double = this.dim / 6.0
      this.otherObj += c centered (id match {
        case 1 => p
        case 2 => p + (offset, offset)
        case 3 => p - (offset, offset)
        case 4 => p + (-offset, offset)
        case _ => p + (offset, -offset)
      } ) fill true
    }

    for ( marking <- markings;
          n <- 1 to marking._2 ) {
      addMarking(this.places(marking._1).getPosition, n)
    }
  }

  override def toAsyString: String = {
    var ret: String = ""
    places foreach (p => ret = ret concat p._2.asy.toAsyString)
    transitions foreach (t => ret = ret concat t._2.asy.toAsyString)
    otherObj foreach (l => ret = ret concat l.toAsyString)
    ret
  }
}