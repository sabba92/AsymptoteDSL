package atoms

class Polygonal extends Line {
  override def updateParam(p: String): Unit = {
    this.param = p concat this.connector concat "cycle"
  }
}