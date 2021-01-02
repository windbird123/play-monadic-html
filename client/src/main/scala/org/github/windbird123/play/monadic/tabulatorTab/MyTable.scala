package org.github.windbird123.play.monadic.tabulatorTab

import mhtml._
import org.scalajs.dom.document
import org.scalajs.dom.ext.Ajax
import org.scalajs.dom.raw.{Event, HTMLDivElement, HTMLElement, HTMLInputElement}
import play.api.libs.json.Json

import scala.collection.mutable
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("MyTable")
object MyTable {

  @JSExport
  def init(id: String, query: String): Unit = {
    val content = <div id="example-table"></div>

    mount(document.getElementById(id), content)

    val f: js.Function2[Event, RowComponent, Unit] = (x: Event, y: RowComponent) => y.delete()

    import js.JSConverters._

    val tableData = mutable.Seq(
      mutable.Map[String, Any]("id" -> 1, "name" -> "Oli Bob", "age" -> "12").toJSDictionary
    ).toJSArray


    val settings : js.Dictionary[Any] = mutable.Map[String, Any](
      "height" -> 205,
      "data"-> tableData,
      "layout"-> "fitColumns",
      "columns" -> mutable.Seq(
        mutable.Map[String, Any]("title"-> "Name", "field" -> "name", "width" -> 150).toJSDictionary,
        mutable.Map[String, Any]("title"-> "Age", "field" -> "age", "hozAlign" -> "left", "formatter" -> "progress").toJSDictionary
      ).toJSArray,
      "rowClick" -> f
    ).toJSDictionary
    new Tabulator("#example-table", settings)
  }
}
