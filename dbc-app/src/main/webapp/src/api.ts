import type { CreateFolderRequest, FolderResponse } from "./types";

const BACKEND_URL = "http://localhost:8080"

export async function createFolder(createFolderRequest: CreateFolderRequest): Promise<FolderResponse> {
    const response = await fetch(`${BACKEND_URL}/api/v1/folder/create`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(createFolderRequest),
    });

    if (!response.ok) {
        throw new Error("Post creation failed!");
    }

    return response.json();
}