package lenala.azure.gradle.webapp;

import lenala.azure.gradle.webapp.auth.AuthConfiguration;
import lenala.azure.gradle.webapp.configuration.DeployTarget;
import lenala.azure.gradle.webapp.configuration.ZipDeployTarget;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.TaskExecutionException;

public class ZipCreateTask extends DeployTask implements AuthConfiguration {
    public static final String TASK_NAME_ZIP = "azureCreateZip";

    @TaskAction
    @Override
    void deploy() {
        try {
            getLogger().quiet("Creating ZIP file");
            try {
                util.beforeDeployArtifacts();

                DeployTarget target = new ZipDeployTarget(getWebApp());

                if (getFactory().getArtifactHandler(this) != null) {
                    getFactory().getArtifactHandler(this).publish(target);
                }
            } finally {
                util.afterDeployArtifacts();
            }
            getLogger().quiet("Success");
        } catch (Exception ex) {
            throw new TaskExecutionException(this, ex);
        }
    }
}
