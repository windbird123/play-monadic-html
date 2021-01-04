package org.github.windbird123.play.monadic.jqueryPluginTab

import mhtml._
import org.querki.jquery.$
import org.scalajs.dom.{Event, document}
import org.scalajs.dom.ext.Ajax
import play.api.libs.json.Json

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
import scala.xml.Elem
import FomanticUiPlugin._

@JSExportTopLevel("JQueryHtml")
object JQueryHtml {
  @JSExport
  def init(id: String, query: String): Unit = {
    val jqueryContent = document.getElementById(id)

    val modalContent =
      <div id="modalBox" class="ui modal">
          <i class="close icon"></i>
          <div class="header">
              Profile Picture
          </div>
          <div>
            <h1>Hi~~~</h1>
          </div>  
            <div class="actions">
                <div class="ui black deny button">
                    No
                </div>
                <div class="ui positive button">
                    Yes
                </div>
            </div>
        </div>

    // http://yesmeck.github.io/jquery-jsonview/ Exercise
    val json: String =
      """   {
        |      "hey": "guy",
        |      "anumber": 243,
        |      "anobject": {
        |        "whoa": "nuts",
        |        "anarray": [1, 2, "thr<h1>ee"],
        |        "more":"stuff"
        |      },
        |      "awesome": true,
        |      "bogus": false,
        |      "meaning": null,
        |      "japanese":"明日がある。",
        |      "link": "http://jsonview.com",
        |      "notLink": "http://jsonview.com is great",
        |      "multiline": ["Much like me, you make your way forward,",
        |        "Walking with downturned eyes.",
        |        "Well, I too kept mine lowered.",
        |        "Passer-by, stop here, please."]
        |    }
        |""".stripMargin

    // function() { } 에서 중괄호를 monadic-html 의 괄호 연산자로 인식해서, <script></script> 에 직접 넣을 수가 없다.
    // 그래서 아래와 같이 해서 넣음
    // 아니면 JsonViewPlugin 의 facade 를 이용해야 한다.

    // $(function() { $("#json").JSONView(json); })
    val jsonViewJqueryScript = """$(function() { $("#json_content").JSONView(""" + { json } + """); });"""
    val response: Elem =
      <div>
            {modalContent}
            <button onclick={ (e: Event) => $("#modalBox").modal("show"); println("modal show click")}>modalBox show</button>
            <p id="jquery_msg">This color was changed by jquery script</p>
            <div id="json_content"></div>
            <script>
                $("#jquery_msg").attr('style', 'color:red');
                {jsonViewJqueryScript}
            </script>
        </div>

    // facade 를 이용할 경우 아래와 같이 ..
//      import JsonViewPlugin._
//      $(() => $("#json_content").JSONView(json))
    mount(jqueryContent, response)
  }
}
