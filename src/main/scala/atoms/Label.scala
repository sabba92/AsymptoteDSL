package atoms

import traits.AsymptoteObject

class Label extends AsymptoteObject {
  this.action = "label"
  var point: Point = null
  var text: String = ""
  var align: String = "NoAlign"
  var minip: Boolean = false
  var minis: Double = 0.0

  def on(p: (Double, Double)): Label = this.on(Point(p))
  def on(p: Point): Label = {
    this.point = p
    this
  }

  def saying(t: String): Label = {
    this.text = t
    this
  }

  def minipage(t: (String, Int)): Label = {
    this.saying(t._1)
    this.minis = t._2 * 0.21
    this.minip = true
    this
  }

  def aligned(p: String): Label = {
    this.align = p
    this
  }

  def getMinipage: String = {
    val op: String = if (this.minip) "minipage(" else ""
    val cl: String = if (this.minip) ", " concat this.minis.toString concat "cm)" else ""
    op concat "\"" concat this.text concat "\"" concat cl
  }

  override def toAsyString: String = {
    this.updateParam(getMinipage concat ", " concat this.point.toAsyString
                     concat ", align = " concat this.align)
    super.toAsyString
  }
}