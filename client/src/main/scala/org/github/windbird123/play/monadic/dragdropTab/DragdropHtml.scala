package org.github.windbird123.play.monadic.dragdropTab

import mhtml._
import org.github.windbird123.play.monadic.dragdropTab.facade.Sortable
import org.scalajs.dom.document
import org.scalajs.dom.ext.Ajax
import org.scalajs.dom.raw.HTMLInputElement
import play.api.libs.json.Json

import scala.scalajs.js.annotation.{ JSExport, JSExportTopLevel }
import scala.util.{ Success, Try }

@JSExportTopLevel("DragdropHtml")
object DragdropHtml {
  @JSExport
  def init(id: String, query: String): Unit = {
    val dropdropContent = document.getElementById(id)
    lazy val sortable   = Sortable(document.getElementById("items"))

    val list =
        <div id="items" class="ui middle aligned selection list">
            <div data-id="ID_1" class="item">
                <div class="content">
                    <div class="header">ID_1</div>
                </div>
            </div>
            <div data-id="ID_2" class="item">
                <div class="content">
                    <div class="header">ID_2</div>
                </div>
            </div>
            <div data-id="ID_3" class="item">
                <div class="content">
                    <div class="header">ID_3</div>
                </div>
            </div>
        </div>

    val button = {
      <button type="button" onclick={() => document.getElementById("ordered").textContent = sortable.toArray().toString}>READ ORDER</button>
    }

    val content =
        <div>
            {list}
            {button}
            <div id="ordered"></div>
        </div>

    mount(dropdropContent, content)
    Sortable(document.getElementById("items"))
  }
}
