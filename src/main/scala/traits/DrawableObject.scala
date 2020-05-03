package traits

trait DrawableObject extends AsymptoteObject {
  this.action = "draw"

  def fill(b: Boolean): DrawableObject = {
    this.action = if (b) "fill" else "draw"
    this
  }
}
