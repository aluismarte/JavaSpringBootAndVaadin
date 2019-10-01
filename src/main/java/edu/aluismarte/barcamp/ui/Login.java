package edu.aluismarte.barcamp.ui;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.templatemodel.TemplateModel;
import edu.aluismarte.barcamp.repository.UserRepository;
import edu.aluismarte.barcamp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Esto se hace con un componente polymer y se escribe en la demostración.
 * <p>
 * Created by aluis on 9/30/19.
 */
//@Tag("login-template")
//@HtmlImport("login/login-template.html")
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class Login extends Dialog { // extends PolymerTemplate<Login.LoginModel>

    // Adicionar la versión flotante en el login para mostrar como se pasan los parámetros

    @Autowired
    private UserRepository userRepository; // No hagan esto, es una demostración, deben crear los servicios y hacer una instancia.

    private LoginListener loginListener;

    public Login() {
        setWidth("400px");
        setHeight("400px");
        Constants.get().autoWiredClass(this);
        add(new Label("Hola Vaadin con el login"));
    }

    public void setLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    private void fireLogin() {
        if (loginListener != null) {
            loginListener.login();
        }
    }

    public interface LoginListener {
        void login();
    }

    public interface LoginModel extends TemplateModel {
        // Elementos a usar para enviar al elemento
    }
}
