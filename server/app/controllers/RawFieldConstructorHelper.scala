package controllers

object RawFieldConstructorHelper {
    import views.html.helper.FieldConstructor
    implicit val myFields: FieldConstructor = FieldConstructor(views.html.RawFieldConstructor.f)
}