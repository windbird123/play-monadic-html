package org.github.windbird123.play.monadic.basicTab

import mhtml._
import org.github.windbird123.play.monadic.shared.basicTab.SharedMessage
import org.scalajs.dom
import org.scalajs.dom.document
import org.scalajs.dom.raw.HTMLElement

import scala.scalajs.js
import scala.scalajs.js.annotation.{ JSExport, JSExportTopLevel }

@JSExportTopLevel("BasicHtml")
object BasicHtml {

  def changeColor(id: String): Unit =
    document.getElementById(id).setAttribute("style", "color:red")

  def appendParNode(targetNode: HTMLElement, text: String): Unit = {
    val parNode = dom.document.createElement("p")
    parNode.textContent = text
    targetNode.parentElement.appendChild(parNode)
  }
  @JSExport
  def init(id: String, query: String): Unit = {
    val basicContent = document.getElementById(id)

    val eventHandle =
      <div>
        <h1>Event Handling</h1>
        <p>shared message: {SharedMessage.message}</p>
        <span id="basicTab_colorMessage">Color Message </span>
        <button onclick={() => changeColor("basicTab_colorMessage")}>chanage color</button>
      </div>

    val addComponent =
      <div>
        <h1>Add Child Html Component</h1>
        <button type="button" onclick={
        (e: js.Dynamic) => appendParNode(e.currentTarget.asInstanceOf[HTMLElement], "Button Clicked")
      }>
          Add message to bottom
        </button>
      </div>

    val colorMessage =
      <div>
        {eventHandle}
        <hr/>
        {addComponent}
      </div>

    mount(basicContent, colorMessage)
  }
}
