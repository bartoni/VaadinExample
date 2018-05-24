package PPA;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import javafx.scene.layout.VBox;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    Component firstnameValueLabel;
    Component lastnameValueLabel;
    Component myHeaderComponent;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        GridLayout grid = new GridLayout(2, 1);
        grid.setMargin(true);

        grid.setWidth(500, Sizeable.UNITS_PIXELS);
        grid.setHeight(500, Sizeable.UNITS_PIXELS);

        VerticalLayout vert = new VerticalLayout();

        Label title = new Label("Co lubisz jesc?");
        vert.addComponentsAndExpand(title);

        CheckBox banany = new CheckBox("banany");
        banany.setValue(true);
        vert.addComponentsAndExpand(banany);

        CheckBox kimchi = new CheckBox("kimchi");
        kimchi.setValue(true);
        vert.addComponentsAndExpand(kimchi);


        CheckBox donuts = new CheckBox("paczki");
        donuts.setValue(true);
        vert.addComponentsAndExpand(donuts);

        Button next = new Button("Dalej, powiedz mi kim jestem");
        next.addClickListener(clickEvent -> Notification.show("Poczekaj"));
        vert.addComponentsAndExpand(next);

        grid.addComponent(vert, 0,0);

        setContent(grid);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
