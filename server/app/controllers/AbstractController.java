package controllers;

import play.Logger;
import play.mvc.Before;
import play.mvc.Controller;

public abstract class AbstractController extends Controller {

       @Before

       public static void cors() {
           Logger.info(request.toString());
//           response.contentType = "application/json";
           response.setHeader("Access-Control-Allow-Headers", "content-type");
           response.accessControl("http://127.0.0.1:9000", "GET,PUT,DELETE,POST,OPTIONS", true);
       }

       public static void catchAll() {
           Logger.warn("no method!");
//           notFound();
       }
}