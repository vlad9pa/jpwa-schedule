package com.vlad9pa.jpwaschedule.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vlad9pa.jpwaschedule.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Route("")
@Component
@Scope("prototype")
public class MainView extends VerticalLayout {

    private final ScheduleService scheduleService;

    private Boolean inOffice;

    @Autowired
    public MainView(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;

        inOffice = scheduleService.isInOffice();

        Label label = new Label("Welcome back");

        Button actionButton = new Button(buttonMsg());

        actionButton.addClickListener(buttonClickEvent -> {

            if(inOffice){
                scheduleService.leaveOffice();
                inOffice = false;
            }else{
                scheduleService.comeToOffice();
                inOffice = true;
            }

            actionButton.setText(buttonMsg());
            Notification.show("Recorded");
        });

        Button changeViewButton = new Button();
        changeViewButton.setText("Look at schedule");
        changeViewButton.addClickListener(buttonClickEvent -> {
            Notification.show("Not yet implemented");
        });

        add(label);
        add(actionButton);
        add(changeViewButton);
    }


    private String buttonMsg(){
        log.info("inOffice = {}", inOffice);
        log.info("service.inOffice = {}", scheduleService.isInOffice());
        return inOffice ? "Leave" : "Come";
    }
}
