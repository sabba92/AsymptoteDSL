package atoms

class Arrow extends Line {
  var head: String = ""
  var size: String = ""

  def style(little: Boolean): Arrow = {
    if (little) this.size = "Arc"
    this
  }

  def style(h: String): Arrow = {
    this.head = h
    this
  }

  def style(little: Boolean, h: String): Arrow = {
    this.style(little)
    this.style(h)
    this
  }

  def style(h: String, little: Boolean): Arrow = this.style(little, h)

  override def toAsyString: String = {
    def p: String = this.points
    this.updateParam(p concat ", arrow = " concat size concat "Arrow(" concat head concat ")")
    super.toAsyString
  }
}