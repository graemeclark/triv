package triv.client.place;


import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;

/**
 * Controls the display of the presenters.
 * 
 * Adapted from GWTP guide at:
 * http://code.google.com/p/gwt-platform/wiki/GettingStarted#Default_page
 * 
 * @author Graeme Clark
 *
 */
public class TRIVPlaceManager extends PlaceManagerImpl
{
  private final PlaceRequest defaultPlaceRequest;

  @Inject
  public TRIVPlaceManager(
      final EventBus eventBus,
      final TokenFormatter tokenFormatter,
      @DefaultPlace String defaultNameToken) {
    super(eventBus, tokenFormatter);

    this.defaultPlaceRequest = new PlaceRequest(defaultNameToken);
  }

  @Override
  public void revealDefaultPlace()
  {
    revealPlace(defaultPlaceRequest);
  }

  /**
   * Reveal a presenter on request.
   * 
   * @param req the request to be handled.
   */
  public void reveal(PlaceRequest req)
  {
    revealPlace(req);
  }
}
