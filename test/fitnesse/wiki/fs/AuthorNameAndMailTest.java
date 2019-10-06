package fitnesse.wiki.fs;

import fitnesse.wiki.VersionInfo;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.util.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AuthorNameAndMailTest {
    private static final String GIT_TEST_DIR = "src/test/resources/simple/";
    public static final int RECURSIVE = 1;
    private Git git;

    @Before
    public void setUp() throws GitAPIException {
        git = Git.init().setDirectory(new File(GIT_TEST_DIR)).call();
    }

    @After
    public void tearDown() throws IOException {
        FileUtils.delete(new File(GIT_TEST_DIR), RECURSIVE);
    }
    @Test
    public void testAuthorNameAndeMailFromSystemPropertiesAreUsedInCommit() throws IOException, GitAPIException {
        //given
        System.setProperty("AUTHOR_NAME", "John Doe");
        System.setProperty("AUTHOR_EMAIL", "a@b.c");
        File file = new File(GIT_TEST_DIR + "test.txt");
        FileVersion versions = new GitFileVersionsController.GitFileVersion(file, "test".getBytes(), new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

        //when
        new GitFileVersionsController().makeVersion(versions);
        RevCommit revCommit = git.log().call().iterator().next();

        //then
        assertThat(revCommit.getAuthorIdent().getName(), is("John Doe"));
        assertThat(revCommit.getAuthorIdent().getEmailAddress(), is("a@b.c"));
    }
}
