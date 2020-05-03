package atoms

import traits.AsymptoteObject

import scala.collection.mutable.ListBuffer
import scala.language.postfixOps

class UMLClass(n: String, pos:(Double, Double), t: Boolean = false, a: Boolean = false) {
  val name: String = n
  var maxLen: Int = math.max(this.name length, 20)
  val isTrait: Boolean = t
  val isAbstract: Boolean = a
  var attribs: ListBuffer[String] = ListBuffer.empty[String]
  var methods: ListBuffer[String] = ListBuffer.empty[String]
  val coords: (Double, Double) = pos
  var startPoint: Point = null

  def setStartPoint(p: Point): Unit = this.startPoint = p

  def withAttr(l: List[(String, String)]): UMLClass = {
    l foreach (e => this.attribs += ("\\ " concat e._1 concat ": " concat e._2))
    this
  }

  def withMeth(l: List[(String, List[String], String)]): UMLClass = {
    l foreach { e =>
      var args: String = ""
      e._2 foreach (a => args = args concat a concat ", ")
      if (e._2 nonEmpty)
        args = args.dropRight(2)
      val start: String = "\\ " concat (
        if (e._1.takeRight(1) == "_") "\\textit{" concat e._1.dropRight(1) else e._1) concat " ("
      val end: String = if (e._1.takeRight(1) == "_") "}" else ""
      this.methods += (start concat args concat "): " concat e._3 concat end)
    }
    this
  }

  def classToString: (String, Int) = {
    var ret: String = "{\\centering"
    ret = ret concat ((this.isTrait, this.isAbstract) match {
      case (true, _) => "\\textless\\textless trait\\textgreater\\textgreater\\par " concat this.name
      case (_, b) => "\\bigskip " concat
        (if (b) "\\textit{" concat this.name concat "}" else this.name) concat "\\smallskip "
    }) concat "\\par } \\bigskip \\par "

    for (l <- List(this.attribs, List("\\bigskip "), this.methods); r <- l) {
      ret = ret concat r concat "\\par "
      maxLen = if (r.length > maxLen) r.length else maxLen
    }
    (ret, maxLen)
  }

  def toAsyList: List[AsymptoteObject] = {
    List(this.label, this.box, this.line1, this.line2)
  }

  def height: Double = (this.attribs.length + this.methods.length) * 1.8 + 7
  def medHeight: Double = this.attribs.length * 1.8 + 5.5
  def width: Double = this.maxLen * 0.75

  def N: Point = this.startPoint + (this.width / 2, 0)
  def S: Point = this.startPoint + (this.width / 2, -this.height)
  def LN: Point = this.startPoint + (3, 0)
  def LS: Point = this.startPoint + (3, -this.height)
  def RN: Point = this.startPoint + (this.width - 3, 0)
  def RS: Point = this.startPoint + (this.width - 3, -this.height)
  def E: Point = this.startPoint + (this.width, -2)
  def W: Point = this.startPoint + (0, -2)
  def CE: Point = this.startPoint + (this.width, -this.height / 2)
  def CW: Point = this.startPoint + (0, -this.height / 2)
  def BE: Point = this.startPoint + (this.width, -this.height + 2)
  def BW: Point = this.startPoint + (0, -this.height + 2)

  def label: Label = new Label minipage this.classToString on this.startPoint aligned "SE"
  def box: Box = new Box from this.startPoint to this.startPoint + (this.width, -this.height)
  def line1: Line = new Line from this.startPoint + (0, -4) to this.startPoint + (this.width, -4)
  def line2: Line = new Line from this.startPoint + (0, -this.medHeight) to this.startPoint + (this.width, -this.medHeight)
}

class UMLTrait(n: String, pos: (Double, Double)) extends UMLClass(n, pos, t = true)

class UMLAbstract(n: String, pos: (Double, Double)) extends UMLClass(n, pos, a = true)