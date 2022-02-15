package controllers;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import play.data.validation.Constraints;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.databind.PropertyNamingStrategy.*;

@Constraints.Validate
@JsonNaming(SnakeCaseStrategy.class) // -> has no effect on play's form mapping
public class TaskForm implements Constraints.Validatable<List<ValidationError>> {

    @Constraints.Required
    protected String title;

    @Constraints.Required
    @JsonProperty("author_name") // -> has no effect either
    protected String authorName;

    @Override
    public List<ValidationError> validate() {
        return new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonGetter("author_name") // -> also no effect
    public String getAuthorName() {
        return authorName;
    }

    @JsonSetter("author_name") // -> also no effect
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}