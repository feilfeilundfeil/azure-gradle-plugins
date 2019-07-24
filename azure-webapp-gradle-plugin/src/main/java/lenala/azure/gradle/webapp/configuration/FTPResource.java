package lenala.azure.gradle.webapp.configuration;

import org.apache.commons.lang3.StringUtils;

public class FTPResource {
    private String sourcePath;
    private String targetPath;

    public String getSourcePath() {
        return sourcePath;
    }

    public String getTargetPath() {
        return StringUtils.isEmpty(targetPath) ? "" : targetPath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }
}
