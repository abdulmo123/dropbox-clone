param storageName string = 'st001dbc'
param containerName string = 'dbc-files'
param storageLocation string = 'eastus2'

resource storageAccount 'Microsoft.Storage/storageAccounts@2026-04-01' = {
  name: storageName
  location: storageLocation
  sku: {
    name: 'Standard_LRS'
  }
  kind: 'BlobStorage'
  properties: {
    accessTier: 'Hot'
  }
}

resource blobService 'Microsoft.Storage/storageAccounts/blobServices@2026-04-01' = {
  name: 'default'
  parent: storageAccount
}

resource container 'Microsoft.Storage/storageAccounts/blobServices/containers@2026-04-01' = {
  name: containerName
  parent: blobService
  properties: {}
}
