targetScope = 'subscription'

param resourceGroupName string = 'dbc-rg'
param resourceGroupLocation string = 'eastus2'
param storageName string = 'st001dbc'
param storageLocation string = 'eastus2'

resource newRG 'Microsoft.Resources/resourceGroups@2025-04-01' = {
  name: resourceGroupName
  location: resourceGroupLocation
}

module storageAcct 'storage.bicep' = {
  name: 'storageModule'
  scope: newRG
  params: {
    storageName: storageName
    storageLocation: storageLocation
  }
}
