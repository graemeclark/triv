package triv.client.place;


import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;

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
  
  public void reveal(PlaceRequest req)
  {
  	revealPlace(req);
  }
}
