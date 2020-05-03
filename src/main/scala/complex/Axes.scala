package complex

import java.text.{DecimalFormat, DecimalFormatSymbols}
import java.util.Locale

import atoms._
import traits.AsymptoteObject

import scala.collection.mutable.ListBuffer

class Axes extends AsymptoteObject {
  var start: Double = 0
  var stop: Double = 0

  val ticks: ListBuffer[AsymptoteObject] = ListBuffer.empty[AsymptoteObject]

  def offset: Double = (start - stop) / 50
  def x: Line = new Arrow style "TeXHead" from (0, this.start) to (0, this.stop)
  def y: Line = new Arrow style "TeXHead" from (this.start, 0) to (this.stop, 0)
  def lblX: Label = new Label saying "$x$" on (this.stop, 0) aligned "SW"
  def lblY: Label = new Label saying "$y$" on (0, this.stop) aligned "SW"

  val otherSymbols = new DecimalFormatSymbols(Locale.getDefault)
  otherSymbols.setDecimalSeparator('.')
  val format: DecimalFormat = new DecimalFormat("0.####", otherSymbols)

  def from(s: Double): Axes = {
    this.start = s
    this
  }

  def to(s: Double): Axes = {
    this.stop = s
    this
  }

  def every(primary: Double, secondary: Double): Axes = {
    this.every(primary)
    this.setTicks(secondary, false)
  }

  def every(primary: Double): Axes = this.setTicks(primary, true)

  def setTicks(s: Double, primary: Boolean): Axes = {
    def toTex(d: Double): String = "$" concat this.format.format(d) concat "$"

    def addTicks(t: Double, primary: Boolean, b: Boolean): Unit = {
      def addLabels(t: Double): Unit = {
        this.ticks += new Label saying toTex(t) on (0, t) aligned "W" //Y labels
        this.ticks += new Label saying toTex(t) on (t, 0) aligned "S"
      }

      def div: Integer = if (primary) 2 else 4

      this.ticks += new Line from (-offset / div, t) to (offset / div, t)
      this.ticks += new Line from (t, -offset / div) to (t, offset / div)
      if (b && primary) addLabels(t)
    }

    // per evitare sovrapposizioni con le etichette degli assi, le labels relative
    // ai ticks vengono omesse nella parte terminale degli assi
    // i ticks vengono comunque disegnati
    var i = s
    while (i < this.stop) {
      addTicks(i, primary, i < this.stop * .9)
      i += s
    }
    i = -s
    while (i > this.start) {
      addTicks(i, primary, true)
      i -= s
    }

    // etichetta relativa all'origine
    if (primary && this.start < 0 && this.stop > 0)
      this.ticks += new Label saying toTex(0) on (0, 0) aligned "SW"
    this
  }

  override def toAsyString: String = {
    var ret: String = x.toAsyString concat y.toAsyString concat lblX.toAsyString concat lblY.toAsyString
    this.ticks foreach (o => ret = ret concat o.toAsyString)
    ret
  }
}