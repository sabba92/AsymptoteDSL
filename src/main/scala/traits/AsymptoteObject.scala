package traits

trait AsymptoteObject {
  var action: String = ""
  var color: String = "black"
  var lineStyle: String = ""
  var param: String = ""

  def color(c : String): AsymptoteObject = {
    this.color = c
    this
  }

  def lineStyle(ls : String): AsymptoteObject = {
    this.lineStyle = ls
    this
  }

  def updateParam(p: String): Unit = {
    this.param = p
  }

  def toAsyString: String = this.action concat "(" concat this.param concat ", " concat
    this.color concat (if (this.lineStyle != "") "+" concat this.lineStyle else "") concat ");\n"

}
