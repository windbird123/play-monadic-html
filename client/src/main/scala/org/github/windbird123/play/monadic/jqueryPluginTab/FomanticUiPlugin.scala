package org.github.windbird123.play.monadic.jqueryPluginTab

import org.querki.jquery.JQuery

import scala.scalajs.js

@js.native
trait FomanticUiPlugin extends JQuery {
  def modal(cmd: String): JQuery = js.native
}

object FomanticUiPlugin {
  implicit def jq2formanticUi(jq: JQuery): FomanticUiPlugin = jq.asInstanceOf[FomanticUiPlugin]
}
