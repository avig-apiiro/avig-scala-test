import sttp.client4.*
import sttp.client4.upicklejson.default.*
import upickle.default.*

object MinimalApplication extends cask.MainRoutes {
    @cask.get("/")
    def hello() = {
      val request = basicRequest
        .post("https://graph.facebook.com/v18.0/$endpoint")
        .body(asJson(MyRequest("test", 42)))
        .response(asJson[HttpBinResponse])

      "Hello World!"
    }

    @cask.post("/do-thing")
    def doThing(request: cask.Request) = {
      new String(request.readAllBytes()).reverse
    }

    initialize()
}
