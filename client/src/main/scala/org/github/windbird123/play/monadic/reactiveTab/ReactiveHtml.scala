package org.github.windbird123.play.monadic.reactiveTab

import mhtml._
import org.scalajs.dom.document

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("ReactiveHtml")
object ReactiveHtml {

  @JSExport
  def init(id: String, query: String): Unit = {
    val reactiveContent = document.getElementById(id)

    val querySection =
      <div>
        <h1>Query in search from playframework</h1>
        <p>상단 메뉴의 search 에 입력하고 submit 버튼을 눌렸을 때 읽어 오는 값</p>
        <div>Query: [{query}]</div>
      </div>

    val embeddedBinding = {
      val count: Var[Int] = Var(0)
      <div>
        <h1>Embeded Binding</h1>
        <div class="ui input">
        </div>
        <p>{count} x3 = {count.map(_ * 3)}</p>
        <button onclick={() => count.update(_ + 1)}>increase</button>
        <button onclick={() => count.update(_ - 1)}>decrease</button>
      </div>
    }

    val userInput = {
      val input: Var[String] = Var("")
      <div>
        <h1>Read user input and convert to upper</h1>
        <input id="myInput" type="text" onkeyup={(e: js.Dynamic) => input := e.target.value.asInstanceOf[String]}/>
        {input.map(_.toUpperCase)}
      </div>
    }

    val callJs = {
      val json: String =
        """
          |[
          |  {
          |    x: ['giraffes', 'orangutans', 'monkeys'],
          |    y: [20, 14, 23],
          |    type: 'bar'
          |  }
          |]""".stripMargin

      <div>
        <h1>Call Javascripts directly</h1>
        <p>1. scala string 을 javascripts 함수의 파라미터로 바로 전달 가능</p>
        <p>2. scala string 이 아닌 js object/function 을 넘겨야 할 때는 scalajs facade 이용(?) 또는 JQueryHtml 에서 보듯이 직접 전달도 가능</p>
        <p>3. form 에서 user input 을 읽는 것은 scalajs 를 이용해 scala variable 로 읽는 것이 가능</p>
        <p>4. 모든 것을 scala 로 처리 가능 !!!</p>
        <p>playframework 의 routes 를 사용하지 않고 SPA 로 만든다면, Main.main(args) 에서 mount(document.body, content) 로 시작하자</p>
        <div id="plotly_chart"></div>
        <script>
          Plotly.newPlot('plotly_chart', {json});
        </script>
      </div>
    }

    val content =
      <div>
        {querySection}
        <hr/>
        {embeddedBinding}
        <hr/>
        {userInput}
        <hr/>
        {callJs}
      </div>

    mount(reactiveContent, content)
  }
}
