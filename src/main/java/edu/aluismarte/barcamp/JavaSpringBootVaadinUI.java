package edu.aluismarte.barcamp;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import edu.aluismarte.barcamp.model.LoginSession;
import edu.aluismarte.barcamp.ui.App;
import edu.aluismarte.barcamp.ui.Login;

/**
 * Created by aluis on 9/30/19.
 */
@Push
@Theme(Lumo.class)
@Route("")
@BodySize(height = "100vh", width = "100vw")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
public class JavaSpringBootVaadinUI extends VerticalLayout implements RouterLayout {

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        setSizeFull();
        setMargin(false);
        setPadding(false);
        LoginSession loginSession = attachEvent.getUI().getSession().getAttribute(LoginSession.class);
        if (loginSession != null) {
            startApp();
        } else {
            Login login = new Login();
            login.setLoginListener(this::startApp);
            login.open();
//            add(login); // Caso con polymer
        }
    }

    private void startApp() {
        getUI().ifPresent(ui -> ui.navigate(App.class));
    }
}