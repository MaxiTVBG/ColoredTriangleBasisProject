# ColoredTriangleBasisProject

This is the original project, adapted for macOS and IntelliJ users.

## Setup Instructions for IntelliJ (macOS):

1.  **Run `Main` First:** Execute the `Main.java` file once. This will likely result in an error, but it's necessary to generate the run configuration.
2.  **Edit Run Configuration:** Go to `Run` -> `Edit Configurations...`.
3.  **Add VM Options:** In the `VM options` field, add the following:
    ```
    -XstartOnFirstThread
    ```
4.  **Add External Libraries Manually:** Ensure all necessary external libraries (e.g., LWJGL) are added manually to the project's module dependencies. Refer to the project's build system or documentation for specific library requirements and versions.
