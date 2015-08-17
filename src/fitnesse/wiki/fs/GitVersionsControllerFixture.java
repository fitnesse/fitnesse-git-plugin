package fitnesse.wiki.fs;

import java.io.File;

import org.eclipse.jgit.api.InitCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import util.FileUtil;

public class GitVersionsControllerFixture {
    public boolean initialiseGitRepository() throws GitAPIException {
        FileUtil.createDir(VersionsControllerFixture.TEST_DIR);
        new InitCommand()
                .setDirectory(new File(VersionsControllerFixture.TEST_DIR))
                .setBare(false)
                .call();
        return true;
    }

}
