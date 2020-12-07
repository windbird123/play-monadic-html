package org.github.windbird123.play.monadic.reactiveTab

import mhtml._
import org.scalajs.dom.document

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("ReactiveHtml")
object ReactiveHtml {

  @JSExport
  def init(id: String, query: String): Unit = {
    val reactiveContent = document.getElementById(id)
    val count: Var[Int] = Var(0)

    val querySection =
      <div>
        <h1>Query in search from playframework</h1>
        <p>상단 메뉴의 search 에 입력하고 submit 버튼을 눌렸을 때 읽어 오는 값</p>
        <div>Query: [{query}]</div>
      </div>

    val embeddedBinding =
      <div>
        <h1>Embeded Binding</h1>
        <div class="ui input">
        </div>
        <p>{count} x3 = {count.map(_ * 3)}</p>
        <button onclick={() => count.update(_ + 1)}>increase</button>
        <button onclick={() => count.update(_ - 1)}>decrease</button>
      </div>

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
        {callJs}
      </div>

    mount(reactiveContent, content)
  }
}
