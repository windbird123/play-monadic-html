package org.github.windbird123.play.monadic.ajaxTab

import mhtml._
import org.scalajs.dom.document
import org.scalajs.dom.ext.Ajax
import play.api.libs.json.Json

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("AjaxHtml")
object AjaxHtml {

  @JSExport
  def init(id: String, query: String): Unit = {
    val userVar: Var[Option[Int]]     = Var(None)
    val titleVar: Var[Option[String]] = Var(None)

    val ajaxContent = document.getElementById(id)
    val response =
      <div>
        <p>userId={userVar}</p>
        <p>title={titleVar}</p>
      </div>

    val url = "https://jsonplaceholder.typicode.com/todos/1"
    Ajax.get(url).foreach { xhr =>
      val json = Json.parse(xhr.responseText)
      userVar := (json \ "userId").asOpt[Int]
      titleVar := (json \ "title").asOpt[String]
    }

    mount(ajaxContent, response)
  }
}
