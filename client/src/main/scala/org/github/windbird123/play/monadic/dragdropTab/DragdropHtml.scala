package org.github.windbird123.play.monadic.dragdropTab


import mhtml._
import org.github.windbird123.play.monadic.dragdropTab.facade.Sortable
import org.scalajs.dom.document
import org.scalajs.dom.ext.Ajax
import org.scalajs.dom.raw.HTMLInputElement
import play.api.libs.json.Json

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
import scala.util.{Success, Try}

@JSExportTopLevel("DragdropHtml")
object DragdropHtml {
    @JSExport
    def init(id: String, query: String): Unit = {
        val dropdropContent = document.getElementById(id)

        val content =
            <div>
                <h2>Example 1</h2>
                <ul id="items">
                    <li>item 1</li>
                    <li>item 2</li>
                    <li>item 3</li>
                </ul>
            </div>

        mount(dropdropContent, content)
        Sortable(document.getElementById("items"))
    }
}
