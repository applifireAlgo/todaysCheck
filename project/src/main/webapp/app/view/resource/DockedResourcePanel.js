Ext.define('Project.view.resource.DockedResourcePanel', {
	extend : 'Ext.panel.Panel', //Ext.toolbar.Toolbar',
	xtype : 'dockedResourcePanel',
	itemId : 'dockedResourcePanel',

	requires : ['Project.view.resource.DockedResourcePanelController'],
	controller : 'dockedResourcePanelController',

	bodyStyle : {
		backgroundColor: "#212121"
	},

	bodyPadding : '20 0 0 0',	
	width : '3%',
	
	defaults : {
		width : '100%',
		arrowVisible : false,
		height : '7%'
	}
	
});
