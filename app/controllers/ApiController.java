package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.*;

import javax.inject.Inject;

public class ApiController extends Controller {

    private final FormFactory formFactory;
    private final MessagesApi messagesApi;

    @Inject
    public ApiController(FormFactory formFactory,
                         MessagesApi messagesApi) {

        this.formFactory = formFactory;
        this.messagesApi = messagesApi;
    }

    public Result index(Http.Request request) {
        return TODO(request);
    }

    public Result createTask(Http.Request request) {
        final JsonNode requestJson = request.body().asJson();
        final Form<TaskForm> form = formFactory.form(TaskForm.class)
                .bind(messagesApi.preferred(request).lang(), request.attrs(), requestJson, 102400);

        if (form.hasErrors()) {
            return badRequest(form.errorsAsJson());
        }

        return ok("request came through :)");
    }

}
