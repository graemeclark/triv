package triv.client.presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.ProxyEvent;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

import triv.client.editor.EditView;
import triv.client.event.ExecuteEvent;
import triv.client.model.runtime.machine.TRIVMachine;
import triv.client.model.runtime.types.CodeVectorType;
import triv.client.model.runtime.types.Machine;
import triv.client.uihandler.ExecutionUiHandlers;

/**
 * @author graeme
 *
 */
public class ExecutionPresenter extends
Presenter<ExecutionPresenter.ExecutionView, ExecutionPresenter.ExecutionProxy>
implements ExecutionUiHandlers
{

  public interface ExecutionView extends EditView<Machine>, HasUiHandlers<ExecutionUiHandlers> {}

  @ProxyCodeSplit
  @NameToken("exe")
  public interface ExecutionProxy extends ProxyPlace<ExecutionPresenter> {}

  PlaceManager placeManager;
  SimpleBeanEditorDriver<Machine, ?> editorDriver;
  Machine machine;
  List<CodeVectorType> codeVector;

  @Inject
  public ExecutionPresenter(EventBus eventBus, ExecutionView view, ExecutionProxy proxy, PlaceManager places)
  {
    super(eventBus, view, proxy);
    this.placeManager = places;
    getView().setUiHandlers(this);
    prepareFromRequest(null);
    editorDriver = this.getView().createEditorDriver();
  }

  @Override
  protected void revealInParent()
  {
    RevealRootContentEvent.fire( this, this );
  }
  
  @Override
  public void prepareFromRequest(PlaceRequest placeRequest)
  {
    if (codeVector == null) {
      placeManager.revealPlace(new PlaceRequest("in"));
    }
  }

  @ProxyEvent
  @Override
  public void onExecuteEvent(ExecuteEvent event) {
    PlaceRequest request = new PlaceRequest("exe");
    placeManager.revealPlace(request);

    codeVector = event.getCodeVector();
    machine = new TRIVMachine();
    machine.setCodeVector(codeVector);
  }

  public List<String> init()
  {
    editorDriver.edit(machine);
    List<String> c = new ArrayList<String>();
    for (CodeVectorType cv : codeVector) {
      c.add(cv.toString());
    }
    return c;
  }

  @Override
  public void step()
  {
    machine.execute();
    editorDriver.edit(machine);
  }

  @Override
  public void reset()
  {
    machine.reset();
    editorDriver.edit(machine);
  }

}