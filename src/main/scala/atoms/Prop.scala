package atoms

import traits.AsymptoteObject

class Prop(prop: String) extends AsymptoteObject {

  override def toAsyString: String = prop concat "\n"
}