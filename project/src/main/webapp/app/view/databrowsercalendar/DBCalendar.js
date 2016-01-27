Ext.define('Project.view.databrowsercalendar.DBCalendar', {
	extend : 'Project.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Project.view.databrowsercalendar.DBCalendarController',
	             'Project.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
