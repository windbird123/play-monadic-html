package controllers

import play.api.data.Forms._
import play.api.data._
import play.api.mvc._

import javax.inject._

case class Search(query: Option[String])

@Singleton
class Application @Inject() (cc: MessagesControllerComponents)(implicit assetsFinder: AssetsFinder)
    extends MessagesAbstractController(cc) {
  val searchForm: Form[Search] = Form(mapping("query" -> optional(text))(Search.apply)(Search.unapply))

  def index(tab: String, query: Option[String]): Action[AnyContent] = Action { implicit request =>
    searchForm
      .bindFromRequest()
      .fold(
        error => BadRequest(error.errorsAsJson.toString()),
        (search: Search) => Ok(views.html.index(tab, searchForm.fill(search)))
      )
  }
}
