package org.github.windbird123.play.monadic.jqueryPluginTab

import org.querki.jquery.JQuery

import scala.scalajs.js

@js.native
trait JsonViewPlugin extends JQuery {
    def JSONView(json: String): JQuery = js.native
}

object JsonViewPlugin {
    implicit def jq2jsonView(jq: JQuery): JsonViewPlugin = jq.asInstanceOf[JsonViewPlugin]
}
