package lenala.azure.gradle.webapp.configuration;

import groovy.lang.Closure;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Deployment {
    private DeploymentType type;
    private String warFile;
    private String jarFile;
    private String contextPath;
    private String deploymentSlot;
    private List<FTPResource> resources = new ArrayList<FTPResource>();

    public DeploymentType getType() {
        return this.type;
    }

    public String getWarFile() {
        return this.warFile;
    }

    public String getJarFile() {
        return jarFile;
    }

    public String getDeploymentSlot() {
        return deploymentSlot;
    }

    public List<FTPResource> getResources() {
        return this.resources;
    }

    public void setResources(List<Closure> closures) {
        if (closures != null && !closures.isEmpty()) {
            closures.forEach(closure -> {
                FTPResource item = new FTPResource();
                org.gradle.util.ConfigureUtil.configure(closure, item);
                resources.add(item);
            });
        }
    }

    public String getContextPath() {
        return StringUtils.isEmpty(this.contextPath) ? "" : this.contextPath;
    }

    public void setType(DeploymentType type) {
        this.type = type;
    }

    public void setWarFile(String warFile) {
        this.warFile = warFile;
    }

    public void setJarFile(String jarFile) {
        this.jarFile = jarFile;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public void setDeploymentSlot(String deploymentSlot) {
        this.deploymentSlot = deploymentSlot;
    }

    public void setFTPResources(List<FTPResource> resources) {
        this.resources = resources;
    }
}
