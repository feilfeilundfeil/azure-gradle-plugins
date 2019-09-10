package lenala.azure.gradle.webapp;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import static lenala.azure.gradle.webapp.AzureWebAppExtension.WEBAPP_EXTENSION_NAME;

public class AzureWebappPlugin implements Plugin<Project> {
    public void apply(Project project) {
        AzureWebAppExtension azureWebAppExtension = new AzureWebAppExtension(project);
        project.getExtensions().add(WEBAPP_EXTENSION_NAME, azureWebAppExtension);
        project.getTasks().create(DeployTask.TASK_NAME, DeployTask.class, (task) -> {
            task.setGroup("publishing");
            task.setAzureWebAppExtension(azureWebAppExtension);
        });
        project.getTasks().create(ZipCreateTask.TASK_NAME_ZIP, ZipCreateTask.class, (task) -> {
            task.setGroup("publishing");
            task.setAzureWebAppExtension(azureWebAppExtension);
        });
    }
}
