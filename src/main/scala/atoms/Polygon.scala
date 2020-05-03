package atoms

import traits._

class Polygon extends TransformableObject {

  def sides(s: Integer): Polygon = {
    this.updateParam("polygon(" concat s.toString concat ")")
    this
  }
}