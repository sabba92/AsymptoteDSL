package traits

trait TransformableObject extends DrawableObject {

  def rotate(deg: Double): TransformableObject = {
    this.param = "rotate" concat "(" concat deg.toString concat ") * " concat this.param
    this
  }

  def shift(s: (Double, Double)): TransformableObject = {
    this.param = "shift" concat "(" concat s._1.toString concat ", " concat s._2.toString concat ") * " concat this.param
    this
  }

  def scale(s: Double): TransformableObject = {
    this.param = "scale" concat "(" concat s.toString concat ") * " concat this.param
    this
  }

  def yscale(s: Double): TransformableObject = {
    this.param = "yscale" concat "(" concat s.toString concat ") * " concat this.param
    this
  }

  def xscale(s: Double): TransformableObject = {
    this.param = "xscale" concat "(" concat s.toString concat ") * " concat this.param
    this
  }
}
