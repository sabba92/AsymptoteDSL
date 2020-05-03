package complex

import atoms.{Label, Point}
import traits.AsymptoteObject

import scala.collection.mutable.ListBuffer

class AsymptoteImage {
  var settings: ListBuffer[AsymptoteObject] = ListBuffer.empty[AsymptoteObject]
  var objects: ListBuffer[AsymptoteObject] = ListBuffer.empty[AsymptoteObject]
  var logo: AsymptoteObject = null

  def withProp(l: List[AsymptoteObject]): AsymptoteImage = {
    this.settings ++= l
    this
  }

  def having(l: List[AsymptoteObject]): AsymptoteImage = {
    this.objects ++= l
    this
  }

  def logoOn(p: (Double, Double)): AsymptoteImage = this.logoOn(Point(p))
  def logoOn(p: Point): AsymptoteImage = {
    this.logo = new Label saying "Created with AsymptoteDSL" on p
    this
  }

  def toAsyString: String = {
    var ret: String = ""
    this.settings foreach(e => ret = ret concat e.toAsyString)
    this.objects foreach(e => ret = ret concat e.toAsyString)
    ret concat this.logo.toAsyString
  }
}