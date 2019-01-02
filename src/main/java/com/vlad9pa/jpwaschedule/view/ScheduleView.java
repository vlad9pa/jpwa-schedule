package com.vlad9pa.jpwaschedule.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vlad9pa.jpwaschedule.entity.Person;
import com.vlad9pa.jpwaschedule.entity.Schedule;
import com.vlad9pa.jpwaschedule.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope("prototype")
@Route("schedule")
public class ScheduleView extends HorizontalLayout {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleView(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
        Grid<Schedule> scheduleGrid = new Grid<>();

        scheduleGrid.setItems(scheduleService.findAllInMonth());
        scheduleGrid.addColumn(Schedule::getComeDate).setHeader("Come");
        scheduleGrid.addColumn(Schedule::getLeaveDate).setHeader("Leave");


        Button mainViewButton = new Button("Main View");

        mainViewButton.addClickListener(buttonClickEvent -> {
            mainViewButton.getUI().ifPresent(ui -> ui.navigate(""));
        });

        add(mainViewButton);
        add(scheduleGrid);
    }
}
