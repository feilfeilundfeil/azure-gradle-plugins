package lenala.azure.gradle.webapp.configuration;

import com.microsoft.azure.management.appservice.WebApp;

import java.io.File;

public class ZipDeployTarget extends DeployTarget<WebApp> {
    public ZipDeployTarget(final WebApp app) {
        super(app, DeployTargetType.ZIP);
    }

    @Override
    public void zipDeploy(File file) {
    }
}
