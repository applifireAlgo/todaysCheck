Ext.define('Project.project.shared.project.model.multitenant.customers.AppCustomerModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "appCustomerId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "customerName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "contactid",
          "reference": "CoreContacts",
          "defaultValue": ""
     }, {
          "name": "appcustomertype",
          "reference": "AppCustomerType",
          "defaultValue": ""
     }, {
          "name": "appcustomercategory",
          "reference": "AppCustomerCategory",
          "defaultValue": ""
     }, {
          "name": "deploymentModel",
          "type": "boolean",
          "defaultValue": ""
     }, {
          "name": "customerStatus",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "userRequested",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "evalTimePeriod",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});