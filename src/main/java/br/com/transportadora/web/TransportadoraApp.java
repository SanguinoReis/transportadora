
package br.com.transportadora.web;

import br.com.transportadora.web.expedicao.PainelPesquisaDocumento;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Title;
import com.vaadin.cdi.CDIUI;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ui.Transport;
import com.vaadin.ui.UI;

@Title("Reis Transporte")
@Push(transport = Transport.WEBSOCKET_XHR)
@CDIUI("")
public class TransportadoraApp extends UI {
    private static final long serialVersionUID = -4938725869387027877L;

    public TransportadoraApp() {
        var navigator = new Navigator(this, this);
        navigator.addView("", new PainelPesquisaDocumento());
        setNavigator(navigator);
    }

    @Override
    public void init(VaadinRequest request) {
    }

}
