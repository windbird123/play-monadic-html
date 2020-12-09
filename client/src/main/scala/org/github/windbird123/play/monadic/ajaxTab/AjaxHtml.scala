package org.github.windbird123.play.monadic.ajaxTab

import mhtml._
import org.scalajs.dom.document
import org.scalajs.dom.ext.Ajax
import org.scalajs.dom.raw.HTMLInputElement
import play.api.libs.json.Json

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
import scala.util.{Success, Try}

@JSExportTopLevel("AjaxHtml")
object AjaxHtml {
  case class UserInfo(id: Int, title: String)
  @JSExport
  def init(id: String, query: String): Unit = {
    val idVar: Var[String] = Var("")

    import mhtml.future.syntax._
    import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
    def resultVar: Rx[Option[UserInfo]] =
      for {
        id <- idVar
        result <- Ajax.get(s"https://jsonplaceholder.typicode.com/todos/$id").toRx.map {
                   case Some(Success(xhr)) if xhr.status == 200 =>
                     Try {
                       val json = Json.parse(xhr.responseText)
                       println(json)
                       UserInfo((json \ "id").as[Int], (json \ "title").as[String])
                     }.toOption
                   case _ => None
                 }
      } yield result

    val ajaxRes =
      <div>
        <div>
          <input type="text"  id="my_id" placeholder="Id"/>
          <button class="ui button" type="submit" onclick={
        () => idVar := document.getElementById("my_id").asInstanceOf[HTMLInputElement].value
      }>Submit</button>
        </div>

        <div>
        {
        idVar.map { id =>
          if (id == "") {
            <div>enter id as number</div>
          } else {
            <div>
            <p>id: {resultVar.map(_.map(_.id))}</p>
                  <p>title: {resultVar.map(_.map(_.title))}</p>
            </div>
          }
        }
      }
        </div>
      </div>

    mount(document.getElementById(id), ajaxRes)
  }
}
