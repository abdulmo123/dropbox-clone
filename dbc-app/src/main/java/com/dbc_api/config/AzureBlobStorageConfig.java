package com.dbc_api.config;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureBlobStorageConfig {

    @Value("${spring.cloud.azure.storage.container.name}")
    private String azureContainerName;

    @Value("${spring.cloud.azure.storage.connection.string}")
    private String azureConnectionString;

/*    @Value("${AZURE_CLIENT_ID}")
    private String azureClientId;

    @Value("${AZURE_TENANT_ID}")
    private String azureTenantId;

    @Value("${AZURE_CLIENT_SECRET}")
    private String azureClientSecret;*/

    /*@Bean
    public BlobServiceClient getBlobServiceClient() {
        ClientSecretCredential credential = new ClientSecretCredentialBuilder()
                .tenantId(azureTenantId)
                .clientId(azureClientId)
                .clientSecret(azureClientSecret)
                .build();

        return new BlobServiceClientBuilder()
            .endpoint("https://" + azureContainerName + ".blob.core.windows.net")
            .credential(credential)
            .buildClient();

    }*/

    @Bean
    public BlobServiceClient blobServiceClient() {
        return new BlobServiceClientBuilder()
                .connectionString(azureConnectionString)
                .buildClient();
    }

    @Bean
    public BlobContainerClient blobContainerClient(BlobServiceClient serviceClient) {
        return serviceClient.getBlobContainerClient(azureContainerName);
    }
}
