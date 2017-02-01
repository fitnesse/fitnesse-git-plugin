package fitnesse.wiki.fs;

import fitnesse.wiki.BaseWikitextPage;
import fitnesse.wiki.PageData;
import fitnesse.wiki.VersionInfo;
import fitnesse.wiki.WikiPage;
import org.apache.commons.lang.NotImplementedException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GitRecentChangesPage extends BaseWikitextPage {
    private final PageData data;

    public GitRecentChangesPage(String name, WikiPage parent, PageData data) {
        super(name, parent);
        this.data = data;
    }

    @Override
    public WikiPage addChildPage(String name) {
        return null;
    }

    @Override
    public WikiPage getChildPage(String name) {
        return null;
    }

    @Override
    public void removeChildPage(String name) {

    }

    @Override
    public List<WikiPage> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public PageData getData() {
        return data;
    }

    @Override
    public Collection<VersionInfo> getVersions() {
        return Collections.emptyList();
    }

    @Override
    public WikiPage getVersion(String versionName) {
        return this;
    }

    @Override
    public VersionInfo commit(PageData data) {
        throw new NotImplementedException("Recent changes page can not be updated");
    }
}
