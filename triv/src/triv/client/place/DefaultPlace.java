package triv.client.place;

import com.google.inject.BindingAnnotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * This annotation is used in {@link GwtptabsamplePlaceManager} and is bound in
 * {@link ClientModule} to a constant indicating the name token of the default place.
 *
 * @author Christian Goudreau
 */
@BindingAnnotation
@Target({FIELD, PARAMETER, METHOD})
@Retention(RUNTIME)
public @interface DefaultPlace {}